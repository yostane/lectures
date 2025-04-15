# Exercices sur les tableaux

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Série 1

1. Créer un programme Java qui génère un tableau aléatoire de 10 entiers compris entre -10 et 10 et affiche (Il faut calculer vous-même les valeurs avec une boulce for) :
    - La plus grande valeur
    - La plus petite valeur
    - La moyenne
    - L'écart type dont la formule est : `racine carrée (somme((x - moyenne)²) / n)`
    - Le nombre de valeurs positives et le nombre de valeurs négatives
    - Le nombre de valeurs paires et le nombre de valeurs impaires
1. Créer une programme Java qui met dans un tableau les 10 premiers nombres premiers posifitfs.
    - Rappel : un nombre premier est un nombre qui qui est divisible par exactement deux entiers disctints (qui sont 1 et le nombre-même). 0 et 1 ne sont pas des nombres premiers par définition (1 n'est pas divisible par deux nombres distincts).
1. Créer un fonction Java qui calcule le *schtroumph* de deux tableaux qui ne sont pas forcément de la même taille ([source](https://laure.gonnord.org/pro/teaching/AlgoProg1011_IMA/quick1_2010_corr.pdf)). Pour calculer le schtroumpf, il faut multiplier chaque élément du premier tableau par chaque élément du deuxième, et additionner le tout.
    - Par exemple si l'on a : Tableau 1 -> 4 8 7 12, Tableau 2 : 3 6. Le Schtroumpf sera : 3 ∗ 4 + 3 ∗ 8 + 3 ∗ 7 + 3 ∗ 12 + 6 ∗ 4 + 6 ∗ 8 + 6 ∗ 7 + 6 ∗ 12 = **279**
    - Créer un programme Java qui génère deux tableaux de taille aléatoire (entre 3 et 8) et de valeurs aléatoires (entre -10 et 10 inclus)  et qui calcule leur schtroumpf.
1. Créer une fonction qui prend un tableau d’entiers (`int[] numbers`) et affiche la plus grande valeur et la plus petite valeur (Il faut calculer vous-même le max et le min)
    - Générer un tableau de 10 entier aléatoires et afficher le max et le min
    - Générer un tableau de 10 entiers saisis au clavier et afficher le max et le min

??? "Solutions"

    ```java title="stats" linenums="1"
    --8<--
    exo/serie-2/Serie2Ex1.java
    --8<--
    ```

    ```java title="10 premiers nombres premiers" linenums="1"
    --8<--
    exo/serie-2/First10Prime.java
    --8<--
    ```

    ```java title="Schtroumphons 💻" linenums="1"
    --8<--
    exo/serie-2/Schtroumph2Arrays.java
    --8<--
    ```

    ```java title="Random min and max"
    --8<--
    exo/RandomMinMax.java
    --8<--
    ```

## Série 2
