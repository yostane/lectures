# Project CLI avec Go

Développer une application en ligne de commande (CLI) appelée `univ-cli` en Go qui propose les sous-commandes suivantes :

-   `fs`: Permet de naviguer et manipuler le système de fichiers local. Elle propose les sous-commandes suivantes :
    -   `ls [path]`: Liste les fichiers et dossiers dans le répertoire spécifié (ou le répertoire courant si aucun chemin n'est fourni). (on ne traite pas les jokers `*` ou `?` pour simplifier)
    -   `cat <file>`: Affiche le contenu du fichier spécifié.
    -   `cp <file> <destination>`: Copie le fichier spécifié vers la destination fournie.
    -   `mkdir <dir>`: Crée un nouveau répertoire avec le nom spécifié.
-   `tui`: Lance une interface utilisateur textuelle (TUI) simple qui affiche un menu avec les options suivantes :
    -   Afficher la date et l'heure actuelles.
    -   Afficher un message de bienvenue.
    -   Quitter l'application.
    -   Proposer une fonctionnalité de votre choix. Plus la fonctionnalité est originale et intéressante, mieux c'est !
-   `custom`: propose une fonctionnalité (ou ensemble de fonctionnalités) de votre choix. Plus la fonctionnalité est originale et intéressante, mieux c'est !

## Notation

| Critère                                                  | Points |
| -------------------------------------------------------- | ------ |
| `fs ls`                                                  | 1      |
| `fs cat`                                                 | 1      |
| `fs cp`                                                  | 1      |
| `fs mkdir`                                               | 1      |
| `tui` affichage date/heure                               | 1      |
| `tui` message de bienvenue                               | 1      |
| `tui` fonctionnalité originale                           | 1      |
| `custom` fonctionnalité originale                        | 2      |
| 1ère Question sur le code                                | 4      |
| 2ème Question sur le code                                | 4      |
| Qualité du code                                          | 2      |
| Qualité de la présentation de la CLI messages / couleurs | 1      |
| --------                                                 | ------ |

## Contraintes

-   Vous pouvez utilise l'IA. En revanche, vous serez évalué sur votre capacité à expliquer et justifier vos choix techniques. Vous aurez donc des questions sur votre code lors de la soutenance.
-   Le plagiat est interdit
-   Utiliser des bibliothèques Go populaires pour la création de CLI (par exemple, Cobra, fang, bubbletea)
-   Gérer les erreurs de manière appropriée (par exemple, gestion des fichiers inexistants, erreurs de requêtes HTTP, division par zéro, etc.)
-   Proposer une CLI colorée et bien documentée (aide intégrée, messages d'erreur clairs, etc.)

## Soutenance

Lors de la dernière séance, l'évaluateur passera vous évaluer sur les points suivants :

-   Démonstration des fonctionnalités de l'application CLI
-   Réponses aux questions techniques sur le code et les bibliothèques utilisées

## Livrables

-   Déposer une archive du code source du projet dans votre outil scolaire avant la date limite.
