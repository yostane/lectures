# Exercices MQTT

## Série 1

Créer un broker MQTT. Ensuite, créer une application web `Vanilla` avec vite et y ajouter les fonctionnalités suivantes :

1. Proposer deux champs `input` et un bouton. Quand on clique sur le bouton, envoyer un message MQTT sur le topic saisi dans le premier `input` avec le contenu du 2ème deux champ `input`.
1. Afficher les messages reçus sur le topic test dans une liste.
1. Ajouter un `input` et un bouton `"Souscrire"`. Quand on clique sur le bouton, souscrire au topic saisi dans l'`input`. Une fois souscrit, afficher les messages reçus sur ce topic dans une liste.
1. Afficher la liste de tous les topics souscrits. Ajouter un bouton `"Se désabonner"` à côté de chaque topic pour se désabonner.
1. Ajouter un bouton `"Se désabonner de tous les topics"` pour se désabonner de tous les topics.
1. Appliquer du CSS pour enjoliver l'affichage des messages reçus.

## Série 2

Créer un broker MQTT. Ensuite, créer une application web `Vanilla` avec vite et y ajouter les fonctionnalités suivantes :

1. Afficher un histogramme ([bar chart](https://www.chartjs.org/docs/latest/charts/bar.html)) en temps réel des messages reçus sur le topic `temperature`. L'histogramme doit compter le nombre de température dans les intervalles suivantes `[0,9], [10, 19], [20,29], [30,39], [40,49]`. Les autres températures sont ignorées.
1. Afficher un histogramme ([bar chart](https://www.chartjs.org/docs/latest/charts/bar.html)) en temps réel de la dernière température reçu dans les topic `maison/salon/temperature`, `garage/temperature`, `piscine/temperature`. Chaque colonne de l'histogramme affiche la dernière température reçue pour chaque topic.
