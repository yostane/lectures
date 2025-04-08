# Exercices initiaux

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Série 1

1. Créer un programme Java qui permet de jouer à pile ou face, le programme lance une pièce au hasard et demande à l'utilisateur de saisir pile ou face au clavier. Le programme affiche le résultat et si l'utilisateur a gagné ou perdu.
1. Créer un programme Java qui permet de jouer au jeu de "devine un nombre". Le programme génère un nombre aléatoire entre 1 et 20 (1 et 20 sont inclus) et demande à l'utilisateur de deviner ce nombre. Le programme affiche, pour chaque proposition de l'utilisateur, si le nombre est plus grand ou plus petit que le nombre choisi. Si l'utilisateur trouve le nombre, Le programme affiche le nombre d'essais qu'il lui a fallu pour trouver ce nombre.
1. Écrire un programme Java qui permet d'afficher l'inverse d'une chaîne de caractères. Par exemple, si l'utilisateur saisit "Bonjour", le programme affiche "ruojnoB". Ne pas utiliser de méthodes de la classe String (comme reverse). La chaîne en entrée est passé en argument de la ligne de commande.
1. Écrire un programme Java qui permet de dire si une chaîne de caractères est un palindrome. Un palindrome est un mot qui se lit de la même façon de gauche à droite et de droite à gauche. Par exemple, "radar" est un palindrome. Ne pas utiliser de méthode de la classe String. Faire l'exercice avec et sans la méthode `equals`. La chaîne en entrée est passé en argument de la ligne de commande.
    - Exemples:
        - Si on passe "radar" en entrée, le programme affiche "Palindrome"
        - Si on passe "bonjour" en entrée, le programme affiche "Pas un palindrome"
1. Écrire un programme Java qui permet de saisir un nombre entier et de calculer la somme de ses chiffres. Le programme affiche la somme des chiffres ainsi que le détail du calcul. Le nombre en entrée est passé en argument de la ligne de commande.
    - Exemples :
        - Si on passe 123 en entrée, le programme affiche "6 (1 + 2 + 3 = 6)"
        - Si on passe 1234 en entrée, le programme affiche "10 (1 + 2 + 3 + 4 = 10)"
1. Créer un programme Java qui permet de saisir un entier et de vérifier si cet entier est un nombre premier. Le nombre en entrée est récupéré via le `Scanner`. Rappel : un nombre premier est un nombre qui est divisible par exactement deux entiers distincts (qui sont 1 et le nombre-même). 0 et 1 ne sont pas des nombres premiers par définition (1 n'est pas divisible par deux nombres distincts).

??? "Guess the number"

    ```java
    --8<--
    exo/ex-initial/GuessNumber.java
    --8<--
    ```

??? "Heads or Tails"

    ```java
    --8<--
    exo/ex-initial/HeadsOrTails.java
    --8<--
    ```

??? "Reverse a string"

    ```java
    --8<--
    exo/ex-initial/ReverseManual.java
    --8<--
    ```

??? "Reverse many strings"

    ```java
    --8<--
    exo/ex-initial/ReverseManualMany.java
    --8<--
    ```

??? "Palindrome"

    ```java
    --8<--
    exo/ex-initial/Palindrome.java
    --8<--
    ```

??? "Count digits"

    ```java
    --8<--
    exo/ex-initial/CountDigits.java
    --8<--
    ```

??? "Is prime ?"

    ```java
    --8<--
    exo/ex-initial/IsPrime.java
    --8<--
    ```

## Série 2

1. Créer une application Java qui génère continuellement des nombres aléatoires entre 1 et 5 (inclus) et s'arrête dès que le nombre 3 est généré 5 fois. Avant de s'arrêter, le programme affiche la somme et la moyenne des nombres générés. Ne pas utiliser de tableaux.
1. Créer une application Java qui affiche les 10 premiers termes de la suite de Fibonacci. La suite de Fibonacci est une suite de nombres dans laquelle chaque nombre est la somme des deux précédents. Les deux premiers termes de la suite sont 0 et 1. Par exemple, les 10 premiers termes de la suite de Fibonacci sont : 0, 1, 1, 2, 3, 5, 8, 13, 21, 34.
1. Créer une application Java qui calcule le plus grand diviseur commun (PGCD) de deux entiers. Le PGCD de deux entiers est le plus grand entier qui divise les deux entiers sans reste. Par exemple, le PGCD de 12 et 18 est 6. Le programme affiche les pgcd des couples suivants: 12 et 18 (le pgcd est 6), 48 et 18 (le pgcd est 6), 56 et 42 (le pgcd est 14), 101 et 10 (le pgcd est 1), 100 et 25 (le pgcd est 25).

??? "Solutions"

    ```java title="ContinuousRandomStats"
    --8<--
    exo/ex-initial/ContinuousRandomStats.java
    --8<--
    ```

    ```java title="FibonacciInitial"
    --8<--
    exo/ex-initial/FibonacciInitial.java
    --8<--
    ```
