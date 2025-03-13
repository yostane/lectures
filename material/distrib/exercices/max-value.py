from pyspark.sql import SparkSession

logFile = "log-filtering-input.txt"
spark = SparkSession.builder.appName("max-value").getOrCreate()


spark.stop()