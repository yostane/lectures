def ex1(text):
  """Ex1: write a for loop that iterates over a string and prints only vowels (a, e, i, u, o, y)"""
  for s in text:
    if s == "a" or s == "u" or s == "i" or s == "o" or s == "y" or s == "e":
      print(s)

def ex1_2(text):
  for s in text:
    if s in "auieoy":
      print(s)

print("Exercise 1")
ex1("hello")
ex1_2("hello")

def ex2(integers):
  """Ex2: 
  Define a function thas does a for loop that iterates over a list of integers and prints only mutiples of 3 or 7
  Call it multiple times"""
  for n in integers:
    if n % 3 == 0 or n % 7 == 0:
      print(n)

print("Exercise 2")
print("Exercise 2 - list 1")
ex2([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
ex2(range(1, 11))
print("Exercise 2 - range(11)")
ex2(range(11))

print("Exercise 2 - range(30)")
ex2(range(30))
print("Exercise 2 - range(-12, 22, 5)")
r = range(-12, 22, 5)
ex2(r)
# equivalent call
ex2(range(-12, 22, 5))

def ex3(items):
  """Ex3: write a function that takes a string or list as argument and prints each character or item twice.
  Call the function 3 times"""
  for c in items:
    print(c, c)
print("Exercise 3")
ex3("Programming")
ex3(["One", "Two", "Three"])
ex3([1.2, 5, True, 3])

def ex4(x):
  """Ex4: Given the mathematical function f(x) = x ** 5 + 3 (** means power in python).
  Print the value of f(x) for integers ranging from 0 to 20 (20 included)"""
  return x ** 5 + 3

for n in range(21):
  print(ex4(n))
  print(n ** 5 + 3)


"""Ex5: Given the mathematical function f(x) = x ** 2 + 4 x - 10,
print the value of f(x) for integers ranging from -20 to 20 (💡 you can use range(-20, 21))"""
def ex5():
  for n in range(-20, 21):
    print(n ** 2 + 4 * n - 10)
ex5()

"""Ex6: Write a function that takes a string and prints the count of vowels and consonants. 
Example: ex6("Hello") will print -> Consonants: 3, Vowels: 2"""
def ex6(s):
  vowel_count = 0
  for c in s:
    if c in "aeiouy":
      vowel_count += 1 # same as vowel_count = vowel_count + 1
  print(s, "has", vowel_count, "vowels and", len(s) - vowel_count, "consonants")
print("Exercise 6")
ex6("Friday")
ex6("Python")

"""Ex7: Write a function that takes two strings prints the characters at the same indices together. Example: ex7("Hello", "Python") will print ->
HP
ey
lt
lh
oo
 n
"""
def ex7(s1, s2):
  max_len = len(s1)
  if len(s2) > max_len:
    max_len = len(s2)
  for i in range(max_len):
    if len(s1) > i and len(s2) > i:
      # i is smaller than the lengths of both strings
      print(s1[i], s2[i])
    elif len(s1) > i:
      print(s1[i], "")
    else:
      print(" ", s2[i])
print("Exercise 7")
ex7("Hello", "Python")
ex7("Python", "Hello")

"""Ex8: Withtout running the program, tell exactly what it will print"""
animals = ["dog", "cat", "mouse"]
for a in animals:
  print(a)

"""Ex8-part2: Withtout running the program, tell exactly what it will print"""
animals = ["dog", "cat", "mouse"]
for a in [0, 1, 2]:
  print(a)
for a in range(3):
  print(a)  
for a in range(len(animals)):
  print(a) 
for a in animals:
  if len(a) == len(animals):
    print(a, "has same len")
  else:
    print(a, "does not have same len")

"""Ex9: Write a function that takes a list of numbers as argument, and prints: 
- The sum of the elements
- The max
- The min
- The average
"""

"""Ex10: Write a function that takes two lists of numbers as argument and returns the wighted average (moyenne pondérée) of the
the first list using the second list as wights
Example: [10, 5, 13] with weights [2, 1, 3] will return: 10.66, which is computed from => (10 * 2 + 5 + 13 * 3) / (2 + 1 + 3) 
"""

