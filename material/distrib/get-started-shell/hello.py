from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("hello").getOrCreate()
print("hello")
spark.stop()