from pyspark.sql import SparkSession, DataFrame, Row, functions as sf

exercise_name = "log-analysis"
logFile = f"{exercise_name}-input.txt"
spark: SparkSession = SparkSession.builder.appName(exercise_name).getOrCreate()
logData: DataFrame = spark.read.text(logFile).cache()

df = logData.filter(logData.value.contains('google'))
df = df.select(sf.split(df.value, "\\s+").getItem(0).alias("IP")).distinct()

df.show(df.count())
df.write.save(f"{exercise_name}-output", format="text", mode="overwrite")

spark.stop()