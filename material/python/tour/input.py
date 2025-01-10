v = input("Veuillez saisir quelque chose svp")
print("la valeur saisie est", v, type(v))

try:
    i = int(v)
    print("la valeur convertie en entier est", i, type(i))
except Exception:
    print("oups")

print("fin")
