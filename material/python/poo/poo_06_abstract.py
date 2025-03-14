from abc import ABC, abstractmethod

class SchoolPerson(ABC):
  def __init__(self, name, id, address):
    self.name = name
    self.id = id
    self.address = address
  
  def __str__(self):
    return f"[SchoolPerson: {self.name}, {self.id}, {self.address}]"

  @abstractmethod  
  def attend_class(self):
    """@abstractmethod rend l'instanciationd de cette classe impossible et oblige les sous-classes à implémenter la méthode"""
    pass

class Student(SchoolPerson):
  """Un Student 'est' un SchoolPerson donc Student peut hériter de SchoolPerson"""
  def __init__(self, name, id, address):
    super().__init__(name, id, address)
    
  def attend_class(self):
    print("I learn")
    

class Teacher(SchoolPerson):
  """Un Teacher 'est' un SchoolPerson donc Teacher peut hériter de SchoolPerson"""
  def __init__(self, name, id, address, contract_type):
    super().__init__(name, id, address)
    self.contract_type = contract_type
  
  def __str__(self):
    #return f"[Teacher: {self.name}, {self.id}, {self.address}, {self.contract_type}]"
    return f"[Teacher: {self.contract_type}, ({super().__str__()})]"

  def attend_class(self):
    print("I teach")
  
s1 = Student("a", "12354S", "Home")
t1 = Teacher("b", "82546T", "Teacher Home", "Occasionnel")
print(s1, t1)

s1.attend_class()
t1.attend_class()