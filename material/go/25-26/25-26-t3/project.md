# Project CLI avec Go

Développer une application complète en Go sous forme d'une CLI en mode TUI (Text User Interface) et d'un backend.
L'application doit fournir un ensemble de fonctionnalités utiles dans une interface agréable dans le terminal.
Additionnellement, l'application doit communiquer avec un serveur pour récupérer ou stocker des données, ou effectuer des opérations spécifiques.

Quelques exemples d'application existantes qui pourraient vous inspirer pour ce projet sont des outils de gestion de cloud, des gestionnaires de tâches, des clients de messagerie, ou même des jeux en ligne basés sur le terminal.
Par exemple, Google Cloud CLI, AWS CLI, ou même des outils comme `htop` ou `ncdu` sont des exemples d'applications CLI populaires qui proposent une interface utilisateur riche dans le terminal et interagissent avec un serveur.

## Grille de notation

- CLI en mode TUI (1 point pour chaque critère)
    - Ecran d'accueil avec les options possibles
    - Ecran d'authentification pour se connecter à son compte
    - Ecran de paramètres pour configurer l'application (par exemple, le thème de couleurs)
    - Ecrans qui proposent la fonctionnalité principale de l'application (par exemple, gestion des tâches, visualisation de données, écrans du jeu, etc.)
    - Stockage des paramètres dans le dossier personnel de l'utilisateur au format JSON (par exemple, `~/.config/monapp/config.json`)
    - Stockage de l'état de l'application dans le dossier personnel de l'utilisateur au format JSON (par exemple, `~/.config/monapp/state.json`)
    - Paramètres pour importer et exporter la configuration et l'état de l'application depuis et vers le serveur (Vous pouvez utiliser le type JSONB de postgreSQL pour stocker des données JSON dans la base de données)
    - Interface utilisateur agréable, colorée, dynamique et facile à utiliser
- Serveur d'API REST (1 point pour chaque critère)
    - Endpoints d'authentification
    - Endpoints pour récupérer et mettre à jour les données de l'application
    - Stockage de données (par exemple, tâches, messages, scores, etc.) dans une base de données PostgreSQL
    - Endpoints pour importer et exporter la configuration et l'état de l'application depuis et vers le client CLI
- Nécessite de cross-compiler le serveur pour tourner sous Linux ([guide de cross-compilation](https://dev.to/godofgeeks/cross-compiling-go-applications-4ced)) (1)
- Héberger le serveur gratuitement. Exemples d'hébergement gratuits : [alwaysdata](https://www.alwaysdata.com/fr/offers/), [Render](https://render.com/). (1)
- Cross-compiler la CLI pour Windows, Linux et MacOS (astuce, utiliser GoReleaser ou le guide donné plus haut) (1)
- Publier la CLI sur GitHub dans la partie "Releases" de votre dépôt GitHub (1)
- Répondre aux questions techniques lors de la soutenance (4)

## Contraintes

- Vous pouvez utilise l'IA. En revanche, vous serez évalué sur votre capacité à expliquer et justifier vos choix techniques. Vous aurez donc des questions sur votre code lors de la soutenance.
- Le plagiat est interdit.
- Gérer les erreurs de manière appropriée (par exemple, gestion des fichiers inexistants, erreurs de requêtes HTTP, division par zéro, etc.)
- Travailler en binôme

## Soutenance

Lors de la dernière séance, vous serez invités à :

- Faire une démonstration des fonctionnalités de l'application pendant 10 minutes maximum.
- Répondre aux questions techniques sur le code et les bibliothèques utilisées.

Il ne sera pas demandé de présenter un diaporama.

## Livrables

- Déposer une archive du code source du projet dans votre outil scolaire avant la date butoir.

## Librairies et liens utiles

- TUI : [tview](https://github.com/rivo/tview) ou [bubbletea](https://github.com/charmbracelet/bubbletea) + [lipgloss](https://github.com/charmbracelet/lipgloss)
- API REST : [gin](https://github.com/gin-gonic/gin)
- Cross-compilation : [GoReleaser](https://goreleaser.com/) ou [guide de cross-compilation](https://dev.to/godofgeeks/cross-compiling-go-applications-4ced)
- [Guide d'interaction avec une BDD postgreSQL](https://golangdocs.com/golang-postgresql-example)
