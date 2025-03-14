import datetime


class LivingBeing:
    def __init__(self, name, birth_date) -> None:
        self.name = name
        self.birth_date = birth_date


class Brain:
    def __init__(self, volume) -> None:
        self.volume = volume


class Hand:
    def __init__(self, finger_count) -> None:
        self.finger_count = finger_count

    def do_thumbs_up(self):
        print("👍")


class Heart:
    pass


class Human(LivingBeing):
    def __init__(
        self, name, birth_date, social_security_number, height, heart, brain_volume
    ) -> None:
        super().__init__(name, birth_date)
        self.social_security_number = social_security_number
        self.height = height
        # Composition
        self.brain = Brain(brain_volume)
        self.hands = [Hand(3), Hand(12)]
        # Agrégation
        self.heart = heart
        self.hp = 10

    def walk(self, distance):
        print(f"🚶 during {distance} KM")

    def sleep(self, duration):
        print(f"It's time to 😴 for {duration} minutes")

    def talk(self, sentence):
        print(f"🗣️: {sentence}")

    def eat(self, fruit):
        print(f"miam la pomme {fruit}")
        fruit.weight = 1
        self.hp += 10

    def heal(self, human):
        print(f"Soin appliqué à {human}")
        human.hp += 3

    def __str__(self) -> str:
        return f"Human: hp -> {self.hp}"


class Fruit:
    def __init__(self) -> None:
        self.weight = 10

    def __str__(self) -> str:
        return f"Fruit: weight -> {self.weight}"


heart = Heart()
human1 = Human("Rémie", datetime.datetime(2003, 8, 15), 1_987_687_686, 175, heart, 2)

print("brain volume", human1.brain.volume, "M3")
human1.sleep(10)
human1.walk(2000)
human1.talk("hahaha")

a1 = Fruit()
a2 = Fruit()

human1.eat(a1)
human1.eat(a2)

h2 = Human("Dupont", datetime.datetime(2000, 8, 15), 100, 175, Heart(), 2)
human1.heal(h2)

print(human1, h2)
