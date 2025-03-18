import streamlit as st
import pandas as pd
import numpy as np

st.title("Hello streamlit")


titanic = pd.read_csv("titanic.csv")

fare_to_filter = st.slider(
    "Max Fare", titanic.Fare.min(), titanic["Fare"].max())
titanic = titanic[titanic["Fare"] < fare_to_filter]

tabs = st.tabs(["Dataframe", "Histogram"])
tabs[0].subheader('Raw data')
tabs[0].write(titanic)

tabs[1].subheader('Number of passengers per class')
hist_values = np.histogram(titanic["Pclass"], bins=3, range=(1, 3))[0]
tabs[1].bar_chart(hist_values)
