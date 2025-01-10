# This is a comment
# = is an assignement
a = 10  # a is an Integer. 10 will be assigned or copied to a
b = a + 55  # Arithmeric expression
print(b)
c = 3.333  # Float
d = "Hello Python 2024"  # String -> text
e = False  # Boolean
f = True  # Boolean algebra has two values: 0/1 or False/True
print(c, d, e, f)
# Comparison expressions -> return booleans
print(a == 20, 10 > 1, "a" < "b", a >= 10, a <= 10)  # == test the equality
# and operator of the boolean algebra
print("and ->", True and True, False and False, False and True, True and False)
print("or ->", True or True, False or False, False or True, True or False)
# % modulo operator -> return the remainder of integer division
print("modulo and /", 10 % 3, 10 / 3)
# the if statement executes code conditionnaly
if a > 10:
    print("a is stricly greater than 10")
else:
    print("a is strictly less than 10")

a1 = 67
a2 = "23"
# print(a1 + a2) # TypeError: unsupported operand type(s) for +: 'int' and 'str'
a3 = int(a2)
print(a3, a1 + a3)
print(type(a1), type(a2), type(a3), type("Hello"), type(-1.4))
print(
    str(a1) + a2
)  # concatenation -> generate a string that starts with str(a1) and ends with a2
print("Hello" + "world" + "2024")
print("Hello" + " world " + "2024")

text1 = "Hel'''''lo"
text2 = 'Hello""""""'

in1 = input("Please enter something and type 'Enter' when you finish: ")
print(in1, type(in1))

in2 = input("Please enter a number: ")
print(in2, type(in2))
print(int(in2) * 10)

# Immediatly convert the input into an int
in3 = int(input("Please enter a number: "))
print(in3, type(in3))
print(in3 * 10)
