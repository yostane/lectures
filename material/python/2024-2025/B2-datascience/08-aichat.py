import streamlit as st
from langchain_google_genai import ChatGoogleGenerativeAI

system_message = (
    "system", """You are a weather specialist. 
    The human provides humidity and temperature. 
    Can you explain the results and comment on the air condition in the house.
    Please provide a short answer in two sentences.
    """)
googleai_api_key = st.sidebar.text_input("Google AI API Key", type="password")

# Arrêter l'application streamlit si pas de clé d'API
if len(googleai_api_key) == 0:
    st.error("No API key")
    st.stop()

st.title("AI weather analyst")
llm = ChatGoogleGenerativeAI(
    model="gemini-2.0-flash-lite", api_key=googleai_api_key)

with st.form("my_form"):
    text = st.text_area("Prompt:")
    submitted = st.form_submit_button("Submit")

if submitted:
    human_message = ("human", text)
    response = llm.invoke([system_message, human_message])
    st.info(response.content)
