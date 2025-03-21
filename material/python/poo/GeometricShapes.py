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

shapes = (Rectangle(10, 2.5), Rectangle(9, 3), Circle(9), Circle(1.8))
for shape in shapes:
    print("area", shape.area(), "perimeter", shape.perimeter())