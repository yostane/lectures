import matplotlib.pyplot as plt


def fx_square(x):
    return x**2


def fx_square_list(n):
    items = []
    for i in range(n):
        items.append(fx_square(i))
    return items


def plot_f(n):
    plt.plot(range(n), fx_square_list(n))
    plt.show()


n = 88
print(fx_square_list(n))
plot_f(n)


# exemple de liste points: [-3, 0, 1, 4, 5]
# Exemple de sortie attendue [9, 0, 1, 16, 25]


def fx_square_list2(points):
    values = []
    for point in points:
        values.append(point**2)
    return values


points = range(-100, 100)
values = fx_square_list2(points)
plt.plot(points, values)
plt.show()
