# Exercices PostgreSQL avancé

## JSONB

Soit une table `Houses` qui représente des maisons.
Elle contient les colonnes suivantes:

- `id` : identifiant unique de la maison.
- `address` : adresse de la maison.
- `rooms`: la liste des chambres de la maison. Chaque chambre est représentée par un objet JSON contenant les propriétés suivantes:
    - `name`: le nom de la chambre.
    - `size`: la taille de la chambre en mètres carrés.

1. Créer la table
1. Insérer les maisons suivantes: 
    - Maison 1: adresse "123 Elm St", avec les chambres "Salon" (taille 20 m²), "Bureau" (taille 15 m², couleur: blanche).
    - Maison 2: adresse "456 Elm St", avec les chambres "Salon" (taille 25 m²), "Bureau" (taille 18 m²), "Cuisine" (taille 12 m², appareils: Cafetière, Four).
    - Maison 3: adresse "789 Oak St", avec les chambres "Salon" (taille 30 m²), "Bureau" (taille 20 m²), "Cuisine" (taille 15 m², appareils: Réfrigérateur, Lave-vaisselle), "Chambre" (taille 18 m², lit: Queen).
1. Écrire une requête SQL pour récupérer toutes les maisons avec leurs chambres.
1. Écrire une requête SQL pour récupérer les maisons de "Elm St" qui ont une chambre de taille supérieure à 20 m².
1. Écrire une requête SQL pour récupérer les maisons qui ont une chambre nommée "Cuisine" avec un appareil "Cafetière".
1. Si on voulait représenter les maisons et leurs chambres avec une approche 100% relationnelle, comment structureriez-vous les tables et les relations entre elles?


## Fonctions

1. Créer une fonction SQL qui prend en entrée une maison et retourne `True` si elle contient une chambre de type bureau.
1. Créer une fonction SQL qui prend en entrée une maison et un entier et retourne `True` si elle contient une chambre de taille supérieure à cet entier.