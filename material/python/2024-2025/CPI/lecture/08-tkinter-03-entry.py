import tkinter as tk
# ttk will contain our widgets
from tkinter import ttk

window = tk.Tk()
window.geometry("600x300")

entry = ttk.Entry(window)

def print_entered_text():
    text = entry.get()
    print("Entered text is:", text)

button = ttk.Button(window, text="Click Me", command=print_entered_text)

# Change the order of pack and see what happens
entry.grid(row=0, column=1, padx=5, pady=5)
button.grid(row=1, column=0, padx=5, pady=5)

window.mainloop()