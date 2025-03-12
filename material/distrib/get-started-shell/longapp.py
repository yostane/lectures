"""longapp.py"""
from pyspark.sql import functions as sf
from pyspark.sql import SparkSession
import time

log_file = "hello-long.txt"  # Should be some file on your system
spark = SparkSession.builder.appName("longapp").getOrCreate()
log_data = spark.read.text(log_file).cache()

a_count = log_data.filter(log_data.value.contains('a')).count()
word_counts = log_data.select(sf.explode(sf.split(log_data.value, "\\s+")).alias("word")).groupBy("word").count().collect()

print(f"Lines with a: {a_count}, word count {word_counts}")

time.sleep(1000000)
spark.stop()