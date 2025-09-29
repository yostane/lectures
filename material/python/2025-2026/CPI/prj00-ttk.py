import tkinter as tk
from tkinter import ttk

root = tk.Tk()
root.geometry("320x240")  # width x height

label = ttk.Label(root, text='Hello CPI Python')


def change_label():
    if label['text'] == 'Hello CPI Python':
        label['text'] = "We are using the Ttk library"
    else:
        label['text'] = 'Hello CPI Python'


button = ttk.Button(root, text="Change label", command=change_label)

label.pack()
button.pack()
root.mainloop()
