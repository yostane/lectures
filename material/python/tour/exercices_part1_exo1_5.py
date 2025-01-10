n = int(input("Saisir un entier : "))

print(n, "est", "pair" if n % 2 == 0 else "impair")
print(("pair", "impair")[n % 2])

somme_n = 0
for i in range(n + 1):
    somme_n += i

print("Somme des", n, "premiers entiers", somme_n)

for i in range(1, n):
    if n % i == 0:
        print(i, "est un diviseur de", n)
