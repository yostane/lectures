import tkinter as tk
from tkinter import ttk

root = tk.Tk()
root.geometry("320x240")  # width x height

label = ttk.Label(root, text='Hello CPI Python')


def change_label():
    label['text'] = "We are using the Ttk library"


button = ttk.Button(root, text="Change label", command=change_label)

button.pack()
label.pack()
root.mainloop()
