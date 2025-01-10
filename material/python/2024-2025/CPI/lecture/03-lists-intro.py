# List of numbers
items = [2, 5, -1, 4]
print(items)

# List of strings
texts = ["I", "Love", "🥜"]
print(texts)

# A list of mixed types
mixed_items = ["A", 34, True, "Python"]
print(mixed_items)

# items[i] -> i is called the index
print("First element of items or element at index 0", items[0])
print("Third element of items or element at index 2", items[2])
print("Last element of items", items[-1], items[3])
# Indexing can go backwards with -
print(items[-1], items[-2], items[-3], items[-4])

# indexing [] also works with strings to get signle caracters
message = "Python is the best language"
print(message[0], message[9], message[-2])

# len is a predefined function that returns the number of items
print("len(items)", len(items), "len(message)", len(message))


# A list can be passed to a funtion
def print_size(items):
    print(len(items))


print_size(items)
print_size([1, 9, 100])
