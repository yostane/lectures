from transformers import pipeline
from mdeberta_utils import anwser

reply = anwser("C'est quoi les ydays ?")
print("score:", reply["score"], "anwser:", reply["answer"])