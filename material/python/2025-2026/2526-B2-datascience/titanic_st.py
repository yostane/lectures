import streamlit as st
import pandas as pd

st.write("Streamlit demo")

x = st.slider('x')  # 👈 this is a widget
st.write(x, 'squared is', x * x)

df = pd.read_csv("titanic.csv")
st.write(df)

st.write(df["Survived"].value_counts())

st.line_chart(df["Age"])
