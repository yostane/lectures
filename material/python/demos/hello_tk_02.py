import tkinter as tk

# widget ou controle: tout composant de l'interface graphique: bouton, label, image, etc. (windows + gadget)

window = tk.Tk()
window.geometry("600x300")

label = tk.Label(window, text="Hello World")


def print_message():
    print("Button clicked")


def change_size():
    print("Nouvelle dimension de fenêtre")
    window.geometry("500x200")


# command: on dit que c'est une callback
button = tk.Button(window, text="Click Me", command=print_message)
button2 = tk.Button(window, text="Click Me Here", command=change_size)
# Lay or put the widgets into the window
button.pack()
label.pack()
button2.pack()
# pour placer une ligne de code
tk.Label(window, text="Autre texte").pack()

window.mainloop()
