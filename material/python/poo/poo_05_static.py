class Calculator:
  PI = 3.14
  
  @staticmethod
  def add(x, y):
    return x + y
  
  @staticmethod
  def multiply(x, y):
    return x * y
  
  @staticmethod
  def compute_circle_area(r):
    return r * r * Calculator.PI
  

print(Calculator.add(5, -8), Calculator.multiply(73, 0.8))
print(Calculator.PI, Calculator.compute_circle_area(8))
