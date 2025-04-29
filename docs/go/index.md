# Programmation Go

Go est un langage de programmation développé par Google, connu pour sa simplicité et sa performance. Il est utilisé pour le développement de logiciels, d'applications web et de systèmes d'exploitation.

## Apprendre Go

- [Tour de Go](https://go.dev/tour/list) : explorez les fonctionnalités de base du langage Go et notez ses caractéristiques uniques.
    - En supplément [Concepts de Go avec des exemples](https://gobyexample.com/)
- [Création d'une CLI avec Go](https://spf13.com/presentation/building-an-awesome-cli-app-in-go-oscon/)
    - [Version de 2016](https://fr.slideshare.net/slideshow/building-awesome-cli-apps-in-go/62068672)
- [Développement web en Go](https://gowebexamples.com/)

## Développement d'une API REST

- [Gin](https://github.com/gin-gonic/gin) est une librairie Go pour créer des API REST. Elle est rapide et facile à utiliser.
- [sqlite](https://sqlite.org/) est une base de données légère et rapide qui tient dans un fichier et ne nécessite pas de serveur. Le package [database/sql](https://pkg.go.dev/database/sql) de Go permet de se connecter à une base de données SQLite.

## Questions

1. Quel est l'intérêt du package main en Go ?
1. Quelle est la différence entre `:=` et `=` en Go ?
1. Quelle est la différence entre `var` et `const` en Go ?
1. Quelle est la différence entre `nil` et `null` en Go ?
1. Quelle est la différence entre `panic` et `error` en Go ?
1. Quel style d'import est préférable entre imports multiples et une seul import groupé ?
1. Comment exporter un identifiant en Go ?
1. En Go, le type vient avant ou après le nom de la variable ?
1. Que singifie une naked return (ou return nu) en Go ?
1. Dans quel unique endroit peut-on utiliser := ?
1. Est-ce que Go autorise la conversion implicite de types ?
1. Combien de types de boules de Go connaissez-vous ? Quels sont-ils ?
1. Est-ce Go autorise les switch sans condition (ou sans expression après le switch) ?
1. Quelle est la différence entre `[n]T` et `[]T` en Go ?
1. Est-ce qu'un slice est un nouveau tableau ?
1. Que font `make` et `append` en Go ?
1. Est-ce que `append` retourne un nouveau slice ou modifie le slice existant ?
1. Qu'est-ce qu'une closure en Go ?
1. Est-ce que Go a des classes ? Si oui, expliquez comment elles fonctionnent. Sinon, expliquer les alternatives.
1. Quelle est la différence entre une un méthode et une fonction en Go ?
1. QUelles la différence entre un méthode avec un receveur de type pointeur et un receveur de type valeur ?
1. Est-ce que Go renvoir une NPE quand on appelle une méthode d'une interface nulle ?
1. A quoi servent les formateurs %v, %T, %s et %d ?
1. Expliquer comment gèrer les erreurs en Go. Est-ce que Go a des exceptions ?

??? "Réponses"

    1. Le package `main` est le point d'entrée d'une application Go.
    1. `:=` est utilisé pour déclarer et initialiser une variable, tandis que `=` assigne une valeur à une variable déjà déclarée.
    1. `var` déclare une variable, alors que `const` déclare une constante.
    1. `nil` est utilisé en Go pour désigner l'absence de valeur pour les types de référence, `null` étant un concept non applicable en Go.
    1. `panic` est un état d'erreur fatale qui entraîne l'arrêt du programme, alors qu`'error` est une interface qui peut être gérée.
    1. Il est préférable d'utiliser un import groupé pour améliorer la lisibilité du code.
    1. Pour exporter un identifiant en Go, il doit commencer par une majuscule.
    1. En Go, le type vient après le nom de la variable.
    1. Une naked return est une instruction de retour sans argument, qui retourne les valeurs des variables de retour nommées.
    1. On ne peut utiliser `:=` que dans une fonction.
    1. Go n'autorise pas la conversion implicite de types.
    1. Il existe un seul type de boucles en Go qui est la boucle `for`.
    1. Go autorise les switch sans condition, qui permettent de simplifier les conditions multiples.
    1. `[n]T` est un tableau de taille fixe, tandis que `[]T` est une tranche de taille variable.
    1. Un slice est une vue sur un tableau ou un pointeur vers celui-ci.
    1. `make` est utilisé pour créer des slices, des maps et des channels, tandis que `append` est utilisé pour ajouter des éléments à un slice.
    1. `append` retourne un nouveau slice si la capacité du slice est dépassée, sinon il modifie le slice existant.
    1. Une closure est une fonction qui capture les variables de son environnement.
    1. Go n'a pas de classes, mais utilise des structures pour définir des types de données et des méthodes associées, en plus des interfaces pour définir des comportements communs.
    1. Une méthode est une fonction associée à un type, qui peut être appelée sur une instance de ce type.
    1. Une méthode avec un receveur de type pointeur modifie la valeur de l'instance, tandis qu'un receveur de type valeur crée une copie de l'instance.
    1. Go ne renvoie pas de NPE et appelle la méthode avec un receveur nul si elle a un type concret. Néanmoins, si l'interface n'a pas type concret, l'appel de la méthode entraînera une panique.
    1. `%v` affiche la valeur de la variable, `%T` affiche le type de la variable, `%s` affiche la chaîne de caractères et `%d` affiche un entier.
    1. Les erreurs en Go sont gérées en retournant une valeur d'erreur en plus de la valeur de retour, qui peut être vérifiée et traitée par l'appelant. Go n'a pas d'exceptions, mais utilise des valeurs d'erreur pour signaler les erreurs.
    
## Quelques programmes

??? "Sqrt"

    ```go
    --8<--
    go/sqrt/sqrt.go
    --8<--
    ```

??? "pic"

    A lancer depuis l'éditeur en ligne pour avoir un rendu graphique.

    ```go
    --8<--
    go/pic/pic.go
    --8<--
    ```

??? "wordcount"

    ```go
    --8<--
    go/wordcount/wordcount.go
    --8<--
    ```

??? "fibclosure"

    ```go
    --8<--
    go/fibclosure/fibclosure.go
    --8<--
    ```

??? "stringerdemo"

    ```go
    --8<--
    go/stringerdemo/stringerdemo.go
    --8<--
    ```

??? "errordemo"

    ```go
    --8<--
    go/errordemo/errordemo.go
    --8<--
    ```

??? "readerdemo"

    ```go
    --8<--
    go/readerdemo/sqrt.go
    --8<--
    ```

??? "rot13reader"

    ```go
    --8<--
    go/rot13reader/rot13reader.go
    --8<--
    ```
