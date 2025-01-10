# https://huggingface.co/docs/api-inference/quicktour#get-your-api-token -> générer un token en read
# https://huggingface.co/docs/api-inference/detailed_parameters#text-generation-task

import requests
import os

API_TOKEN = os.environ["HUGGINGFACE_API_KEY"]
API_URL = "https://api-inference.huggingface.co/models/gpt2"
headers = {"Authorization": f"Bearer {API_TOKEN}"}


def query(payload):
    response = requests.post(API_URL, headers=headers, json=payload)
    return response.json()


data = query({"inputs": "The answer to the universe is"})

print(data)
print(data[0]["generated_text"])
