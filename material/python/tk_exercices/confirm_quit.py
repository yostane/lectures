import tkinter as tk
from tkinter import ttk
import tkinter.messagebox as mb

window = tk.Tk()
window.geometry("200x200")

entered_text = tk.StringVar()
textbox = ttk.Entry(window, textvariable=entered_text)
textbox.pack(pady=50)


def quit_app():
    if len(entered_text.get()) == 0:
        window.destroy()
        return
    anwser = mb.askyesno(title="Confirmer", message="Voulez-vous quitter ?")
    if anwser:
        window.destroy()
        return


run_button = ttk.Button(window, text="Quit 👋", command=quit_app)
run_button.pack()

window.mainloop()
