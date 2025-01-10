from transformers import AutoModelForCausalLM, AutoTokenizer
import torch


tokenizer = AutoTokenizer.from_pretrained("microsoft/DialoGPT-small")
model = AutoModelForCausalLM.from_pretrained("microsoft/DialoGPT-small")

rag = """Vous êtes un assistant IA utile et qui connait tout ce qu'il faut savoir sur une école qui s'appelle ynov basées sur ces informations:
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
"""

chat_history_ids = None
new_user_input_ids = tokenizer.encode(rag + tokenizer.eos_token, return_tensors='pt')
bot_input_ids = new_user_input_ids
chat_history_ids = model.generate(bot_input_ids, max_length=len(rag), pad_token_id=tokenizer.eos_token_id)
print("DialoGPT: {}".format(tokenizer.decode(chat_history_ids[:, bot_input_ids.shape[-1]:][0], skip_special_tokens=True)))

# Let's chat for 5 lines
for step in range(1, 5):
    # encode the new user input, add the eos_token and return a tensor in Pytorch
    new_user_input_ids = tokenizer.encode(input(">> User:") + tokenizer.eos_token, return_tensors='pt')

    # append the new user input tokens to the chat history
    bot_input_ids = torch.cat([chat_history_ids, new_user_input_ids], dim=-1) if step > 0 else new_user_input_ids

    # generated a response while limiting the total chat history to 1000 tokens, 
    chat_history_ids = model.generate(bot_input_ids, max_length=1000, pad_token_id=tokenizer.eos_token_id)

    # pretty print last ouput tokens from bot
    print("DialoGPT: {}".format(tokenizer.decode(chat_history_ids[:, bot_input_ids.shape[-1]:][0], skip_special_tokens=True)))
