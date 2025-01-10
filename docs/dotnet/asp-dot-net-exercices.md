# Exercices ASP.NET

## Série 1

1. Créer un endpoint `/pair` qui retourne tous les entiers pairs entre 0 et 20
    - Par exemple, `GET /pair` retourne `[0, 2, 4, 6, 8, 10, ..., 20]`
1. Créer un endpoint `/pair/{nb}` qui retourne tous les entiers pairs entre 0 et nb
    - Par exemple, `GET /pair/10` retourne `[0, 2, 4, 6, 8, 10]`
1. Créer un endpoint `/impair/{nb}` qui retourne tous les entiers impairs entre 0 et nb
    - Par exemple, `GET /impair/10` retourne `[1, 3, 5, 7, 9]`
1. Créer un endpoint `/consonnes/{word}` qui retourne la liste des consonnes d'un mot
    - Par exemple, `GET /consonnes/hello` retourne `["h", "l", "l"]`
1. Créer un endpoint `/longueur/{word}` qui retourne longueurs de la chaîne de caractères word
    - Par exemple, `GET /longueur/hello` retourne `5`


## Série 2

1. Créer un endpoint `/palindrome/{word}` qui retourne `Est un palindrome` si `word` est un palindrome, sinon `N'est pas un palindrome`
    - Par exemple, `GET /palindrome/toto` retourne `N'est pas un palindrome`, et `GET /palindrome/totot` retourne `Est un palindrome`
1. Créer un endpoint `/schtroumpf/{nb1}/{nb2}` qui retourne le schtroumpf d'un tableau de `nb1` éléments aléatoires et d'un tableau de `nb2` éléments aléatoires. Les valeurs des deux tableaux sont comprises entre 1 et 12 
    - voir définition dans [les exos C#](./csharp-exercices.md)
    - Par exemple, `GET /schtroumpf/4/2` avec les tableaux aléatoire `[4, 8, 7, 12]` et `[3, 6]`, le résultat sera `279`
1. Créer un endpoint `/notes` qui génère 10 notes aléatoires et renvoie un json listant les notes, la moyenne et le nombre de notes supérieures à la moyenne.
    - Exemple
        ```json
        {
            "notes": [12, 15, 8, 10, 18, 14, 9, 11, 13, 16],
            "moyenne": 12.6,
            "nbNotesSupMoyenne": 5
        }
        ```
1. Créer un endpoint `/notes/{nb}` qui génère `nb` notes aléatoires et renvoie un json listant les notes, la moyenne et le nombre de notes supérieurs à la moyenne.
    - Exemple: `/notes/10`
        ```json
        {
            "notes": [12, 15, 8, 10, 18, 14, 9, 11, 13, 16],
            "moyenne": 12.6,
            "nbNotesSupMoyenne": 5
        }
        ```

??? "Solutions"
    ```cs title="code"
    --8<--
    aspdotnet/ExercisesApi/Program.cs
    --8<--
    ```

    ```http title="appels de test"
    --8<--
    aspdotnet/ExercisesApi/calls.http
    --8<--
    ```