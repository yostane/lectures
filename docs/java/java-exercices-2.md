# Exercices sur les tableaux

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Exercice 1

- Créer un programme Java qui génère un tableau aléatoire de 10 entiers compris entre -10 et 10 et affiche (Il faut calculer vous-même les valeurs avec une boulce for) :
  - La plus grande valeur
  - La plus petite valeur
  - La moyenne
  - L'écart type dont la formule est : `racine carrée (somme((x - moyenne)²) / n)`
  - Le nombre de valeurs positives et le nombre de valeurs négatives
  - Le nombre de valeurs paires et le nombre de valeurs impaires

??? "Série 2 exo 1"

    ```java linenums="1"
    --8<--
    exo/serie-2/Serie2Ex1.java
    --8<--
    ```

## Exercice 2

Créer une programme Java qui met dans un tableau les 10 premiers nombres premiers posifitfs.

Rappel : un nombre premier est un nombre qui qui est divisible par exactement deux entiers disctints (qui sont 1 et le nombre-même). 0 et 1 ne sont pas des nombres premiers par définition (1 n'est pas divisible par deux nombres distincts).

??? "10 premiers nombres premiers"

    ```java linenums="1"
    --8<--
    exo/serie-2/First10Prime.java
    --8<--
    ```

## Exercice 3

Créer un fonctione Java qui calcule le schtroumph de deux tableaux qui ne sont pas forcément de la même taille ([source](https://laure.gonnord.org/pro/teaching/AlgoProg1011_IMA/quick1_2010_corr.pdf)). Pour calculer le schtroumpf, il faut multiplier chaque élément du premier tableau par chaque élément du deuxième, et additionner le tout. Par exemple si l'on a :

- Tableau 1 : 4 8 7 12
- Tableau 2 : 3 6
- Le Schtroumpf sera : 3 ∗ 4 + 3 ∗ 8 + 3 ∗ 7 + 3 ∗ 12 + 6 ∗ 4 + 6 ∗ 8 + 6 ∗ 7 + 6 ∗ 12 = 279

Créer un programme Java qui génère deux tableaux aléatoires (de valeurs de entre -10 et 10 inclus) de taille aléatoire ( 2 <= nombre d'éléments < 5) et qui calcule leur schtroumpf.

??? "Schtroumphons 💻"

    ```java linenums="1"
    --8<--
    exo/serie-2/Schtroumph2Arrays.java
    --8<--
    ```

## Exercice 4

-   Créer une fonction qui prend un tableau d’entiers “int[] numbers” et affiche la plus grande valeur et la plus petite valeur (Il faut calculer vous-même le max et le min)
-   Générer un tableau de 10 entier aléatoires et afficher le max et le min
-   Générer un tableau de 10 entiers saisis au clavier et afficher le max et le min

-   Supposons qu'on ait deux cercles : un cercle de centre A et de rayon Ra, et un cercle de centre B et de rayon Rb. Les coordonnées de A sont notées (xa, ya) et les coordonnées de B sont notées (xb, yb). On souhaite écrire un algorithme (très simple) permettant de dire si les deux cercles se rentrent dedans. La distance entre les deux centres A et B est: `sqrt((xb-xa)² + (yb-ya)²)`
    -   Donner la condition qui permet de savoir s’il y a collision (ou pas) entre les cercles
    -   Exprimer cette condition sans racine carrée
    -   Ecrire une fonction `isCollision` qui prend les informations de deux cercles en arguments et renvoie `true` s’il y a collision entre les deux cercles, sinon `false`.
    -   Faire cet exercice en définissant une classe Circle et `isCollision` comme une méthode de cette classe

??? "Random min and max"

    ```java
    --8<--
    exo/RandomMinMax.java
    --8<--
    ```

??? "CircleCollisionDetector"

    ```java
    --8<--
    exo/CircleCollisionDetector.java
    --8<--
    ```