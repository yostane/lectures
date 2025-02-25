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
        - Y-Men, Morvel, 1993.
        - Nario, Nontendo, 1985.
        - Zebda, Nontendo, 1986.
        - First Fantasy, Rectangle, 1987.
        - Paper Gear, Bonami, 1987.
    - A partir de la liste `consoles`, afficher:
        - La liste des consoles fabriquées par Nontendo.
        - La liste des consoles sorties à partir du 1er janvier 1990.
    - A partir de la liste `games`, afficher:
        - La liste des jeux développés par Morvel.
        - La liste des jeux sortis à partir du premier janvier 1985.
1. Créez une classe `Point` qui possède deux propriétés x et y de type correspondant aux coordonnées du point.
    - Implémenter le constructeur `__init__(self, x, y)` qui permet d'initialiser les coordonnées.
    - Implémenter la méthode `__str__` qui représente le point de cette façon (ici, x = 2 et y = 3): `Point | x : 2 | y : 3`
    - Implémenter la méthode `translate(self, tx, ty)` qui ajoute `tx` à `x` et `ty` à `y`.
    - Implémenter la méthode `distance(self, point)` qui retourne la distance entre le point courant et le point passé en paramètre et retourne cela sous forme d'un point.
    - Instancier deux points et :
        - Afficher la distance entre les deux points.
        - Translater le premier point de 2 en x et 3 en y.
        - Afficher les deux points.
        - Afficher la nouvelle distance entre les deux points.
1. Créez une classe `BankAccount` modélisant un compte en banque. La classe possède deux propriétés initialisées dans le constructeur. `balance` correspond au solde du compte. `managementCost` qui correspond au frais de gestion du compte.
    - Implémenter le constructeur `__init__(...)`.
    - Implémenter la méthode `__str__(self)` qui affiche les informations du compte de cette façon: `Compte ( solde: 1000€ | frais de gestion: 13€ )`
    - Implémenter la méthode `debit(self, amount)` qui enlève `amount` au solde du compte uniquement si le solde est suffisant. Elle retourne un booléen qui renvoie `true` si le débit a réussi, sinon `false`.
    - Implémenter la méthode `send(self, bankAccount, amount)` qui transfère de l'argent vers un autre compte uniquement si le solde est suffisant. La méthode retourne un booléen calculé de la même façon que la méthode `debit`.
    - Instancier deux comptes et effectuer des opérations de débit et de transfert. Afficher l'état de réussite de chaque opération et l'état des comptes après chaque opération.

## Série 2

1. Créer une classe `StringUtils` qui contient les méthodes statiques suivantes:
    - `is_palindrome(word: str) -> bool` qui retourne `True` si le mot est un palindrome, `False` sinon
    - `count_vowels(word: str) -> int` qui retourne le nombre de voyelles dans le mot
    - `count_uppercase(word: str) -> int` qui retourne le nombre de majuscules dans le mot
    - `count_lowercase(word: str) -> int` qui retourne le nombre de minuscules dans le mot
