---
title: Exerices en POO
---

# Exercices en POO

!!! warning "Consignes"

    - Ne pas se faire aider par des IA ou genAI

## Série 1

1. Définir une classe `Personne` avec les attributs `nom`, `prenom` et `age`. Ajouter une méthode `afficher` qui affiche les informations de la personne. Implémenter les méthodes `__eq__` et `__str__`.
    - Créer quelques personnes et les afficher..
    - Afficher le résultat du `==`
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
1. Définir une classe `Point` qui possède deux propriétés x et y de type correspondant aux coordonnées du point.
    - Implémenter le constructeur `__init__(self, x, y)` qui permet d'initialiser les coordonnées.
    - Implémenter la méthode `__str__` qui représente le point de cette façon (ici, x = 2 et y = 3): `Point | x : 2 | y : 3`
    - Implémenter la méthode `translate(self, tx, ty)` qui ajoute `tx` à `x` et `ty` à `y`.
    - Implémenter la méthode `distance(self, point)` qui retourne la distance entre le point courant et le point passé en paramètre et retourne cela sous forme d'un point.
    - Instancier deux points et :
        - Afficher la distance entre les deux points.
        - Translater le premier point de 2 en x et 3 en y.
        - Afficher les deux points.
        - Afficher la nouvelle distance entre les deux points.
1. Définir une classe `BankAccount` modélisant un compte en banque. La classe possède deux propriétés initialisées dans le constructeur. `balance` correspond au solde du compte. `managementCost` qui correspond au frais de gestion du compte.
    - Implémenter le constructeur `__init__(...)`.
    - Implémenter la méthode `__str__(self)` qui affiche les informations du compte de cette façon: `Compte ( solde: 1000€ | frais de gestion: 13€ )`
    - Implémenter la méthode `debit(self, amount)` qui enlève `amount` au solde du compte uniquement si le solde est suffisant. Elle retourne un booléen qui renvoie `true` si le débit a réussi, sinon `false`.
    - Implémenter la méthode `send(self, bankAccount, amount)` qui transfère de l'argent vers un autre compte uniquement si le solde est suffisant. La méthode retourne un booléen calculé de la même façon que la méthode `debit`.
    - Instancier deux comptes et effectuer des opérations de débit et de transfert. Afficher l'état de réussite de chaque opération et l'état des comptes après chaque opération.
1. On souhaite générer des prédictions météorologiques sur une durée de 30 jours et faire des traitements dessus. Définir la classe `WeatherForecast` avec la propriété `day` (entier entre 1 et 30) et `temperature` (entier qui représente la température en Celsius).
    - Implémenter le constructeur
    - Implémenter la méthode `to_farhenheit(self)` qui retourne la température en Fahrenheit avec la formule suivante: `F = C * 9/5 + 32`
    - Implémenter la méthode `__str__` qui affiche la prévision de cette façon: `Jour 1: 20°C | 68°F`
    - Instancier une liste de de 30 prévisions pour chacun des jours avec des températures aléatoires sous forme d'entier entre -10 et 40 degrés.
    - Calculer les résultats suivants sans utiliser `avg`, `min`, `max`.
        - La température moyenne sur les 30 jours.
        - La température la plus faible ainsi que les jours où cette température a été enregistrée. Par exemple si la température la plus faible est -10, on doit afficher les jours où -10 a été enregistré.
        - La température la plus élevée ainsi que les jours où cette température a été enregistrée.
        - Afficher les prévisions triées par température croissante avec et sans utiliser les méthodes de tri prédéfinies.
        - Afficher les prévisions triées par température décroissante avec et sans utiliser les méthodes de tri prédéfinies.
        - Le nombre de jours où la température est supérieure à 20°C et le nombre de jours où la température est inférieure à 0°C.
        - Un dictionnaire qui compter le nombre prévisions qui ont les mêmes températures. Par exemple si 5 jours ont une température de `20°C`, et les reste des jours ont `-5°C` le dictionnaire sera `{"20°C": 5, "-5°C": 25}`.
1. Générateur de personnage RPG et un simulateur de combat.
    - Définir la classe `Character` avec les attributs `name`, `level`, `attack` et `health`. Implémenter une méthode `attack(self, target)` (où target est un `Character`) qui diminue la santé de la cible. Ajouter une méthode `is_alive(self)` qui retourne `True` si le personnage est vivant, `False` sinon. Implémenter le constructeur qui initialise les attributs `name`, `level`, `attack` (entier aléatoire entre 1 et 5) et `health` (entier aléatoire entre 10 et 20). Implémenter une méthode `heal(self)` qui rétablit `health` de `5 + level // 10` (// est la division entière).
    - Définir la fonction `fight(character1, character2)` qui simule un combat entre deux personnages. Le combat se déroule de la façon suivante:
        - Tant que les deux personnages sont vivants, ils s'attaquent à tour de rôle.
        - Le personnage 1 attaque le personnage 2, puis le personnage 2 attaque le personnage 1.
        - L'attaque de p1 envers p2 diminue le `health` de p2 avec la formule suivante `p2.health - p1.attack * (réel aléatoire entre 0.75 et 1.25)`.
        - Le déroulement du combat est affiché au fur et à mesure.
        - `health` doit toujours être >= 0
    - Définir la fonction `fight_alternative(character1, character2)` qui reprend le même algo que `fight`, mais permet au joueur actuel d'appeler sa méthode `heal` en plus d'attaquer. La méthode `heal` est appelée si un nombre aléatoire en 50 et 100 généré au moment où son tour débute est strictement inférieur à son `(numéro du tour * level) / health`. Par exemple, si le joueur 1 a un niveau de 5 et 2 points de vie et qu'au tour 30, le nombre aléatoire est 60, alors le joueur 1 peut se soigner car `(30 * 5) / 2  = 75 est supérieur à 60`. Par contre, si le nombre aléatoire généré était de 75 ou plus, alors le joueur ne peut pas se soigner.

??? "Solution Person"

    ```python
    --8<--
    python/poo/ex_person.py
    --8<--
    ```

## Série 2

1. Créer une classe `StringUtils` qui contient les méthodes statiques suivantes:
    - `is_palindrome(word: str) -> bool` qui retourne `True` si le mot est un palindrome, `False` sinon
    - `count_vowels(word: str) -> int` qui retourne le nombre de voyelles dans le mot
    - `count_uppercase(word: str) -> int` qui retourne le nombre de majuscules dans le mot
    - `count_lowercase(word: str) -> int` qui retourne le nombre de minuscules dans le mot
