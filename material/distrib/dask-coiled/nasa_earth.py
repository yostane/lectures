# Source: https://coiled.io/example/nasa-cloud-datasets

import coiled
import os
import tempfile
import earthaccess
import numpy as np
import xarray as xr
import matplotlib.pyplot as plt

# Create a free NASA Earthdata account (https://urs.earthdata.nasa.gov/)
try:
    earthaccess.login()
except:
    print("login failed")
    exit(1)

# Step 2: Find the dataset files we want to analyze
granules = earthaccess.search_data(
    short_name="MUR-JPL-L4-GLOB-v4.1",  # Sea Surface Temperature dataset
    temporal=("2020-01-01", "2021-12-31"),  # Two years of data
)

# Delete processing to coiled


@coiled.function(
    region="us-west-2",                  # Run in the same region as data
    environ=earthaccess.auth_environ(),  # Forward Earthdata auth to cloud VMs
    spot_policy="spot_with_fallback",    # Use spot instances when available
    arm=True,                            # Use ARM-based instances
    cpu=1,                               # Use single-core instances
)
def process(granule):
    """Process a single data granule to extract Great Lakes temperature data"""
    results = []
    with tempfile.TemporaryDirectory() as tmpdir:
        files = earthaccess.download(granule, tmpdir)
        for file in files:
            ds = xr.open_dataset(os.path.join(tmpdir, file))
            # Select Great Lakes region by longitude/latitude
            ds = ds.sel(lon=slice(-93, -76), lat=slice(41, 49))
            # Filter for water temperature (exclude ice-covered areas)
            cond = (ds.sea_ice_fraction < 0.15) | np.isnan(ds.sea_ice_fraction)
            result = ds.analysed_sst.where(cond)
            results.append(result)
    return xr.concat(results, dim="time")


# Step 4: Run processing across all files in parallel
results = process.map(granules)

# Step 5: Combine results and visualize
ds = xr.concat(results, dim="time")

# Calculate temperature standard deviation across time
plt.figure(figsize=(14, 6))
std_temp = ds.std("time")
std_temp.plot(x="lon", y="lat", cmap="viridis")
plt.title("Standard Deviation of Sea Surface Temperature (2020-2021)")
plt.xlabel("Longitude")
plt.ylabel("Latitude")
plt.savefig("great_lakes_sst_variation.png")
plt.show()
