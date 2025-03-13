from pyspark.sql import SparkSession

exercise_name = "log-analysis"
logFile = f"{exercise_name}-input.txt"
spark = SparkSession.builder.appName(exercise_name).getOrCreate()
logData = spark.read.text(logFile).cache()

df = logData.filter(logData.value.contains('google'))

df.show(df.count())

df.write.save(f"{exercise_name}-output", format="text", mode="overwrite")

spark.stop()