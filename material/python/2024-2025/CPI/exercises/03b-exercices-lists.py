def ex2(s, i):
  """Exercise 2
  Write a function that takes a string and an int argument. It prints:
  - Long: if the length of the string is greater than the int argument
  - Short: otherwise
  """
  if len(s) > i:
    print("Long")
  else:
    print("Short")

print("Exercise 2")
ex2("Python", 2)
ex2("Python", 10)


def solve_ex3(s):
  """Exercise 3
  Write a function that takes a string argument. This function prints:
  - space: if the third character is a space
  - other: otherwise
  - error: if the argument has less than three characters
  """
  if len(s) < 3:
    print("error")
  elif s[2] == " ":
    # The third caracter is a space and len(s) >= 3
    print("space")
  else:
    # The third caracter is not a space and len(s) >= 3
    print("other")

print("Exercise 3")
solve_ex3("Python")
solve_ex3("Py thon")
solve_ex3("Py")
