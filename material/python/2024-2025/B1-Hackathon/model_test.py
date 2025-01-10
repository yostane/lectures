import Qamembert
from qa_bot.qa_webapp.utils.mdeberta_utils import answer


questions = [
    "Quels cursus sont proposés par Lille Ynov Campus ?", 
    "C'est quoi ynov ?", 
    "Quelles sont les conditions d’admission dans l’école ?",
    "Quand se déroulera les prochaines portes ouvertes ?",
    "Comment puis-je contacter le service des admissions ?"]

print("quamembert")
qam = Qamembert.Qamembert()
for q in questions:
    print(q, qam.answer(q))

print("mdbertav")
for q in questions:
    print(q, answer(q))
