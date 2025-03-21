from abc import ABC, abstractmethod
import math

class Shape(ABC):
    @abstractmethod
    def area(self) -> float:
        pass
    
    @abstractmethod
    def perimeter(self) -> float:
        pass
    
class Rectangle(Shape):
    def __init__(self, length: float, width: float):
        super().__init__()
        self.lenght = length
        self.width = width
    
    def area(self) -> float:
        return self.width * self.lenght
    
    def perimeter(self) -> float:
        return (self.width + self.lenght) * 2

class Circle(Shape):
    def __init__(self, radius: float):
        super().__init__()
        self.radius = radius
    
    def area(self) -> float:
        return (self.radius ** 2) *  math.pi
    
    def perimeter(self) -> float:
        return self.radius * 2 * math.pi
    
class Triangle(Shape):
    """On suppose qu'on donne une base et une hauteur ainsi que les deux autres côté.
    A faire en exercice: se baser uniquement sur les côtés"""
    def __init__(self, b: float, h: float, c2: float, c3: float):
        super().__init__()
        self.b = b
        self.h = h
        self.c2 = c2
        self.c3 = c3
    
    def perimeter(self) -> float:
        return self.b + self.c2 + self.c3
    
    def area(self) -> float:
        return (self.b * self.h) / 2

shapes = (Rectangle(10, 2.5), Rectangle(9, 3), Circle(9), Circle(1.8), Triangle(10, 10, 10, 14.142))
for shape in shapes:
    print("area", shape.area(), "perimeter", shape.perimeter())