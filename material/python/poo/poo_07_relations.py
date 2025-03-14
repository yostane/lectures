class Salary:
    def __init__(self, pay):
        self.pay = pay

    def get_total(self):
        return self.pay * 12


class Car:
    pass


class House:
    pass


class Computer:
    def turn_on(self):
        print("Turning on")


class Employee:
    def __init__(self, pay, bonus, posessions):
        self.bonus = bonus
        # Composition
        self.salary = Salary(pay)
        # Agrégation
        self.posessions = posessions

    def compute_annual_salary(self):
        return self.salary.get_total() + self.bonus

    def work(self, computer):
        """Association entre Employee et Computer"""
        computer.turn_on()


c1 = Car()
c2 = Car()
h = House()
emp = Employee(100, 10, [c1, c2, h])
print(emp.compute_annual_salary())
comp = Computer()
emp.work(comp)
