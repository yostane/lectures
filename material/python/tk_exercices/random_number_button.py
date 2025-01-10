import random
from playsound import playsound
import tkinter as tk
from tkinter import ttk

window = tk.Tk()
window.geometry(200, 200)

button: ttk.Button = None


def get_rand_int_as_str() -> str:
    r = random.randint(1, 100)
    return str(r)


def change_label():
    if button == None:
        return
    button.configure(text=get_rand_int_as_str())


button = ttk.Button(window, text=get_rand_int_as_str(), command=change_label)

button.place(relx=0.5, rely=0.5, anchor=tk.CENTER)
window.mainloop()
