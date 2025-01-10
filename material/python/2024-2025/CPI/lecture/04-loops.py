items = [51, 11, 16, 7, 20]

# print if every item is even or odd
# This is not a good solution because we need to add or remove prints if the length of the list changes
print(items[0] % 2 == 0)
print(items[1] % 2 == 0)
print(items[2] % 2 == 0)
print(items[3] % 2 == 0)
print(items[4] % 2 == 0)

# Same thing with a for loop
print("for loop")
for item in items:
  print(item % 2 == 0)
print("for loop 2")
# We can name the iteration variable whatever we want
for current_item in items:
  print("Current item is", current_item)
  print(current_item % 2 == 0)
print("While")
# While loop (like a repeating if)
# As long as the block is true, it is repeated
i = 0
while i < len(items):
  print(items[i] % 2 == 0)
  # If we remove this statement, we get an infinite loop
  # In this case, we have to kill the app to stop it
  i += 1 # is equivalent to i = i + 1

# For loop that iterates with integers from 0 to 5 thanks to range
for i in range(5):
  print(i)

# i will go from [1, 2, ..., len(items)[
for i in range(len(items)):
  print(items[i] % 2 == 0)

s = "Hello"
for char in s:
  print(char)