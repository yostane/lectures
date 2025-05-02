# Projets types

## API REST avec thème au choix

Développer une API REST qui respecte les exigences ci-dessous. Il faudra utiliser Go et le framework Gin et persister les données dans une BDD SQLite. Le thème de votre projet est libre, mais il doit être pertinent, intéressant et validé par l'intervenant.

### Exigences

- Endpoints CRUD (Create, Read, Update, Delete) pour gérer les ressources de l'application.
    - Lister tout (0.5 pt)
    - Afficher une élément par ID (0.5 pt)
    - Lister via une recherche sur tous les champs (1 pt) (par exemple `/search?query=foo` va afficher touts les résultats qui contiennent la sous-chaîne `foo` dans n'importe quel champ).
    - Créer (0.5 pt)
    - Mettre à jour un élément par ID (0.5 pt)
    - Supprimer un élément par ID (0.5 pt)
    - Supprimer plusieurs éléments par une liste d'ID (0.5 pt)
    - Mettre à jour plusieurs éléments par une liste d'ID (0.5 pt)
    - Réinitialiser la BDD (0.5 pt) (suppression de toutes les données)
- Documentation OpenAPI et Swagger UI. (1 pts) et bien documentée (1 pts) ([astuce](https://github.com/swaggo/gin-swagger)).
- Authentification :
    - Table users (0.5 pt) (nom, email, mot de passe, isAdmin). Le mot de passe ne doit pas être stocké en clair.
    - Table déjà initialisée avec un admin (0.5 pt) (Qui doit rester même après une réinitialisation de la BDD).
    - Verbe d'inscription (0.5 pt) (POST /user/register) : Qui crée un utilisateur et renvoie un JSON contenant un JWT.
    - Verbe de connexion (0.5 pt) (POST /user/login) : Qui vérifie les identifiants (email et mot de passe) et renvoie un JSON contenant un JWT.
    - Tous les verbes de l'API doivent être protégés par un middleware d'authentification (0.5 pt) ([astuce](https://github.com/appleboy/gin-jwt)). Le JWT doit être passé dans un header au format `Authorization : Bearer <token>`.
    - Verbe pour qu'un utilisateur puisse mettre à jour ses propres informations (0.5 pt).
    - Protéger le verbe de reset de la BDD uniquement pour les admins (0.5 pt).
    - Verbe pour qu'un admin puisse mettre à jour les informations de n'importe quel utilisateur qui n'est pas admin (0.5 pt).
- Un fichier (ou des fichiers) `requests.http` ou un projet **bruno** contenant des exemples de requêtes HTTP pour tester l'API. (2 pts)
- Gestion des erreurs complète et validation des données (code autre que 200 pour toute erreur). (3 pts)
- Logging des évènements (appels, informations aidant à l'analyse) dans deux fichiers différents; un pour les erreurs et un pour les logs normaux. (1 pt)
- Déploiement sur un hébergeur gratuit (comme [alwaysdata](https://www.alwaysdata.com) ou [render](https://render.com/)). (3 pts)

### Consignes de rendu

- Code à jour et fonctionnel sur la branche `main` du dépôt Git.
- Je dois être en mesure de lancer le serveur depuis un GitHub Codespace avec un `go run .`
- Ajouter un fichier `README.md` à la racine du dépôt contenant :
    - L'URL du serveur s'il est déployé.
    - Votre auto-évaluation détaillée (pour chaque exigence donnée plus haut, votre auto-évaluation) et la note totale.
