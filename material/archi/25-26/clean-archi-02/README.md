# clean archi exemple 02
## Préparation
- Créer un dossier "core" à la racine du projet
- Déplacer `01-entities` et `02-use-cases` dans le dossier core
- Créer un dossier `adapters` à la racine du projet
- Déplacer `03-adapters` dans ce dossier
- Renommer `03-adapters` en `in-memory-repository`
- renommer 04-interfaces en `cli`
- Créer une dossier `applications` à la racine du projet
- Déplacer `cli` dans `applications`
- Créer une nouvelle application `express-server` dans `applications` avec `bun init --yes applications/express-server`
- Enlever les préfixes numériques des dossiers
- Ajouter un adapteur pour les contrôleurs express `bun init --yes adapters/controllers`
- Mettre à jour les `workspaces` dans le `package.json` à la racine du projet
    ```json
    "workspaces": [
        "core/*",
        "adapters/*",
        "applications/*"
        ]
    ```
- Mettre à jour les `dependencies` dans les `package.json` des différents dossiers
- Ajouter un script `start` dans le `package.json` de `express-server` pour démarrer le serveur
    ```json
    "scripts": {
        "start": "bun run index.ts"
    }
    ```
- Ajouter des scripts raccourcis dans le package.json à la racine du projet pour démarrer les différentes applications
    ```json
    "scripts": {
        "cli:add": "cd applications/cli && bun run add",
        "cli:list": "cd applications/cli && bun run list",
        "server:start": "cd applications/express-server && bun run start"
    },
    ```
- Déplacer le fichier `adapters/in-memory-repository/src/MemberCommandHandler.ts` dans `adapters/controllers/src/MemberController.ts`
- Renommer `MemberCommandHandler` en `MemberController`
- Mettre à jour les imports dans `applications/cli/index.ts` et dans son `package.json` pour utiliser le nouveau chemin du contrôleur
- Appeler le contrôleur dans les routes de l'application express