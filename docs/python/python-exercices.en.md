---
title: 📚 Exercises
---

# Exercises

!!! warning "Instructions"

    - Do not seek help from AI or genAI

## Series 1

1. Write a Python script that asks the user to enter an integer and displays whether the number is even or odd. 💡 Tip: use `n = int(input("Enter an integer: "))`
1. Write a Python script that asks the user to enter an integer n and displays the sum of the first n integers (sum of integers from 0 to n inclusive).
1. Write a Python script that asks the user to enter an integer and displays all the divisors of that number.
1. Write a Python script that generates two random numbers x and y with 0 <= x <= 10 and x <= y <= 100. (tip: import `random` and call `x = random.randint(0, 10)`).
1. Write a Python program that generates two random numbers x and y with 0 <= x <= 10 and x <= y <= 100. The program then displays the result of the integer division between y and x and the remainder of the division. (remember to handle the case where x = 0).
1. Write a program that displays as many characters as possible from a string in a pyramid sequence. (tip: you can use a for loop on a string `for char in string`).
    - Example for the string "abcdefghijklmnopqrstuvwxyz" * 10

    ```
    a 
    bc 
    def 
    ghij 
    klmno 
    pqrstu 
    vwxyzab 
    cdefghij 
    klmnopqrs 
    tuvwxyzabc 
    defghijklmn 
    opqrstuvwxyz 
    abcdefghijklm 
    nopqrstuvwxyza 
    bcdefghijklmnop 
    qrstuvwxyzabcdef 
    ghijklmnopqrstuvw 
    xyzabcdefghijklmno 
    pqrstuvwxyzabcdefgh 
    ijklmnopqrstuvwxyzab 
    cdefghijklmnopqrstuvw 
    xyzabcdefghijklmnopqrs
    ```

1. Write a function `count_letters(text)` that takes a string argument `text` and returns a dictionary containing the frequency of all letters in the input string. For example: `count_letters("hello")` returns `{"h": 1, "e": 1, "l": 2, "o": 1}`.
1. Given rectangles defined with dictionaries where the keys are `"x", "y", "width", "height"`, where `x` and `y` are the coordinates of the rectangle (we suppose that the origin (0, 0) is the top left corner of the screen) and `width` and `height` are its dimensions in pixel units
    - Write a function `is_intersecting(rectangle1, rectangle2)` that returns `True` if there is an intersection between the two rectangles.
    - Write a function `get_intersection(rectangle1, rectangle2)` that returns the intersecting rectangle if it exists, otherwise `None`.
1. Write a function `fx_square(x)` that returns the result of `x * x`.
    - Write a function `fx_square_list(n)` that returns a list of n elements. The value of an element at index `i` is `fx_square(i)`.
    - Use the `matplotlib` library to draw a graph where the x-axis represents integers from 0 to n and the y-axis represents the elements returned by `fx_square_list(n)`.
1. Define a function `fx_square_list2(points)` that takes a list of integers sorted in ascending order and returns a new list where the value of the i-th element is `points[i] * points[i]`.
    - Plot the graph of **f(x) = x * x** for x ranging from -100 to 100.
1. Plot the graph from -100 to 100 for the following functions: `exp(x)`, `1/x`, `log(x) + (1/(x^3))`

## Solutions Series 1

??? "Exercises 1 to 5"

    ```py
    --8<--
    exercices_part1_exo1_5.py
    --8<--
    ```

??? "Exercises pyramid, count_letters, and intersection"

    ```py
    --8<--
    exercices_part1.py
    --8<--
    ```

??? "plot"

    ```py
    --8<--
    exercices_part1_plot.py
    --8<--
    ```

## Series 2

Solve the following exercises using comprehensions.

1. Create a list of the first 10 even numbers.
1. Create a dictionary containing 10 keys ranging from 0 to 9. The value of each key is a text indicating the parity of the number. (example: {0: "even", 1: "odd", etc.})
1. Create a dictionary containing 10 keys ranging from 0 to 9 converted to strings. The value of each key is a text indicating the parity of the number. (example: {"0": "even", "1": "odd", etc.})
1. Create a dictionary that filters the previous dictionary, keeping only the odd numbers.
1. Create a tuple that contains the first 20 even numbers.
1. Given a list of students where each student is defined by a dictionary of this type `student = {"name": "sasha", "birth_year" = 2000}`:
    - Create a set of student names.
    - Create a tuple containing the birth years of each student.
1. From a tuple of symbols `("♥️", "♠️", "♣️", "♦️")` and a list of ranks `["Ace", "King", "Queen", "Jack"] + [*range(2, 11)]`, create a deck of cards as a list of tuples which is the Cartesian product of the symbols and the ranks.

??? "Solutions"

    ```py
    --8<--
    comprehension_exos.py
    --8<--
    ```

## Source

- [Exercices corrigés d'algorithmique Python - Les bases](https://www.tresfacile.net/tp-python-exercices-corriges-dalgorithmique-python-les-bases/)
- [Exercices du site développez](https://algo.developpez.com/exercices/)
- [Sorting Algorithms Animations](https://www.toptal.com/developers/sorting-algorithms)
- [Sites pour apprendre en s’amusant](https://info.blaisepascal.fr/exercices-python/)
