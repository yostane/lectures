def multiply(x, y):
    """
    Ex1: Define a function that takes two arguments and returns their multiplication.
    Call this function 4 times and print the results.
    """
    return x * y


print("Exercise 1")
a1 = multiply(2, 4)
a2 = multiply(1, 0)
a3 = multiply(1, -7)
a4 = multiply(10, 99)
print(a1, a2, a3, a4)


def get_max(x, y):
    """
    Ex2: Define a function that takes two integer arguments and returns the biggest value.
    Call this function 4 times and print the results.
    """
    if x >= y:
        return x
    else:
        return y


def get_max2(x, y):
    return x if x >= y else y


print("Exercise 2")
print(get_max(3, -8), get_max(0, 1), get_max2(1000, 100), get_max2(-7987, 333))


def get_min_three(a, b, c):
    """
    Ex3: Define a function that takes three integer arguments and returns the smallest value.
    Call this function 4 times and print the results.
    """
    if a <= b and a <= c:
        return a
    elif b <= a and b <= c:
        return b
    else:
        return c


print("Exercise 3")
print(
    get_min_three(0, 1, 2),
    get_min_three(10, -3, 99),
    get_min_three(85, 12, 21),
    get_min_three(7, 11, -2),
)


def get_even_odd(n, even_string, odd_string):
    """
    Ex4: Define a function that takes three arguments: an int and two strings.
    if the first argument is even, the function returns the first string argument.
    Otherwise, it returns the second string argument.
    Call this function 4 times and print the results.
    """
    # n is the first argument
    # even_string is the second argument and also the first string argument
    # odd_string is the third argument and also the second string argument
    # if n is odd, we return the first string argument -> even_string
    # otherwise, we return the second string argument -> odd_string
    return even_string if n % 2 == 0 else odd_string


def get_even_odd2(n, even_string, odd_string):
    if n % 2 == 0:
        return even_string
    else:
        return odd_string


print("Exercise 4:")
print(
    get_even_odd(2, "a", "b"),
    get_even_odd(1, "A", "B"),
    get_even_odd2(0, "🐍", "Python"),
    get_even_odd2(87, "even", "odd"),
)


def guess_game(x):
    """
    Ex5: Define a function that takes an int argument. Implement the function as follows.
    The function reads an integer from the keyboard (with input) and prints:
    - "You win" if the entered number is bigger than the argument
    - "You lose" otherwise
    Call this function 1 time.
    """
    attempt = int(input("Welcome to the guess game 👋. Please enter a number: "))
    
    # method 1
    if attempt > x:
        print("You win")
    else:
        print("You lose")

    # Method 2
    # operand2 if operand1 else operand3 is a ternary operator which returns:
    # operand2 if operand1 is True otherwise it returns operand3
    # For example: 1 if 5 == 8 else 99 => its result is 99 
    result = "You win 👍" if attempt > x else "You lose ☠️"
    print(result)


guess_game(10)


def extra_exercise():
    """Write a function that reads two integers from the keyboard (entered by the user)
    The program prints which numbers is bigger.
    Call this function twice
    """
    n1 = int(input("Enter the first number"))
    n2 = int(input("Enter the second number"))
    if n1 > n2:
        print(n1, "is grater than", n2)
    else:
        print(n2, "is grater than", n1)

# extra_exercise()
# extra_exercise()

def extra_exercise2(a, b, op):
    """Write a function that can add, substract, divide or multiply.
    The first two arguments are the operands.
    The thid arguemnt is the operator passed as a string.
    The function returns the result of the computation.
    Call the function twice for each operation and print the result each time.
    """
    if op == "+":
        return a + b
    elif op == "-":
        return a - b
    elif op == "*":
        return a * b
    elif op == "/":
        return a * b
    else:
        return 0

# Calling the function twice for each operation
print(extra_exercise2(1, 2, "+"), extra_exercise2(-5, 7, "+"))
print(extra_exercise2(1, 2, "-"), extra_exercise2(-5, 7, "-"))
print(extra_exercise2(2, 8, "*"), extra_exercise2(-1, 3, "*"))
print(extra_exercise2(1, 2, "/"), extra_exercise2(-5, 7, "/"))

operator = input("please enter: +, -, * or /: ")
print(extra_exercise2(-5, 7, operator))