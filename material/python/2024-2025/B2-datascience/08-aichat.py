import streamlit as st
from langchain_google_genai import ChatGoogleGenerativeAI

system_message = (
    "system", "You are an assistant that translated Eglish to French. Translate the user sentence")
googleai_api_key = st.sidebar.text_input("Google AI API Key", type="password")

# Arrêter l'application streamlit si pas de clé d'API
if len(googleai_api_key) == 0:
    st.error("No API key")
    st.stop()

st.title("Traduction avec IA")
llm = ChatGoogleGenerativeAI(
    model="gemini-2.0-flash-lite", api_key=googleai_api_key)

with st.form("my_form"):
    text = st.text_area("Prompt:")
    submitted = st.form_submit_button("Submit")

if submitted:
    human_message = ("human", text)
    response = llm.invoke([system_message, human_message])
    st.info(response.content)
