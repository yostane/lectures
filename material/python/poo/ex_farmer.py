class Animal:
    def __init__(self, name):
        self.name = name
        self.health = 100

    def make_sound(self):
        pass

    def __repr__(self):
        return f"({self.__class__.__name__}: {self.name})"


class Cow(Animal):
    def make_sound(self):
        return "Meuh!"


class Chicken(Animal):
    def make_sound(self):
        return "Cot-cot!"


class Fruit:
    def __init__(self, name, ripeness=0):
        self.name = name
        self.ripeness = ripeness  # 0 to 100

    def is_ripe(self):
        return self.ripeness >= 100

    def __repr__(self):
        return f"({self.__class__.__name__}: {self.name}, {self.ripeness})"


class Apple(Fruit):
    pass


class Pear(Fruit):
    pass


class Banana(Fruit):
    pass


class Strawberry(Fruit):
    pass


class Farmer:
    def __init__(self, name):
        self.name = name
        self.animals = []
        self.fruits = []

    def add_animal(self, animal):
        self.animals.append(animal)

    def add_fruit(self, fruit):
        self.fruits.append(fruit)

    def __str__(self):
        return f"{self.name}. Animals: {self.animals}. Fruits: {self.fruits}"


farmer = Farmer("Jean")

# Add some animals
farmer.add_animal(Cow("Marguerite"))
farmer.add_animal(Chicken("Cocotte"))

# Add some fruits
farmer.add_fruit(Apple("Pomme Rouge"))
farmer.add_fruit(Pear("Poire Williams"))
farmer.add_fruit(Banana("Banane"))
farmer.add_fruit(Strawberry("Fraise des bois"))

print(farmer)
