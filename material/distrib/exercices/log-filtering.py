from pyspark.sql import SparkSession
from pyspark.sql.dataframe import DataFrame

logFile = "log-filtering-input.txt"
spark: SparkSession = SparkSession.builder.appName("log-filtering").getOrCreate()
logData: DataFrame = spark.read.text(logFile).cache()

df = logData.filter(logData.value.contains('google'))

df.show(df.count())

df.write.save("log-filtering-output", format="text", mode="overwrite")

spark.stop()