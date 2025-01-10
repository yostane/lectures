import tkinter as tk
from tkinter import ttk

# widget: tout composant de l'interface graphique: bouton, label, image, etc. (windows + gadget)

window = tk.Tk()
window.geometry("600x300")

label = ttk.Label(window, text="Hello World")


def print_message():
    print("Button clicked")


def change_size():
    print("Nouvelle dimension de fenêtre")
    window.geometry("500x200")


# command: on dit que c'est une callback
button = ttk.Button(window, text="Click Me", command=print_message)
button2 = ttk.Button(window, text="Click Me Here", command=change_size)
button.pack()
label.pack()
button2.pack()
# pour placer une ligne de code
ttk.Label(window, text="Autre texte").pack()

window.mainloop()
