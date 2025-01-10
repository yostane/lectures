class Person:
    # constructeur
    # self est l'équivalent du this dans les autres langages
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def say_name(self):
        print(self.name)

    def __str__(self):
        return f"Person: {self.name} - {self.age}"


class Student(Person):
    def __init__(self, num_student, name, age):
        self.num_student = num_student
        # appel du constrcteur parent
        super().__init__(name, age)

    def __str__(self):
        return f"Student {self.num_student}, Parent __str__:" + super().__str__()


pDico = {"name": "dfsdfs", "age": 230}

p1 = Person("John", 36)

print(p1.name)
print(p1.age)
p1.age = 10
p1.say_name()
print(p1, pDico)

s = Student("2323JFLSJ", "A", 19)
print(s)
