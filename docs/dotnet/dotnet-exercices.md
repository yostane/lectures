# Exercices

!!! warning "Consignes"

    - Activer la null safety
    - Ne pas utiliser les fonctions de tri de .Net

## Collections

### Partie 1

Utiliser `foreach` si besoin (et ne pas utiliser LINQ: Select, etc.):
    
1. Créer une fonction qui prend une liste d'entiers en argument et affiche uniquement les entiers pairs.
1. Créer une fonction qui prend une liste d'entiers en argument et retourne la liste des entiers pairs.
1. Créer une fonction qui prend une chaîne de caractères en argument (string) et retourne la liste de ses consonnes (pour rappel, les voyelles sont a, i, u, e, o et y).
1. Créer une fonction qui prend une liste de chaînes de caractères et retourne la liste des longueurs de chaque chaîne.
    - Par exemple: `["hello", "C#"]` retourne `[5, 2]`
1. Définir un `record` `Person` avec les propriétés `Name` et `Age`. Créer une liste de personnes et:
    1. afficher les personnes dont l'âge est supérieur à 18 ans.
    1. afficher les personnes dont le nom commence par la lettre 'A'.
    1. Créer une fonction qui change le nom en Camel case de chaque personne.
        - Par exemple: `Person("john doe", 20)` devient `Person("John Doe", 20)`
    1. Créer un fonction qui donne l'âge moyen des personnes.

??? "Corrections"
    ```cs title="1"
    --8<--
    dotnet/collection_exo/ex1.cs
    --8<--
    ```

    ```cs title="2"
    --8<--
    dotnet/collection_exo/ex2.cs
    --8<--
    ```

    ```cs title="3"
    --8<--
    dotnet/collection_exo/ex3.cs
    --8<--
    ```


### Partie 2

Utiliser LINQ pour la partie algorithmie. Utiliser `foreach` uniquement pour l'affichage.

1. Refaire les exos de la partie 1 avec LINQ.
1. Créer une fonction qui prend un entier n. La fonction génère une liste de n entiers aléatoires entre 0 et 100 et affiche le min, le max, la somme et la moyenne.
    - Par exemple: si `n = 5` génère le tableau `[10, 20, 30, 40, 50]`, afficher `min: 10, max: 50, sum: 150, avg: 30`
1. Créer une fonction qui prend une liste de chaînes de caractères et retourne la liste des chaînes de caractères triées par ordre croissant de longueur. (💡 utiliser `OrderBy((s) => s.Length)`).
    - Par exemple: `["hello", "C#", "world"]` retourne `["C#", "hello", "world"]`
1. Créer une fonction qui prend une liste de chaînes de caractères et retourne le nombre de caractères total de toutes les chaînes.
    - Par exemple: `["hello", "C#", "world"]` retourne `12`
1. Créer une fonction qui prend une liste de chaînes de caractères et retourne le nombre de mots qui ont une longueur supérieure à 3.
    - Par exemple: `["hello", "C#", "world"]` retourne `2`
1. Définir un `record` `Ninja` avec les propriétés `Name`, `Hp` et `IsHokage`. Créer une liste de ninjas et:
    - Afficher les noms des Hokage.
        - Par exemple: `Ninja("Naruto", 150, true)` et `Ninja("Sasuke", 120, false)` retourne `Naruto`
    - Afficher le nombre de ninjas qui ont plus de 100 points de vie.
        - Par exemple: `Ninja("Naruto", 150, true)` et `Ninja("Sasuke", 120, false)` retourne `2`
    - Afficher le nom ninja qui a le plus de points de vie.
        - Par exemple: `Ninja("Naruto", 150, true)` et `Ninja("Sasuke", 120, false)` retourne `Naruto`

??? "Corrections"
    ```cs
    --8<--
    dotnet/linq-exercices/Program.cs
    --8<--
    ```

## Fichiers

1. Utiliser les `StreamReader` et / ou `StreamWriter` pour lire et un fichier et:
    - Afficher le nombre de caractères de chaque ligne de ce fichier
    - Génère un fichier qui ajoute un point à la fin de chaque ligne du fichier d'origine si elle n'est pas déjà présente
    - Génère un fichier qui contient la ligne qui a le plus de caractères dans le fichier lu
    - Génère un fichier qui contient les lignes du fichier lu triés par ordre croissant le nombre de caractères de la ligne
    - Génère un fichier qui contient les lignes du fichier lu triés par ordre croissant du dictionnaire
1. Utiliser un `StreamWriter` pour écrire dans un fichier le contenu d'une chaîne de caractères au format pyramidal. Par exemple "Je-fais-des-exos-de-C#" donne le fichier (le dernier caractère sera ignoré car il ne permet pas de faire une pyramide):
    ```txt
    J
    e-
    fai
    s-de
    s-exo
    s-de-C
    ```
1. Définir votre propose classe de journalisation (`Logger`) qui va servir à écrire des logs dans un fichier.
    - La classe prend en argument du constructeur le nom du fichier de logs
    - La classe propose les méthodes: `Info(String message)` et `Warn(String message)`. Chacune des méthodes ajoute une ligne au fichier avec le format:
        - Si c'est une Info: `{date et heure actuelle} ℹ️ {message}`
        - Si c'est un Warn: `{date et heure actuelle} ⚠️ {message}`
    - ⚠️: Attention à bien fermer le fichier une fois l'écriture du log faite (pour le libérer)
    - Créer une instance de la classe `Logger` et ajouter quelques logs
    - Ajouter les méthodes `Error(String message)` et `Debug(String message)` avec un format adapté et basé sur le même principe que les méthodes définies plus haut.
    - Définir une méthode `ShowAllWarnings()` qui affiche tous les logs de type `Warn` présents dans le fichier de log.
    - Est-ce que vous voyez des inconvénients / contraintes avec cette méthode de journalisation ?
1. Faire le [problème 1 de advent of code 2023](https://adventofcode.com/2023/day/1) en chargeant les données d'entrée depuis un fichier.
    - Par exemple pour l'exercice 1 du problème, créer à la main (avec vscode ou l'explorateur) un fichier `input1.txt` avec le contenu ci-dessous et le lire avec un StreamReader pour résoudre le problème.
    ```txt
    1abc2
    pqr3stu8vwx
    a1b2c3d4e5f
    treb7uchet
    ```

??? "Corrections"
    ```cs 
    --8<--
    file_exo/Program.cs
    --8<--
    ```

## Série 2 (programmation asynchrone)

En C#, la méthode recommandée pour exécuter des traitements asynchrones (qui sont mis en oeuvre habituellement avec les threads et les process) consiste à utiliser “Task.Run(() => { // traitement async })”. On dit que c’est une programmation asynchrone basée sur les tâches.

1. Créer deux tâches asynchrones (en faisant deux Task.Run)
    - La première affiche un valeur qui s’incrémente de 1 à 1000 (une boucle for qui affiche i à chaque itération)
    - La deuxième affiche un valeur qui va de -1 à -1000 (une boucle for de -1 à -1000 avec un writeline)
    - Pour laisser le temps aux tâches concurrentes de finir avant la fin du thread principal, ajouter un await Task.Delay(1000); à la fin de la tâche principale
    - Exécuter le programme plusieurs fois, que constatez vous ?
    - Afficher `finished 1` juste à la fin de la première tâche (sans utiliser `await` et `ContinueWith`)
    - -> solution: utiliser une callback sous forme d’une fonction passée en paramètre
    - En utilisant `ContinueWith` afficher `finished 1` juste après la fin de la première tâche
    - Remplacer chaque `Task.Run` par `await Task.Run`. Que constatez-vous ?
    - En utilisant `await`, comment afficher “finished 2” dès la fin de la deuxième tâche ?
1. Dans la première tâche, ajouter une instruction ‘return “tartatin”;’ après la boucle for. Ensuite remplacer le premier `await Task.Run` par un var `result = await Task.Run`.
    - Quel est le type et la valeur de result ?
    - Enlever await, c’est à dire remplacer `var result = await Task.Run` par `var result = Task.Run`
    - Quel est le type et la valeur de result ?
    - A quoi sert `await` ? Quel est sa relation avec le type `Task` ?
