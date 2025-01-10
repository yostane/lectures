# importing required module
from playsound import playsound
import tkinter as tk
from tkinter import ttk

window = tk.Tk()
window.title("GeeksforGeeks sound player")  # giving the title for our window
window.geometry("500x400")


# making function
def play():
    playsound("sample-3s.mp3")


# title on the screen you can modify it
title = ttk.Label(
    window,
    text="Sample sound",
)
title.pack()

# making a button which trigger the function so sound can be playeed
play_button = ttk.Button(window, text="Play Song", command=play)
play_button.pack()

info = ttk.Label(window, text="Click on the button above to play song ").pack(pady=20)
window.mainloop()
