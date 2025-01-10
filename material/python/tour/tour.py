# This is a comment
a = 10
print(a)
a = "hello"
print(a)
print("The value of a is", a)

a = "22"
b = 10
# erreur car python est fortement typé et n'autorise pas l'addition sur deux types différents
# c = a + b
# print("a + b", c)
print(a + str(b), int(a) + b)

if b == 10:
    print(b)
    print(b)
else:
    print("b différent de 10 / b is not 10")


def add(x, y):
    print(f"addition of {x} and {y}")
    return x + y


# A function can be documented with optional type hints and a docstring
def multiply(x: int, y: int) -> int:
    """
    Multiply x and y
    Parameters:
        x: first number
        y: second number
    Returns:
        the result of the multiplication
    """
    return x * y


print(add(-810, b))
f = add
print(f(-810, b))

print("range demo: générateur / generator")
r = range(10)
print(r)
print("Start value", r.start, "pas / step", r.step)

print("range loop")
for item in r:
    print(item)


for item in range(10):
    print(item)

for i in range(10, 21, 3):
    print(i)

message = "I ♥️ Python"
for letter in message:
    print(letter)

for i in range(len(message)):
    print(i, message[i])
