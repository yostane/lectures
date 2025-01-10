from typing import NamedTuple, TypedDict
from transformers import pipeline

ynov_context = """Vous êtes un assistant IA utile et qui connait tout ce qu'il faut savoir sur une école qui s'appelle ynov
     basées sur ces informations:
     - Les Ydays , pépinières de projets
L'objectif des Ydays est de permettre aux étudiants de mettre en pratique leurs compétences et leurs connaissances dans un environnement collaboratif et stimulant, tout en développant leur créativité et en renforçant leur expérience professionnelle. 

C'est également l'occasion pour les étudiants de travailler en équipe et de collaborer avec des experts de l'industrie et des professionnels du secteur.

Les Ydays offrent aux étudiants l'opportunité de concrétiser leurs idées et de développer des projets concrets qui peuvent avoir un impact réel dans leur domaine d'études.
     Qui sommes nous
Anil BENARD-DENDE rencontre Michel DENISOT
Ynov, l’école innovante dédiée aux métiers de demain
YNOV investit en faveur d’une pédagogie active qui prépare les étudiants à devenir les futurs talents d’une économie innovante. Au sein de nos campus, les étudiants se donnent les moyens d’acquérir les compétences dont ils auront besoin pour développer leur profil et s’épanouir dans le monde de demain.

Apprendre en faisant
Notre pédagogie consiste à mixer des enseignements avec des projets qui permettent de mettre les étudiants au coeur d’une situation réelle et les placer en position d’acteur.

En plus des cours enseignés par des intervenants professionnels, les étudiants participent dès leur entrée aux Ymmersions (3 semaines de quêtes autonomes qui leur permettent d’oser tenter, d’oser échouer et d’oser réussir).

Tout au long de l’année ils participent aux YDAYS autour d’un projet commun.

Challenges 48H, concours, expositions, …

Les Ydays
notre pédagogie
Notre pédagogie
Un cursus adapté à chaque profil
Nos étudiants peuvent adapter leur cursus et choisir leur spécialité parmi 23 Bachelors et 28 Mastères :

Informatique, Marketing & Communication, Création & Digital Design, Tech & Business, 3D, Animation & Jeux Vidéo, Audiovisuel, Architecture d’intérieur, Cybersécurité.

Chez YNOV, l’entreprise participe activement
Au delà des intervenants qui transmettent leurs expériences à nos étudiants; ils ont la possibilité de commencer leur carrière dès la 3e année de leur bachelor s’ils choisissent de suivre leur formation en alternance.

Coralie, Community Manager
L’intelligence collective au service du numérique
La pluridisciplinarité fait notre force, et sera un atout majeur pour les prochaines générations. S’intéresser et apprendre plusieurs disciplines permet de s’ouvrir davantage aux besoins des entreprises à la recherche de profils complémentaires et curieux. Toutes ces disciplines trouvent leur ancrage dans le numérique, qui apparaît comme un élément fédérateur qui rapproche les personnes et gomme les différences.

Tremplin pro
Un tremplin vers la professionnalisation
Nos cursus sont conçus dès la première année pour permettre à nos étudiants de s’ouvrir au monde du travail et de découvrir l’univers de l’entreprise.

La valeur ajoutée d’YNOV réside incontestablement dans l’accompagnement proposé aux étudiants dans cette démarche. Grâce à une équipe dédiée sur chaque campus et des outils spécialisés visant à faciliter leur placement en entreprise, tout est mis en œuvre pour leur assurer une expérience en phase avec leur projet professionnel.

Et la reconnaissance de votre expérience
YNOV propose des parcours en VAE pour valoriser vos compétences professionnelles et valider un titre, de niveau 7 ou 6 enregistré au RNCP.

Focus Compétence
Ynov Recrute
Accédez aux offres d'emploi
Ynov CAPC
85%
des entreprises recommandent YNOV comme organisme de formation*

87%
des entreprises trouvent que le contenu de la formation proposé par Ynov est pertinent au regard des compétences à développer par les apprenants dans le cadre de leur activité professionnelle*

*Enquête réalisée en Juin 2022 auprès de 3356 entreprises, sur la base de 389 entreprises ayant répondu
"""

qa_model = pipeline("question-answering", "timpal0l/mdeberta-v3-base-squad2")

class Reply(TypedDict):
    answer: str
    score: int
    start: int
    end: int

def anwser(question: str) -> Reply:
    return qa_model(question = question, context = ynov_context)