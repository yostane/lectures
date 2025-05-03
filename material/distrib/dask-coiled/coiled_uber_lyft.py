import coiled
import dask.dataframe as dd

cluster = coiled.Cluster(n_workers=10)
client = cluster.get_client()
print(client)

# Load the Uber-Lyft Taxi dataset from s3 (200 GB)
df = dd.read_parquet("s3://coiled-data/uber/")
# How often do New Yorkers tip?
(df.tips != 0).mean().compute()
