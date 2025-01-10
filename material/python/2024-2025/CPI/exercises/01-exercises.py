""" Lecture Ex 1
Write a Python script that asks the user to enter an integer.
Then, it tells the user if the integer is positive or negative
"""

a1 = input("Ex1: Please enter an integer: ")
a2 = int(a1)
if a2 >= 0:
    print("The entered number is positive")
else:
    print("The entered number is negative")

""" Lecture Ex 2
Write a Python script that asks the user to enter two integers.
Then, it shows them in the ascending order.
"""
b1 = int(input("Ex2: Please enter an integer: "))
b2 = int(input("Please enter another integer: "))
if b1 >= b2:
    print(b1, "is greater or equal than", b2)
else:
    print(b1, "is strictly less than", b2)

""" Lecture Ex 3
Write a Python script that asks the user to enter an integer.
Then, it prints 
"even" if the number is even (pair en Français), or
"odd" if the number is off (impair en Français).
"""
c1 = int(input("Ex3: Please enter an integer: "))
if c1 % 2 == 0:
    print(c1, "is even")
else:
    print(c1, "is odd")
