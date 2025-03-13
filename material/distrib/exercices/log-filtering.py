from pyspark.sql import SparkSession

logFile = "log-filtering-input.txt"
spark = SparkSession.builder.appName("log-filtering").getOrCreate()
logData = spark.read.text(logFile).cache()

df = logData.filter(logData.value.contains('google'))

df.show(df.count())

df.write.save("log-filtering-output", format="text", mode="overwrite")

spark.stop()