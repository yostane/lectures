import numpy as np
import pandas as pd

import dask.dataframe as dd
import dask.array as da
import dask.bag as db

index = pd.date_range("2021-09-01", periods=2400, freq="1h")
df = pd.DataFrame({"a": np.arange(2400), "b": list("abcaddbe" * 300)}, index=index)
ddf = dd.from_pandas(df, npartitions=10)
