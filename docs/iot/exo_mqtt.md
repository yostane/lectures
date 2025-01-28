# Exercices MQTT

## Série 1

Créer un broker MQTT. Ensuite, créer une application web `Vanilla` avec vite et y ajouter les fonctionnalités suivantes :

1. Proposer deux champs `input` et un bouton. Quand on clique sur le bouton, envoyer un message MQTT sur le topic saisi dans le premier `input` avec le contenu du 2ème deux champ `input`.
1. Afficher les messages reçus sur le topic test dans une liste.
1. Ajouter un `input` et un bouton `"Souscrire"`. Quand on clique sur le bouton, souscrire au topic saisi dans l'`input`. Une fois souscrit, afficher les messages reçus sur ce topic dans une liste.
1. Afficher la liste de tous les topics souscrits. Ajouter un bouton `"Se désabonner"` à côté de chaque topic pour se désabonner.
1. Ajouter un bouton `"Se désabonner de tous les topics"` pour se désabonner de tous les topics.
1. Appliquer du CSS pour enjoliver l'affichage des messages reçus.
