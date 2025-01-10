---
title: Language Tour
---

# Python Language Tour

We will take a tour of the Python language without necessarily covering everything as it is very rich in features.

!!! warning

    As the Python language frequently evolves and brings improvements and simplifications, the code examples seen here may be different from what you find in the literature.

## Getting Started

- Open VSCode in an empty folder
- Create a file **hello.py** containing `print("Hello")`
- Run the command `python hello.py`
- Some code to get an idea of the language

```py
--8<--
tour.py
--8<--
```

## Some Features

- Python is dynamically typed: a variable can change its type during its usage (opposite of statically typed)
- Python is strongly typed: each data has a type and does not change implicitly
- Python supports object-oriented and functional programming
- Indentation is used to define code blocks (instead of `{}` braces commonly found in other languages)
    - The indentation size should be consistent within the same block
    - It is recommended to have an indentation of 4 spaces
- There are several programming conventions, but they have many common points. The official convention is called [pep 8](https://peps.python.org/pep-0008/). Here are some rules and recommendations:
    - Snake case for functions. Ex. `find_student()`
    - Use spaces for indentation and avoid using the **tab** key

## Basic Types and Operations

- Integer (int), float, and complex numbers
- Strings
- Boolean values and boolean operators `and`, `or`, and `not`
- Comparison operators `>`, `<`, ... that return a boolean
    - `is` allows testing the identity between two objects. Its result can be customized.
    - `==` is sometimes equivalent to `is`
- As Python is strongly typed, converting a value to another type must be done explicitly using `int()`, `float()`, `complex()`, `str()`, ...

```py
--8<--
operators.py
--8<--
```

## Exceptions

```py
--8<--
exception.py
--8<--
```

## Standard Collections

- Collection: a type (or structure) of data that allows managing a set of data
- Python offers several built-in collection types
- Here are the 4 most commonly used types: *list*, *dict*, *set*, and *tuple*

```py
--8<--
collections_base.py
--8<--
```

## List, Dictionary, and Set Comprehension

- Allows creating a new list, dictionary, or set from an existing collection
- Allows replacing certain operations that would have been done with loops
- For a list `[f(index) for index in input_seq if condition]` (`input_seq` is a list, tuple, or any iterable sequence with an index)
- For a list `[f(item) for item in input_seq if condition]` (`input_seq` is a list, tuple, or any iterable sequence)
- For a dictionary `{f_key(item):f_value(item) for item in input_seq if condition}` (`input_seq` is an iterable sequence)
- `f, f_key, f_value` are arbitrary functions
- The `if condition` part is optional
- It is also possible to replace nested loops with a single comprehension

```py
--8<--
comprehension.py
--8<--
```

## Using a Third-Party Library

- Even though Python's standard library is rich, we often need to use third-party libraries to speed up development
- The standard repository for Python libraries is [PyPI](https://pypi.org/) (**Py**thon **P**ackage **I**ndex)
- We can use its search engine to find a library. For example, let's search for the **matplotlib** library
- Once on the library's page, we can find the command to install it locally. For **matplotlib**, the command will be `pip install matplotlib` (if pip is not found, try with `python -m pip install matplotlib`)
- Then, we can use the library by referring to its documentation. For example, matplotlib offers [tutorials](https://matplotlib.org/stable/tutorials/index.html) which is a good starting point.

## Sources and References

- [Python List Comprehension: single, multiple, nested, & more](https://www.learndatasci.com/solutions/python-list-comprehension/)
