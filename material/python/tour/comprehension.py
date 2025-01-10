items = [0, 1, 2, 3, 4]

# Double de chaque élément
double_items_1 = []
for item in items:
    double_items_1.append(item * 2)
print("double_items_1", double_items_1)

# Transformer (to map en Anglais) avec les compréhensions
results = [item * 2 for item in items]
print(results)
print([item * 2 for item in items])
# puissance 4 des entier entre -2 et 9 avec un pas de 2
print([item**4 for item in range(-2, 10, 2)])

# Filtrage
# Garder uniquement les éléments pairs
items = [9, 22, -2, 11, 1232, 2323]
print([item for item in items if item % 2 == 0])

# Equivalent avec un boucle for
results = []
for item in items:
    if item % 2 == 0:
        results.append(item)
print(results)

# Garder uniquement les éléments pairs et les multiplier par 3
print([item * 3 for item in items if item % 2 == 0])

messages = ["Hello", "J'aime", "Python"]
print([len(message) for message in messages])
print([f"{message}." for message in messages])
# Dict (dictionnaire)
print({message: len(message) for message in messages})
# Set ensemble
print({len(message) for message in messages})

# Card game from ranks and symbols
ranks = range(1, 11)
symbols = ["💗", "♠️", "🍀", "🔶"]
# Produit cartésien
print([f"{r}{s}" for r in ranks for s in symbols])

m = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
print([item for row in m for item in row])
row_count = range(len(m))
print([f"m[{i}, {j}] => {m[i][j]}" for i in row_count for j in range(len(m[i]))])

# Equivalent en for
result = []
for i in row_count:
    for j in range(len(m[i])):
        result.append(f"m[{i}, {j}] => {m[i][j]}")
print("Tranformation matrice vers liste avec for", result)

# Pour faire une compréhension de tuple, il faut utiliser tuple()
print(tuple(x + 6 for x in range(10)))