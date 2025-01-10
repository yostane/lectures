---
title: Programmation fonctionnelle
---

# Programmation fonctionnelle

- Les fonctions sont des éléments de première classe : Les fonctions sont comme des variables
- Utilisation intensive de fonctions pures : fonction sans effet de bord, toujours le même résultat pour les mêmes entrées
    - exemples de fonctions par pure: print (car elle change la console)
- Immutabilité
    - On ne peut pas changer la valeur d'une variable une fois initialisée
    - On ne peut pas changer les propriétés d'un object une fois instancié
    - On ne peut pas ajouter ou supprimer des éléments d'une collection
- On le code est développé sous forme d'une chaîne de traitements (comme dans une usine)

## Relation entre la POO et la programmation fonctionnelle

- La POO est la prog. fonctionnelle ne sont pas mutuellement exclusifs
- On peut développer en POO avec un style fonctionnelle:
    - Les méthodes ne font pas de mutation de champs de l'objet
    - Les propriétés sont uniquement en read-only
    - Les `records` simplifient la création de ce genre de classes
