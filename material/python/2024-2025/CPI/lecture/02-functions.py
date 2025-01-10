a = 10
b = "Hello"
c = True
print(type(a), type(b), type(c))

if a % 2 == 0:
    print("even")


if a % 2 == 0:
    print("A is even here")


# A function avoids repeating the same code
# Function definition with an argument
def is_even(x):
    if x % 2 == 0:
        return True
    else:
        return False


# Function call
if is_even(a):
    print("a is even")
else:
    print("a is odd")

d = 21
if is_even(d):
    print("a is even")
else:
    print("a is odd")


# A function with two arguments
def add(x, y):
    return x + y


sum1 = add(4, 9)
print(sum1, add(-8, 0))
