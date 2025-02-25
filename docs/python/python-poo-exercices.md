---
title: Exerices en POO
---

# Exercices en POO

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Série 1

1. Créer une classe `Personne` avec les attributs `nom`, `prenom` et `age`. Ajouter une méthode `afficher` qui affiche les informations de la personne. Implémenter les méthodes `__eq__` et `__str__`.
    - Créer deux personnes et les afficher.
1. On souhaite gérer un collection de consoles et jeux rétro avec la POO. Définir les classes `VideoGame` et `VideoGameConsole`. Chaque classe propose les propriétés: `name`, `releaseYear`. La classe `VideoGame` a en plus la propriété `developer` qui est la compagnie ou le développeur qui a développé le jeu. La classe `VideoGameConsole` a en plus la propriété `manufacturer` qui est la compagnie qui a fabriqué la console. Implémenter la méthode `__str__`.
    - Créer une liste `consoles` qui contient les consoles suivantes avec les `name`, `manufacturer` et `releaseYear` suivants:
        - DegaDrive, Dega, 1992.
        - Satourne, Dega, 1995.
        - Super Nontendo, Nontendo, 1991.
        - Nontendo, Nontendo, 1983.
        - Ponystation, Pony, 1996.
    - Créer une liste `games` qui contient les jeux suivants avec les `name`, `developer` et `releaseYear` suivants:
        - Sanic, Dega, 1991.
        - Spodermin, Morvel, 1992.
        - Nario, Nontendo, 1985.
        - Zebda, Nontendo, 1986.
        - First Fantasy, Rectangle, 1987.
        - Paper Gear, Bonami, 1987.

## Série 2

1. Créer une classe `StringUtils` qui contient les méthodes statiques suivantes:
    - `is_palindrome(word: str) -> bool` qui retourne `True` si le mot est un palindrome, `False` sinon
    - `count_vowels(word: str) -> int` qui retourne le nombre de voyelles dans le mot
    - `count_uppercase(word: str) -> int` qui retourne le nombre de majuscules dans le mot
    - `count_lowercase(word: str) -> int` qui retourne le nombre de minuscules dans le mot
