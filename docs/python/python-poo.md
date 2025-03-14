---
title: Programmation orientée objet
---

# Programmation orientée objet

Le paradigme OOP voit le programme comme un ensemble d'objets qui interagissent entre eux.

## Classes, objets et héritage

- Chaque objet est défini par une classe qui elle même hérite d'autres classes ou interfaces.
- Une classe peut définir des propriétés et des méthodes, qu'on appelle des **membres**.
    - Propriété : une vue sur une donnée via ses **accesseurs** en lecture et / ou écriture (qu'on appelle getters et setters respectivement).
    - Méthode : fonction qui est définie au sein de la classe
    - Constructeur : méthode particulière qui sera appelée automatiquement au moment de la création de l'instance
- En python, le premier argument des méthodes et du constructeur est une référence vers l'objet actuel
    - Le nom de cet argument doit s'appeler `self` (appelé `this` dans d'autres langages)
    - On appelle `self` le contexte de la méthode
- Une classe enfant peut hériter d'une classe parente:
    - Dans ce cas, la classe enfant contiendra implicitement tous les membres de la classe mère
    - La classe enfant peut définir des membres supplémentaires qui lui seront propres
    - La classe enfant peut redéfinir des membres de classe parent. On appelle cela une surcharge ou **override** en Anglais.
- Python est l'un des rares langages (avec le C++) à permettre l'héritage multiple. i.e. une classe peut hériter de plusieurs classes à la fois.

```py title="Définition d'une classe"
--8<--
poo_1.py
--8<--
```

```py title="Héritage"
--8<--
poo_2.py
--8<--
```

## UML

- UML (Unified Modeling Language) est un langage de modélisation graphique pour la conception de logiciels.
- Il permet de représenter les classes, les objets, les relations entre les objets, les cas d'utilisation, les séquences, etc.

![Exemple UML](./img/01-poo.drawio.svg)

```py title="Deux classes qui héritent d'une classe"
--8<--
poo_3.py
--8<--
```

## Propriétés, classes et méthodes statiques

- Propriété d'instance : chaque instance a ses propres propriétés d'instances
- Propriété statique : elle sera partagée entre toutes les instances (comme une variable globale pour la classe)
- Méthode d'instance : sera exécutée dans le contexte de l'instance qui l'a appelée (accessible via `self`)
- Méthode statique : méthode qui a comme contexte que les propriétés et méthodes statiques de sa classe
- Classe statique : une classe qui ne peut pas être instanciée et ne contiendra donc que des propriétés et méthodes statiques

## Propriétés, classes et méthodes abstraites

- Méthode abstraite: méthode qui n'a pas d'implémentation
- Propriété abstraite: propriété dont les accesseurs ne sont pas définis
- Classe abstraite: une classe qui a au moins une propriété ou méthode abstraite
- Les membres abstraits sont destinés à être définis par une sous-classe non abstraite.
