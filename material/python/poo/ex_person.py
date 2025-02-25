class Person:
  def __init__(self, first_name: str, last_name: str, age: int):
    self.first_name = first_name
    self.last_name = last_name
    self.age = age
  
  def __str__(self):
    return f"Person(name: {self.first_name} {self.last_name}, age: {self.age})"
  
  def __eq__(self, other: object) -> bool:
    return isinstance(other, Person) and self.first_name == other.first_name\
      and self.last_name == other.last_name and self.age == other.age
  

p1 = Person("Ram", "Bo", 40)
p2 = Person("Ryuuji", "Itadori", 17)
p3 = Person("Ryuuji", "Itadori", 17)

print(p1)
print(p2)
print(p3)

print(p1 == 10)
print(p1 == p2)
print(p2 == p3)