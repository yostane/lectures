"""Create a tkinter application with a button and one or many labels.
Every time the user presses on the button, generate a random integer between 3 and 24.
Then, show this information in the window: 
- The last generated random number
- If it's even or odd 
- If it's prime or not (you can resuse existing exercises)
- The list of all generated random numbers
- The sum of all generated random numbers
"""
import tkinter as tk
from tkinter import ttk
import random

root = tk.Tk()
label = ttk.Label(root, text='Please press on the button')

random_values = []


def get_sum(values):
    s = 0
    for x in values:
        s += x
    return s


def generate_random_value():
    r = random.randint(3, 24)
    random_values.append(r)
    even_value = "odd"
    if r % 2 == 0:
        even_value = "even"
    label["text"] = f"""
    - Last random value: {r}
    - random values: {random_values}
    - sum {get_sum(random_values)}
    - {even_value}
    """


button = ttk.Button(root, text="Change label", command=generate_random_value)

label.pack()
button.pack()
root.mainloop()
