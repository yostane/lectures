print([1, 2, 3] * 3)
print("hello" * 2)
print(len([1, 2, 3]), len([1, 2, 3] * 3), len("hello"))


# abcdefghij
# ligne 0 -> a on prend la sous-chaine (0, 1)
# ligne 1 -> bc (1, 3)
# ligne 2 -> def (3, 6)
# ligne 3 -> ghij (6, 10)
# ligne l -> (indice courant dans la chaine, indice courant + l + 1)
# indice courant s'incrémente à chaque fois de l + 1


def print_pyramide(input):
    i = 0
    current_line = 0
    while i + current_line + 1 < len(input):
        print(input[i : i + current_line + 1])
        i += current_line + 1
        current_line += 1


print_pyramide("abcdefghij")
print_pyramide("abcdefghijklmnopqrstuvwxyz")
print_pyramide("abcdefghijklmnopqrstuvwxyz" * 10)


def count_letters1(input):
    dict = {}
    for letter in input:
        if letter in dict:
            dict[letter] += 1
        else:
            dict[letter] = 1
    return dict


def count_letters2(input):
    dict = {}
    for letter in input:
        dict[letter] = dict.get(letter, 0) + 1
    return dict


def count_letters3(input):
    dict = {}
    for letter in input:
        dict[letter] = dict[letter] + 1 if letter in dict else 1
    return dict


print(count_letters1("hello"))
print(count_letters2("hello"))
print(count_letters3("hello"))


def is_intersect_1D(x1, l1, x2, l2):
    # Dans d'autres langages, il aurait fallu écrire (On ne peut pas combiner les inégalités)
    # x1 < x2 && x2 < x1 + l1 || x2 < x1 && x1 < x2 + l2
    return x1 <= x2 <= x1 + l1 or x2 <= x1 <= x2 + l2


print(is_intersect_1D(0, 10, 3, 1))
print(is_intersect_1D(2, 5, 10, 4))
print(is_intersect_1D(-2, 5, 10, 4))
print(is_intersect_1D(0, 10, -10, 20))
print(is_intersect_1D(100, 1, -5, 1000))
print(is_intersect_1D(100, 1, -5, 106))
print(is_intersect_1D(100, 1, -5, 99))


def is_intersect_2D(rec1, rec2):
    return is_intersect_1D(
        rec1["x"], rec1["width"], rec2["x"], rec2["width"]
    ) and is_intersect_1D(rec1["y"], rec1["height"], rec2["y"], rec2["height"])


rec1 = {"x": 10, "y": 30, "width": 100, "height": 200}
rec2 = {"x": -5, "y": 20, "width": 50, "height": 100}
rec3 = {"x": 15, "y": 15, "width": 5, "height": 5}
rec4 = {"x": 15, "y": 15, "width": 5, "height": 400}
print("testing intersect 2D")
print("rec1, rec2", is_intersect_2D(rec1, rec2))
print("rec1, rec3", is_intersect_2D(rec1, rec3))
print("rec1, rec4", is_intersect_2D(rec1, rec4))
print("rec2, rec3", is_intersect_2D(rec2, rec3))
