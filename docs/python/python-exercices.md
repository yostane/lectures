---
title: 📚 Exercices
---

# Exercices

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Série 1

1. Ecrire un script Python qui demande à l’utilisateur de saisir un nombre entier et affiche si ce nombre est pair ou impair. 💡 Astuce: utiliser `n = int(input("Saisir un entier : "))`
1. Ecrire un script Python qui demande à l'utilisateur de saisir un entier n et affiche la somme des n premiers entiers (somme des entiers de 0 jusqu'à n inclus).
1. Ecrire un script Python qui demande à l’utilisateur de saisir un nombre entier et affiche tous les diviseurs de ce nombre.
1. Ecrire un script Python qui génère deux nombres aléatoires x et y avec 0 <= x <= 10 et x <= y <= 100. (astuce: importer `random` et appeler `x = random.randint(0, 10)`).
1. Ecrire un programme Python qui génère deux nombres aléatoires x et y avec 0 <= x <= 10 et x <= y <= 100. Le programme affiche ensuite le résultat de la division entière entre y et x et le reste de la division. (penser à gérer le cas où x = 0).
1. Ecrire un programme qui affiche autant de caractères que possible d'une chaîne de caractères  sous forme de suite pyramidale. (astuce: on peut faire un for in sur une chaîne de caractères `for char in chaine`).
    - Exemple pour la chaîne "abcdefghijklmnopqrstuvwxyz" * 10

    ```
    a 
    bc 
    def 
    ghij 
    klmno 
    pqrstu 
    vwxyzab 
    cdefghij 
    klmnopqrs 
    tuvwxyzabc 
    defghijklmn 
    opqrstuvwxyz 
    abcdefghijklm 
    nopqrstuvwxyza 
    bcdefghijklmnop 
    qrstuvwxyzabcdef 
    ghijklmnopqrstuvw 
    xyzabcdefghijklmno 
    pqrstuvwxyzabcdefgh 
    ijklmnopqrstuvwxyzab 
    cdefghijklmnopqrstuvw 
    xyzabcdefghijklmnopqrs
    ```

    - Réponse incorrecte pour la "abcdefghijklmnopqrstuvwxyz"

    ```
    Incorrect
    a 
    bc 
    def 
    ghij 
    klmno 
    pqrstu 
    vwxyz

    Correct
    a 
    bc 
    def 
    ghij 
    klmno 
    pqrstu 
    ```

1. Écrire une fonction `count_letters(texte)` ayant pour argument une chaîne de caractères texte et qui renvoie un dictionnaire qui contient la fréquence de toutes les lettres de la chaîne entrée. Par exemple: `count_letters("hello")` renvoie `{"h": 1, "e": 1, "l": 2, "o": 1}`.
1. Soit des rectangles définis avec des dictionnaires dont les clés sont `"x", "y", "largeur", "hauteur"`.
    - Ecrire une fonction `is_intersecting(rectangle1, rectangle2)` qui retourne `True` s'il y a intersection entre les deux rectangles.
    - Ecrire une fonction `get_intersection(rectangle1, rectangle2)` qui retourne le rectangle intersection s'il existe, sinon `None`.
1. Ecrire une fonction `fx_square(x)` qui retourne le résultat de `x * x`.
    - Ecrire une fonction `fx_square_list(n)` qui retourne une liste de n éléments. La valeur d'un élément d'indice `i` est `fx_square(i)`.
    - Utiliser la librairie `matplotlib` pour dessiner un graphique dont les abscisses sont les entiers allant de 0 à n et les ordonnées sont les éléments retournés par `fx_square_list(n)`.
1. Définir une fonction `fx_square_list2(points)` qui prend en argument une liste d'entiers ordonnées par ordre croissant et retourne une nouvelle liste dont la valeur du i ème élément est `points[i] * points[i]`.
    - Tracer le graphique de **f(x) = x * x** pour x compris entre -100 à 100.
1. Faire le graphique de -100 à 100 des fonctions suivantes: `exp(x)`, `1/x`, `log(x) + (1/(x puissance3))`

## Corrigés série 1

??? "Exos de 1 à 5"

    ```py
    --8<--
    exercices_part1_exo1_5.py
    --8<--
    ```

??? "Exos pyramide, count_letters et intersection"

    ```py
    --8<--
    exercices_part1.py
    --8<--
    ```

??? "plot"

    ```py
    --8<--
    exercices_part1_plot.py
    --8<--
    ```

## Série 2

Résoudre les exercices suivants avec les compréhensions.

1. Créer une liste des 10 premiers nombres pairs
1. Créer un dictionnaire contentant 10 clés allant de 0 à 9. La valeur de chaque clé est un texte indiquant la parité du nombre. (exemple: {0: "paire", 1: "impaire", etc.})
1. Créer un dictionnaire contentant 10 clé allant de 0 à 9 convertie en string. La valeur de chaque clé est une texte indiquant la parité du nombre. (exemple: {"0": "paire", "1": "impaire", etc.})
1. Créer un dictionnaire qui filtre le dictionnaire précédent en ne gardant que les nombres impairs
1. Créer un tuple qui contient les 20 premiers nombres pairs.
1. Soit une liste d'étudiants ou chaque étudiant est défini par un dictionnaire de noms et dates de naissance. Par exemple: 
    ```py
    students = [
        {"name": "Olive", "birth_year": 2001},
        {"name": "Tom", "birth_year": 1975},
        {"name": "Alf", "birth_year": 1701},
    ]
    ```
    - Créer un ensemble des noms des étudiants.
    - Créer un tuple contenant les années de naissance de chaque étudiant.
    - Afficher les noms des étudiants nés après 2000.
    - On suppose que les étudiants nés avant 1980 ont comme souhait de métier est d'être lead dev tandis que les autres veulent être des développeurs. Générer une liste de dictionnaires des noms et son de métier à partir du dictionnaire d'origine.
        - Exemple: `[{"name": "Olive", "job": "dev"}, {"name": "Tom", "job": "lead dev"}, {"name": "Alf", "job": "lead dev"}]`
1. A partir d'un tuple de symboles `("♥️", "♠️", "♣️", "♦️")` et de la liste de rangs `["As", "Roi", "Reine", "Valet"] + [*range(2, 11)]`. Créer un jeu de cartes sous forme d'une liste de tuples qui est le produit cartésien entre les symboles et le rang.
1. Créer une liste de tuples contenant les coordonnées des points (x, y) pour x allant de 0 à 10 et y allant de 0 à 10.
    - Exemple: `[(0, 0), (0, 1), ..., (10, 10)]`
1. Créer une liste de tuples contenant les coordonnées des points (x, y) pour x allant de 0 à 10 et y allant de 0 à 10. Filtrer les points pour ne garder que ceux dont la somme des coordonnées est paire.
    - Exemple: `[(0, 0), (0, 2), (0, 4), ..., (10, 10)]`
1. Créer une liste de tuples contenant les coordonnées des points (x, y) pour x allant de 0 à 10 et y allant de 0 à 10. Filtrer les points pour ne garder que ceux dont la somme des coordonnées est paire et x est supérieur à y.
    - Exemple: `[(2, 0), (4, 0), (4, 2), ..., (10, 8)]`
1. Générer une liste de 10 nombres aléatoires entre 0 et 100.
1. Soit une liste de chaînes de caractères `["hello", "world", "python", "is", "cool"]`. Créer une liste de tuples contenant la chaîne de caractères et sa longueur.
    - Exemple: `[("hello", 5), ("world", 5), ("python", 6), ("is", 2), ("cool", 4)]`


??? "Solutions"

    ```py
    --8<--
    comprehension_exos.py
    --8<--
    ```

## Source

- [Exercices corrigés d'algorithmique Python - Les bases](https://www.tresfacile.net/tp-python-exercices-corriges-dalgorithmique-python-les-bases/)
- [Exercices du site développez](https://algo.developpez.com/exercices/)
- [Sorting Algorithms Animations](https://www.toptal.com/developers/sorting-algorithms)
- [Sites pour apprendre en s’amusant](https://info.blaisepascal.fr/exercices-python/)
