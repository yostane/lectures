# Projets

## Projet 1: plateforme IoT pour la maison

Réaliser une plateforme IoT pour la maison qui devra gérer ces appareils :

- Un ESP32 qui contient :
  - Un capteur de DHT11 pour la température et l'humidité
  - Un capteur de mouvement
  - Un afficheur OLED qui permet de visualiser en temps réel l'état du capteur de mouvement et les données du DHT11
  - Deux boutons qui permettent de basculer l'envoi des informations en MQTT
- Un ESP32 qui contient :
  - Un buzzer
  - Une LED RGB

Il est aussi demandé de développer une application web moderne et responsive qui permet de visualiser les données des capteurs en temps réel et d'envoyer des commandes aux actionneurs.
Par exemple, activer ou désactiver le buzzer, allumer ou éteindre la LED RGB.

Autres fonctionnalités demandées:

- Si le capteur de mouvement détecte une présence, le buzzer doit émettre un son et la LED RGB doit clignoter en différentes couleurs. Il ne peut être

Les deux ESP32 ainsi que la webapp communiquent en MQTT avec un broker MQTT hébergé sur un serveur distant.
