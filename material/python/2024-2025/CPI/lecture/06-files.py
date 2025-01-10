file = open("test.txt")
# Prints the content of each line of the file
print(file.readlines())
file.close()

# file is a variable that allows to manipulate the "test.txt"
file = open("test.txt")
# readlines 'copies' the content of the file into RAM
# lines is a varaible whose type is a list of strings
lines = file.readlines()
file.close()

print(lines[-1])

first_line = lines[0]
print(first_line[1], lines[0][1])
print(lines[0][-1], "Hi")

# Prints every line and its length
for line in lines:
    print("Length:", len(line))
    print(line)
    

