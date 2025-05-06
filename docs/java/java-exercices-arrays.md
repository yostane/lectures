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
    - Par exemple si l'on a : Tableau 1 -> {4, 8, 7, 12}, Tableau 2 : {3, 6}. Le Schtroumpf sera : 3 ∗ 4 + 3 ∗ 8 + 3 ∗ 7 + 3 ∗ 12 + 6 ∗ 4 + 6 ∗ 8 + 6 ∗ 7 + 6 ∗ 12 = **279**
    - Créer un programme Java qui génère deux tableaux de tailles aléatoire (entre 3 et 8) et de valeurs aléatoires (entre -10 et 10 inclus)  et qui calcule leur schtroumpf.
1. Créer une fonction qui prend un tableau d’entiers (`int[] numbers`) et affiche la plus grande valeur et la plus petite valeur (Il faut calculer vous-même le max et le min)
    - Générer un tableau de 10 entier aléatoires et afficher le max et le min
    - Générer un tableau de 10 entiers saisis au clavier et afficher le max et le min
1. Créer une fonction `int countVowels(String[] words)` qui compte le nombre total de voyelles du tableau de mots passé en argument. Utiliser une boucle *for* (ou *for each*) imbriquée pour résoudre cet exercice.
    - Par exemple, pour `{"Bonjour", "le", "monde"}`, le résultat sera 6 (3 + 1 + 2).
    - Créer un programme Java qui génère une liste de 5 mots pris aléatoirement depuis la liste données ci-après et qui affiche le nombre total de voyelles de cette liste. Les mots disponibles sont : `{"Bonjour", "le", "monde", "Java", "est", "un", "langage", "de", "programmation", "orienté", "objet"}`.

??? "Solutions"

    ```java title="stats" linenums="1"
    --8<--
    java/common/exo/ex-serie-2/Serie2Ex1.java
    --8<--
    ```

    ```java title="10 premiers nombres premiers" linenums="1"
    --8<--
    java/common/exo/ex-serie-2/First10Prime.java
    --8<--
    ```

    ```java title="Schtroumphons 💻" linenums="1"
    --8<--
    java/common/exo/ex-serie-2/Schtroumph2Arrays.java
    --8<--
    ```

    ```java title="Random min and max"
    --8<--
    java/common/exo/ex-serie-2/RandomMinMax.java
    --8<--
    ```

## Série 2

1. Un **spaceshooter** est un type de jeu dans lequel un vaisseau, vu du dessus, parcourt le niveau du bas vers le haut. Un niveau du spaceshoorter est représenté par un tableau 2D de 10 lignes et 10 colonnes. Chaque case du tableau peut être vide ou contenir un ennemi. Un ennemi est représenté par un caractère `E` et une case vide par un caractère `.`. Le vaisseau est représenté par le caractère `V`. On va considérer que la ligne 0 représente la fin du niveau et la ligne 9 son début.
    - Créer un niveau de jeu en remplissant aléatoirement le tableau 2D d'ennemis, de vides et d'un joueur avec les contraintes suivantes:
        - Le joueur doit être sur la ligne 9 (la dernière ligne) au milieu du tableau (colonne 4 ou 5 aléatoire)
        - Il doit y avoir au maximum 7 ennemis dans le niveau.
        - Il n'y a pas d'ennemis sur les 2 premières lignes du niveau (lignes 9 et 8).
    - Afficher le niveau de jeu dans la console.
    - Astuces : utiliser `char[][]` comme type de tableau.
1. On souhaite développer un mode **démo** dans lequel le jeu joue automatiquement en suivant cet algorithme:
    - Le vaisseau se déplace d'une case vers le haut s'il n'y a pas d'ennemis.
    - S'il y a un obstacle, le vaisseau se déplace d'une case vers la droite tant qu'il y a un ennemi dans la case du dessus. S'il n'y a plus d'ennemis, il se déplace d'un case vers le haut.
    - Si le vaisseau ne peut plus se déplacer à droite, il se déplace vers la gauche d'un case tant qu'il y a un ennemi au dessus. S'il atteint le mur gauche et ne peut plus se déplacer, c'est la fin du jeu (game over).
    - Si le joueur atteint la ligne 0, il a gagné (win).
    - Générer une carte de jeu aléatoire et afficher le déroulement du jeu dans la console. A la fin de la partie, afficher le nombre de déplacements total et si le vaisseau a atteint la fin ou s'il a perdu.
