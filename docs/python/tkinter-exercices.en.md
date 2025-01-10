---
title: Tkinter Exercises
---

# Exercises

!!! warning "Instructions"

    - Do not use AI or genAI for help
    - Use `ttk` components whenever possible

## Series 1

1. Create a window that displays a button with a random number between 1 and 100 as text. Each time the button is clicked, the random number changes.
1. Create a window that displays a "Quit" button and an editable text. Handle the following behavior when clicking the "Quit" button:
    - If the text hasn't been modified, the window closes,
    - If the text has been modified, a dialog box asks if you really want to quit. If you answer "Yes", the window closes, otherwise it stays open (see tip below).
1. Create a window that displays an editable text and "save" and "load" buttons. Handle the following behavior:
    - When clicking "save", the text is saved to a text file,
    - When clicking "load", the text is loaded from the text file and displayed in the editable area (see tip below).
1. Create a window that displays two editable texts and "save" and "load" buttons. Handle the following behavior:
    - When clicking "save", the text from the first editable area is saved to a text file. The filename is determined by the text in the second editable area,
    - When clicking "load", the text is loaded from the text file and displayed in the editable area. The filename is determined by the text in the second editable area.

### Tips

```py title="Generate a random number"
import random
number = random.randint(1, 100)
```

```py title="Close a tk window"
window.destroy()
```

```py title="message box"
import tkinter.messagebox as mb
answer = mb.askyesno(title="Confirm?", message="Do you want to quit?")
```

```py title="Save and load a file"
def save(text):
    with open("file.txt", "w") as f:
        f.write(text)

def load():
    with open("file.txt", "r") as f:
        return f.read()
```

```py title="Display an image from file with tkinter"
from tkinter import PhotoImage

img = PhotoImage(file="image.png")
label = Label(window, image=img)
label.pack()
```

### Solutions

??? "Random number button"
    ```py
    --8<--
    tk_exercices/random_number_button.py
    --8<--
    ```

??? "Confirm quit"
    ```py
    --8<--
    tk_exercices/confirm_quit.py
    --8<--
    ```

## Series 2

1. Create a window that displays an image from a file.
1. Create a window that displays a text input area and a button. When the user clicks the button, the image whose name is defined by the input area is displayed below.
1. Using the [playsound](https://pypi.org/project/playsound/) library, create a window that plays a sound when clicking a button.
    - You can use this [tutorial for help](https://stacklima.com/how-to-play-sounds-in-python-with-tkinter/)
    - You can use this [site to find sounds](https://freesound.org/) or download [this example](./assets/sample-3s.mp3)
    - If `pip install playsound` doesn't work, you can try `pip install playsound@git+https://github.com/taconi/playsound`
1. Use [tkvideoplayer](https://pypi.org/project/tkvideoplayer/) to create a window that plays a video.

### Series 2 Solutions

??? "Play music"
    ```py
    --8<--
    tk_exercices/playsound_demo.py
    --8<--
    ```

## Series 3

1. Using [tkinter.scrolledtext](https://www.geeksforgeeks.org/python-tkinter-scrolledtext-widget/), create an application that allows text input, saving to a file, and loading.
1. Create an application that allows text input, saving to a file, and loading. It also remembers the last modification and allows restoring it using the "Undo" button. If the modification is restored, the "Undo" button becomes "Redo" and allows restoring the modification.
1. Modify the application to remember the last 10 modifications, the "Undo" button allows going backwards, and the "Redo" button allows going forwards. The behavior should be similar to classic text editors.
1. Associate keyboard shortcuts with each button. For example, `Ctrl+S` for save, `Ctrl+Z` for undo, `Ctrl+Y` for redo, etc.
