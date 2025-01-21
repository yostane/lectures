print("Hello world", "2025", "J'aime 🐍")
print(5 + 10, -20, 44551 / 4, 63 * 3)
# % (modulo) donne le reste de la division
print(21 % 7, 21 % 4, 100 % 9)
"""** permet de calculer la puissance"""
print(9 ** 3, 3 ** 8, 2 ** 6)
# Les varibles permettent de mettre des informations de côté
# L'opérateur = (opérateur d'affectation) permet de copier une valeur dans une variable
a = 10 # Ici on (affecte ou assinge) 10 à la variable "a"
b = "Hello"
c = -2
print(a, a * 2, a + c)
print(b)
# Les variables sont typées en Python
a = 10 # a est un entier (en Anglais integer prononcé intigeur)
b = "Hello" # b est une chaîne de caractères (en Anglais string)
c = -2 # c est un entier
d = True
e = False # d et e sont des boolées (ne peut valoir que True ou False)
# opérateurs qui retournent un booléen = et == sont différents
# Opérateur binaires (qui prennenent deux opérandes)
print(10 > 1, a < c, d == e, c >= 5, a <= 0)

# input récupère la saisie de l'utilisateur et le = l'affecte à user_input
user_input = input("Veuillez saisir quelque chose : ")
print("L'utilisateur a saisi", user_input)

# int permet de convertir une chaine de caractères comportant des chiffres vers un entier
print('int("20") + 10 ->', int("20") + 10)

x = int(input("Veuillez saisir un nombre : "))
print(x + 10)

# Exercice: demander à l'utilisateur de saisir un entier et affiche "gagné" si le nombre est > 10, sinon "perdu"
x = int(input("Veuillez saisir un nombre : "))
if x > 10:
  print("gagné")
else:
  print("perdu")