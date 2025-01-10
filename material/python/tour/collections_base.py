# List: éléments ordonnées. Chauqe élément est défini par sont indice
numbers = [3, 4, -3, "hello", True, 390]
numbers.append(10)
numbers.append(100)
numbers.remove(3)
print(numbers)
print(numbers[0], numbers[-1], numbers[-2])

print(numbers[0:3], numbers[:3], numbers[1:5])
print(numbers[-3:-1], numbers[2:])

for number in numbers:
    print(number)

for i in range(len(numbers)):
    print(i, numbers[i])

# Dictionnaires: élements identidifiés par une clé (on parle aussi de couples clé/valeur)
pokemon1 = {"name": "Pikachu", "hp": 10, "type": "Thunder", 5: "une valeur"}
print(
    pokemon1,
    pokemon1["name"],
    pokemon1["type"],
    pokemon1[5],
    "name" in pokemon1,
    "surname" in pokemon1,
)

for key, value in pokemon1.items():
    print(key, value)

# Set (ensemble) : élements non ordonnées et uniques
messages = {"hello", "world", 2023}
print(messages, "hello" in messages, 2024 in messages)
messages.add(2023)
print(messages)

for message in messages:
    print(message)

# Tuple : éléments ordonnées immutable (on ne peut ajouter ou supprimer d'éléments). On peut le considérer comme une liste immutable
n1 = (12, 34, 55, 33)
print(n1, n1[2:])

for item in n1:
    print(item)

for i in range(len(n1)):
    print(i, n1[i])
