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
    ttk.Button(frame.interior, text=f"Button {i}").pack(padx=10, pady=5)

window.mainloop()