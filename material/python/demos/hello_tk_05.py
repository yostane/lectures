import tkinter as tk
from tkinter import ttk
from datetime import datetime
from functools import partial


prompts = []

window = tk.Tk()
window.geometry("600x300")

frame = ttk.Frame(window)

entered_text = tk.StringVar()
textbox = ttk.Entry(window, textvariable=entered_text)
textbox.pack()


def fill_query(query):
    entered_text.set(query)


def run_prompt():
    print("prompt saisi", entered_text.get())
    print("prompt saisi", textbox.get())
    response = f"Réponse à la main pour le prompt {entered_text.get()}. A remplacer par une vraie réponse"
    print("réponse", response)
    prompt = {
        "query": entered_text.get(),
        "response": response,
        "date": datetime.now(),
    }
    prompts.append(prompt)
    print(prompts)

    # Suppression de l'historique existant
    for item in frame.winfo_children():
        item.destroy()

    for prompt in prompts:
        content = ""
        content += f"query: {prompt['query']} \n"
        content += f"responst: {prompt['response']} \n"
        content += f"date: {prompt['date']} \n"
        content += f"--------------"
        ttk.Label(frame, text=content).pack()
        # lambda permet d'écrire du code à la place de passer le nom d'une function
        # Button(frame, text="Rerun", command=lambda: fill_query(prompt["query"])).pack()
        ttk.Button(
            frame,
            text="Rerun",
            command=partial(fill_query, prompt["query"]),
        ).pack()


def reset_entry():
    entered_text.set("")


run_button = ttk.Button(window, text="Run", command=run_prompt)
run_button.pack()

clear_button = ttk.Button(window, text="Clear", command=reset_entry)
clear_button.pack()
frame.pack()

window.mainloop()
