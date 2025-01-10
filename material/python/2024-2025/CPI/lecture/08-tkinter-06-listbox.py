"""Listbox with scrollbar"""
import tkinter as tk
from tkinter import ttk

root = tk.Tk()
scrollbar = ttk.Scrollbar(root)
listbox = ttk.Treeview(root, yscrollcommand=scrollbar.set, show="tree")
scrollbar.configure(command=listbox.yview)

scrollbar.pack(side="right", fill="y")
listbox.pack(side="left", fill="both", expand=True)

for i in range(100):
    text = f"Item #{i+1}"
    listbox.insert("", "end", text=text)

root.mainloop()