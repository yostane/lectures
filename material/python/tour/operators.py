# https://www.w3schools.com/python/python_operators.asp

x = 15
print("puissance", x**10, "partie entière de la division", x // 4)

# * a plus de priorité par rapport à +
print(1 + 2 * 3)

print(10 < x and x < 20, "est equivalent à", 10 < x < 20)

c = ((i, j) for i in (True, False) for j in (True, False))

for i, j in c:
    print(i, "and", j, i and j)
    print(i, "or", j, i or j)
    print("not", i, not j)

print(10 in range(50))
print(10 in range(0, 50, 3))
print(10 not in [1, 2, 10, 33])

# && -> and (attention & a un comportement différent)
