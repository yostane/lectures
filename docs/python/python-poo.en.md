---
title: Object Oriented Programming
---

# Object oriented programming

The OOP paradigm sees the program as a collection of objects that interact with each other.

## Classes, objects, and inheritance

- Each object is defined by a class, which itself can inherit from other classes or interfaces.
- A class can define properties and methods, which are called **members**.
    - Property: a view on data through its read and/or write **accessors** (called getters and setters, respectively).
    - Method: a function defined within the class.
    - Constructor: a special method that is automatically called when an instance is created.
- In Python, the first argument of methods and the constructor is a reference to the current object.
    - The name of this argument must be `self` (called `this` in other languages).
    - `self` is called the method's context.
- A child class can inherit from a parent class:
    - In this case, the child class implicitly contains all the members of the parent class.
    - The child class can define additional members that are specific to it.
    - The child class can override members of the parent class. This is called overriding.
- Python is one of the few languages (along with C++) that allows multiple inheritance, i.e., a class can inherit from multiple classes at the same time.

```py
--8<--
poo_1.py
--8<--
```

```py
--8<--
poo_2.py
--8<--
```

## Static and abstract concepts

- Static property, method, or class:
    - Instance property: each instance has its own instance properties.
    - Static property: it is shared among all instances (like a global variable for the class).
    - Instance method: it is executed in the context of the instance that called it (accessible via `self`).
    - Static method: a method that only has access to the static properties and methods of its class.
    - Static class: a class that cannot be instantiated and only contains static properties and methods.
- Abstract method, property, and class:
    - Abstract method: a method that has no implementation.
    - Abstract property: a property whose accessors are not defined.
    - Abstract class: a class that has at least one abstract property or method.
    - Abstract members are intended to be defined by a non-abstract subclass.
