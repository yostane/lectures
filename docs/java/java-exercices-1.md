# Exercices initiaux

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Exercice 1

Créer un programme Java qui permet de jouer à pile ou face, le programme lance une pièce au hasard et demande à l'utilisateur de saisir pile ou face au clavier. Le programme affiche le résultat et si l'utilisateur a gagné ou perdu.

??? "Guess the number"

    ```java
    --8<--
    exo/serie-1/GuessNumber.java
    --8<--
    ```

## Exercice 2

Créer un programme Java qui permet de jouer au jeu de "devine un nombre". Le programme génère un nombre aléatoire entre 1 et 20 (1 et 20 sont inclus) et demande à l'utilisateur de deviner ce nombre. Le programme affiche, pour chaque proposition de l'utilisateur, si le nombre est plus grand ou plus petit que le nombre choisi. Si l'utilisateur trouve le nombre, Le programme affiche le nombre d'essais qu'il lui a fallu pour trouver ce nombre.

??? "Heads or Tails"

    ```java
    --8<--
    exo/serie-1/HeadsOrTails.java
    --8<--
    ```

## Exercice 3

Écrire un programme Java qui permet d'afficher l'inverse d'une chaîne de caractères. Par exemple, si l'utilisateur saisit "Bonjour", le programme affiche "ruojnoB". Ne pas utiliser de méthodes de la classe String (comme reverse).

La chaîne en entrée est passé en argument de la ligne de commande.

??? "Reverse a string"

    ```java
    --8<--
    exo/serie-1/ReverseManual.java
    --8<--
    ```

??? "Reverse many strings"

    ```java
    --8<--
    exo/serie-1/ReverseManualMany.java
    --8<--
    ```

## Exercice 4

Écrire un programme Java qui permet de dire si une chaîne de caractères est un palindrome. Un palindrome est un mot qui se lit de la même façon de gauche à droite et de droite à gauche. Par exemple, "radar" est un palindrome. Ne pas utiliser de méthode de la classe String. Faire l'exercice avec et sans la méthode `equals`.

La chaîne en entrée est passé en argument de la ligne de commande.

Exemples:

-   Si on passe "radar" en entrée, le programme affiche "Palindrome"
-   Si on passe "bonjour" en entrée, le programme affiche "Pas un palindrome"

??? "Palindrome"

    ```java
    --8<--
    exo/serie-1/Palindrome.java
    --8<--
    ```

## Exercice 5

Écrire un programme Java qui permet de saisir un nombre entier et de calculer la somme de ses chiffres. Le programme affiche la somme des chiffres ainsi que le détail du calcul.

Le nombre en entrée est passé en argument de la ligne de commande.

Exemples :

-   Si on passe 123 en entrée, le programme affiche "6 (1 + 2 + 3 = 6)"
-   Si on passe 1234 en entrée, le programme affiche "10 (1 + 2 + 3 + 4 = 10)"

??? "Count digits"

    ```java
    --8<--
    exo/serie-1/CountDigits.java
    --8<--
    ```

## Exercice 6

Créer un programme Java qui permet de saisir un entier et de vérifier si cet entier est un nombre premier.

Le nombre en entrée est récupéré via le `Scanner`.

Rappel : un nombre premier est un nombre qui qui est divisible par exactement deux entiers disctints (qui sont 1 et le nombre-même). 0 et 1 ne sont pas des nombres premiers par définition (1 n'est pas divisible par deux nombres distincts).

??? "Is prime ?"

    ```java
    --8<--
    exo/serie-1/IsPrime.java
    --8<--
    ```
