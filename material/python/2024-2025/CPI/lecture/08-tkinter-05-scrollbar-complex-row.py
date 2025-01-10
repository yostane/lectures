""" Vertical scroll example. The file VerticalScrolledFrame.py must be copied into your project  """
import tkinter as tk
from tkinter import ttk
from VerticalScrolledFrame import VerticalScrolledFrame

window = tk.Tk()
window.title('VerticalScrolledFrame demo')
window.geometry('400x300')
window.config(bg='#5F734C')

frame = VerticalScrolledFrame(window)

frame.pack(expand = True, fill = tk.BOTH)

for i in range(20):
    f = ttk.Frame(frame.interior)
    ttk.Label(f, text=f"Todo {i}").pack(side=tk.LEFT)
    ttk.Button(f, text=f"Complete").pack(side=tk.LEFT)
    f.pack(padx=5, pady=5)
    
window.mainloop()