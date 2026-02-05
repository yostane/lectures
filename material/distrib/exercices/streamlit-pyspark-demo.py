from pyspark.sql import SparkSession, DataFrame
import streamlit as st

spark: SparkSession = SparkSession.builder.appName(
    "streamlit-pyspark").getOrCreate()
logData = spark.read.csv("max-value-input.csv")

st.write("Hello Pyspark")
st.dataframe(logData.toPandas())
