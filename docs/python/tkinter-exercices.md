---
title: Exercices de Tkinter
---

# Exercices

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI
    - Utiliser les composants `ttk` autant que possible

## Série 1

1. Créer une fenêtre qui affiche un bouton dont le texte est un nombre alétoire entre 1 et 100. Chaque fois qu'on clique sur le bouton, le nombre aléatoire change.
1. Créer une fenêtre qui affiche un bouton "Quitter" et un texte editable. Gérer le comportement suivant quand on clique sur le bouton "Quitter":
    - Si on n'a pas modifié le texte, la fenêtre se ferme,
    - Si on a modifié le texte, une boîte de dialogue demande si on veut vraiment quitter. Si on répond "Oui", la fenêtre se ferme, sinon elle reste ouverte (voir astuce plus bas).
1. Créer une fenêtre qui affiche un texte editable et les boutons "sauvegarder" et "charger". Gérer le comportement suivant:
    - Quand on clique sur "sauvegarder", le texte est sauvegardé dans un fichier texte,
    - Quand on clique sur "charger", le texte est chargé depuis le fichier texte et est affiché dans la zone éditable (voir astuce plus bas).
1. Créer une fenêtre qui affiche deux textes editables et les boutons "sauvegarder" et "charger". Gérer le comportement suivant:
    - Quand on clique sur "sauvegarder", le texte de la première zone éditable est sauvegardé dans un fichier texte. Le nom du fichier est déterminé par le texte de la deuxième zone éditable,
    - Quand on clique sur "charger", le texte est chargé depuis le fichier texte et est affiché dans la zone éditable. Le nom du fichier est déterminé par le texte de la deuxième zone éditable.

### Astuces

```py title="Générer un nombre aléatoire"
import random
nombre = random.randint(1, 100)
```

```py title="Fermer une fenêtre tk"
window.destroy()
```

```py title="message box"
import tkinter.messagebox as mb
anwser = mb.askyesno(title="Confirmer?", message="Voulez-vous quitter ?")
```

```py title="Sauvegarder et charger un fichier"
def sauvegarder(texte):
    with open("fichier.txt", "w") as f:
        f.write(texte)

def charger():
    with open("fichier.txt", "r") as f:
        return f.read()
```

```py title="Afficher une image depuis un fichier avec tkinter"
from tkinter import PhotoImage

img = PhotoImage(file="image.png")
label = Label(fenetre, image=img)
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

## Série 2

1. Créer une fenêtre qui affiche une image depuis un fichier.
1. Créer une fenêtre qui affiche une zone de saisie de texte et un bouton. Quand l'utilisateur appuie sur le bouton, l'image dont le nom est définie par le zone de saisie est affichée en dessous.
1. Avec la librairie [playsound](https://pypi.org/project/playsound/), créer une fenêtre qui joue un son quand on clique sur un bouton.
    - Vous pouvez utiliser ce [tuto pour vous aider](https://stacklima.com/comment-jouer-des-sons-en-python-avec-tkinter/)
    - Vous pouvez utiliser ce [site pour trouver des sons](https://freesound.org/) ou télécharger [cet exemple](./assets/sample-3s.mp3)
    - Si `pip install playsound` ne fonctionne pas, vous pouvez essayer `pip install playsound@git+https://github.com/taconi/playsound`
1. Utiliser [tkvideoplayer](https://pypi.org/project/tkvideoplayer/) pour créer une fenêtre qui lit une vidéo.

### Solutions

??? "Play music"
    ```py
    --8<--
    tk_exercices/playsound_demo.py
    --8<--
    ```

## Série 3

1. En utilisant [tkinter.scrolledtext](https://www.geeksforgeeks.org/python-tkinter-scrolledtext-widget/) Créer une application qui permet de saisir du texte, de le sauvegarder dans un fichier et de le charger.
1. Créer une application qui permet de saisir du texte, de le sauvegarder dans un fichier et de le charger. Elle permet aussi de mémoriser la dernière modification et permet de la restaurer à l'aider du bouton "Annuler". Si la modification est restaurée, le bouton "Annuler" devient "Refaire" et permet de rétablir la modification.
1. Modifier l'application pour mémoriser les 10 dernières modifications, le bouton "Annuler" permet de revenir en arrière et le bouton "Refaire" permet de revenir en avant. Le comportement devrait être similaire aux éditeurs de texte classiques.
1. Associer les raccourcis clavier à chaque bouton. Par exemple, `Ctrl+S` pour sauvegarder, `Ctrl+Z` pour annuler, `Ctrl+Y` pour refaire, etc.
