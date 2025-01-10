# 1
print([x for x in range(0, 20, 2)])
print([x for x in range(0, 20) if x % 2 == 0])

# 2
print({x: "even" if x % 2 == 0 else "odd" for x in range(10)})


def get_parity(x):
    if x % 2 == 0:
        return "even"
    else:
        return "odd"


print({x: get_parity(x) for x in range(10)})

# 3
print({str(x): "even" if x % 2 == 0 else "odd" for x in range(10)})
print({f"{x}": "even" if x % 2 == 0 else "odd" for x in range(10)})

# 4
numbers = {f"{x}": "even" if x % 2 == 0 else "odd" for x in range(10)}
print({key: value for key, value in numbers.items() if int(key) % 2 != 0})

# 5
print((x for x in range(0, 40, 2)))

# cartes
symbols = ("♥️", "♠️", "♣️", "♦️")
ranks = ["As", "Roi", "Reine", "Valet"] + [*range(2, 11)]

cards = [(symbol, rank) for symbol in symbols for rank in ranks]
print(cards)

# 6
students = [
    {"name": "Olive", "birth_year": 2001},
    {"name": "Tom", "birth_year": 1975},
    {"name": "Alf", "birth_year": 1701},
]
print({x["name"] for x in students})
print(tuple(x["birth_year"] for x in students))
