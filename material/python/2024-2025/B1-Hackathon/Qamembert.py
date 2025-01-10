from transformers import pipeline
from mdeberta_utils import Reply, ynov_context

class Qamembert:
    def __init__(self) -> None:
        self.qa_model = pipeline('question-answering', model='CATIE-AQ/QAmembert-large', tokenizer='CATIE-AQ/QAmembert-large')
    
    def answer(self, question: str) -> Reply:
        return self.qa_model(question=question, context=ynov_context)

