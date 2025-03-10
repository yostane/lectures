# Programmation Go

Go est un langage de programmation développé par Google, connu pour sa simplicité et sa performance. Il est utilisé pour le développement de logiciels, d'applications web et de systèmes d'exploitation.

## Apprendre Go

- [Tour de Go](https://go.dev/tour/list) : explorez les fonctionnalités de base du langage Go et notez ses caractéristiques uniques.
    - En supplément [Concepts de Go avec des exemples](https://gobyexample.com/)
- [Création d'une CLI avec Go](https://spf13.com/presentation/building-an-awesome-cli-app-in-go-oscon/)
    - [Version de 2016](https://fr.slideshare.net/slideshow/building-awesome-cli-apps-in-go/62068672)
- [Développement web en Go](https://gowebexamples.com/)

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
    

## Exercices

1. Créer un package `math` contenant une fonction qui prend deux entiers en paramètres et retourne leur somme.
1. Ecrire un programme qui crée deux variables avec des valeurs alétoires et ensuite permute leurs valeurs.
