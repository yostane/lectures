# Java 3AL 24-25

## TP noté

Réaliser une application de type CRUD avec une interface graphique en JavaFX. Le thème du projet est libre et à valider avec l'enseignant. Exemple: application ToDo.

CRUD signifie Create, Read, Update, Delete. Votre application doit permettre de créer, afficher, mettre à jour et supprimer des éléments.

Vous pouvez utiliser la genAI pour des questions précises mais pas:

- Pour le projet complet
- Pour les suggestions de code
- Pour de la génération de code

### Fonctionnalités

- Afficher les éléments avec un TableView. (1)
- Afficher un formulaire dans une nouvelle fenêtre / dialogue qui permet d'ajouter de nouveaux éléments. (1)
- Bouton d'édition qui permet de modifier un élément (Possible avec le mode édition de la TableView). (1)
- Possibilité de supprimer un ou des éléments. (1)
- Manipuler ces types de données dans votre modèle : `String, Integer, Date, boolean, enum, List<String>`. Donc votre classe doit contenir au moins 6 propriétés. (3). Par exemple pour un ToDo, vous avez un titre (String), une description (String), une date de création (Date), une date d'échéance (Date), une priorité (enum) et un si terminé (boolean), un numéro unique (Integer), une liste de mots-clés (ou des tags par exemple: `["perso", "important", "anniversaire"]`).
- Enregistrer et charger les données dans un fichier au format JSON ou CSV au choix (vous pouvez utiliser la sérialisation JSON ou une librairies au choix). (2)
- Associer une image à chaque élément (unique ou parmi une liste prédéfinie) (0.5). Afficher l'image dans la TableView (1).
- Ajouter une barre de recherche qui permet de filtrer les éléments. (1)
- Mettre à disposition un bouton qui créé un fichier lisible par des humains (texte brute, HTML (+0.5), md (+0.5), etc.) avec les informations suivantes:
  - Afficher le nombre d'éléments (0.5).
  - Afficher la plus longue chaine de caractères (0.5).
  - Afficher la date la plus récente avec son numéro unique (1).
  - Afficher les éléments dont la date dépasse la date d'aujourd'hui (0.5).
  - Afficher les éléments dont le booléen est (ou est faux selon votre thème) (0.5).
  - Afficher les éléments qu'on retrouve le plus souvent avec le nombre d'occurrences dans le champ de type liste (1).
  - Afficher toutes les éléments de tous les champs lites distincts (par exemple touts les mots clés) (0.5).
  - Par exemple: `Il y a 10 éléments, la plus longue chaine de caractères est '....' et a une longueur de 20 caractères, la date la plus récente est le 12/12/2022 correspond à la donnée dont l'id est ..., les éléments dont la date dépasse la date d'aujourd'hui sont: [element1, element2], les éléments dont le booléen est vrai sont: [element3, element4], les éléments qu'on retrouve le plus souvent dans le champ de type liste sont: ["perso", "anniversaire"] avec x occurences, tous les éléments de tous les champs lites distincts sont: ["perso", "anniversaire", "important", "hobby"]`. (3)
- Utiliser les streams pour manipuler les données (toute boucle qui aurait pu être remplacée par un stream sera pénalisée).

### Liens

[jenkov.com tutorials](https://jenkov.com/tutorials/javafx/index.html)
