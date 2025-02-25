class Person:
  def __init__(self, first_name: str, last_name: str, age: int):
    self.first_name = first_name
    self.last_name = last_name
    self.age = age
  
  def __str__(self):
    return f"Person(name: {self.first_name} {self.last_name}, age: {self.age})"
  
  def __eq__(self, other: object) -> bool:
    if not isinstance(other, Person):
      return False
    return self.first_name == other.age and self.last_name == other.last_name and self.age == other.age