# Exercices divers

## Exercice 1

Pour cet exercice, créer le projet avec `gradle init` et utiliser les annotations liées à la null safety.

-   Créer une classe Java `IntCalculator` qui permet de faire des opérations arithmétiques sur des entiers à partir d'une chaîne de caractères au format `opérande1 opération opérande2` et retourne le résultat de cette opération.
    -   les opérandes sont des entiers
    -   Opétation est soit +, -, / ou \*
    -   Vous pouvez utiliser split pour séparer les différentes parties
    -   Utilise les streams au maximum (utiliser les boucles au minimum)
-   Votre calculatrice mémorise toutes les opérations et leurs résultats.
-   Ecrire un programme Java qui permet de soit saisir un opération soit afficher l'historique des opérations selon les commandes de l'utilisateur.
    -   Si l'utilisateur saisit une opération du type `opérande1 opération opérande2`, afficher le résultat et l'ajouter à l'historique.
    -   Si l'utilisateur saisit `h`, afficher l'historique des opérations.
    -   Si l'utilisateur saisit `+`, `-`, , afficher l'historique des opérations pour cette opérande.
    -   Si l'utilisateur saisit `exit`, le programme s'arrête.
    -   Si l'utilisateur saisit un entier, sa valeur est affichée et il est rajouté dans l'historique
-   Gérer les exceptions, notamment celle liées aux erreurs de saisie

```sh title="exemple d'exécution"
#  '>' signifie que c'est une entrée de l'utilisateur. Ce n'est pas un symble à inclure dans votre saisie
> 2 + 5
7
> 100 - 2000
-1900
> 42
42
> h
2 + 5 = 7
100 - 2000 = -1900
42
> +
2 + 5 = 7
> toto
saisie incorrecte
> 88 - 33 * 2
saisie incorrecte
> exit
bye bye
```

## Exercice 2

Pour cet exercice, créer le projet avec `gradle init` et utiliser les annotations liées à la null safety.

-   Créer une classe Java `ImprovedIntCalculator` qui permet de faire des opérations arithmétiques sur des entiers à partir d'une chaîne de caractères au format `opérande1 opération opérande2 opération2 opérande3 ...` et retourne le résultat de cette opération.
    -   les opérandes sont des entiers
    -   Les opérandes écrites avec l'identifiant _mi_ ou i est un entier permet de remplacer mi par le résultat dans l'historique d'indice i.
    -   Opération est soit +, -, / ou \*
    -   Utilise les streams au maximum (utiliser les boucles au minimum)
    -   / et \* sont plus prioritaires que + et -
-   Votre calculatrice mémorise toutes les opérations et leurs résultats.
-   Ecrire un programme Java qui permet de soit saisir un opération soit afficher l'historique des opérations selon les commandes de l'utilisateur.
    -   Si l'utilisateur saisit une opération du type `opérande1 opération opérande2`, afficher le résultat et l'ajouter à l'historique.
    -   Si l'utilisateur saisit `h`, afficher l'historique des opérations.
    -   Si l'utilisateur saisit `+`, `-`, , afficher l'historique des opérations pour cette opérande.
-   Gérer les exceptions, notamment celle liées aux erreurs de saisie

```sh title="exemple d'exécution"
#  '>' signifie que c'est une entrée de l'utilisateur. Ce n'est pas un symble à inclure dans votre saisie
> 2 + 5
7
> 100 - 2000 + 5
-1895
> h
2 + 5 = 7
100 - 2000 + 5 = -1895
> +
2 + 5 = 7
100 - 2000 + 5 = -1895
> toto
saisie incorrecte
> 88 - 33 * 2
22
> 88 - 33 * 2 / 3 + 5
67
> 7 + m0
14
> m2
22
> exit
bye bye
```

## Exercice 3

[Kotlin Heroes 2024, Problem A: 1-3-5](https://codeforces.com/contest/1958/problem/A).

In Berland, coins of worth 1, 3 and 5 burles are commonly used (burles are local currency).

Eva has to pay exactly 𝑛 burles in a shop. She has an infinite amount of coins of all three types. However, she doesn't like to pay using coins worth 1 burle — she thinks they are the most convenient to use.

Help Eva to calculate the minimum number of coins worth 1 burle she has to use, if she has to pay exactly 𝑛 burles. Note that she can spend any number of coins worth 3 and/or 5 burles.

-   Input
    -   The first line contains one integer 𝑡 (1≤𝑡≤100 ) — the number of test cases.
    -   Each test case consists of one line, containing one integer 𝑛(1≤𝑛≤100).
-   Output
    -   For each test case, print one integer — the minimum number of 1-burle coins Eva has to use.

```sh title="input"
5
7
8
42
2
11
```

```sh title="output"
1
0
0
2
0
```