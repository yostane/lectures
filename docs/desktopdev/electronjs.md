# ElectronJS

## Prise en main

Nous allons utiliser [Electron Forge](https://www.electronforge.io/)

```sh
# Création d'un projet en JavaScript
npx create-electron-app@latest my-app
# ou en TypeScript
npx create-electron-app my-app --template=vite-typescript
# Démarrer l'application
cd my-app
npm start
```

Cet outil permet de publier l'application sur les différentes plateformes (Windows, Mac, Linux).

```sh
# Génération du paquetage distribuable (installeur, dmg, etc.)
npm run make
# Publication sur certaines platrformes (GitHub, S3, etc.)
npm install --save-dev @electron-forge/publisher-github
npm run publish
```

Vous pouvez trouver plus d'infos sur [les makers ici](https://www.electronforge.io/config/makers) et [les
publishers ici](https://www.electronforge.io/config/publishers).

## Intégration d'un front React

Voici les étapes clés:

1. Créer un projet React avec Vite
1. Créer un projet Electron avec Electron Forge
1. Copier le code front de l'application React vers le projet Electron : écraser *index.html*, copier le dossier *public* et fusionner le contenu du dossier *src*.
1. Copier les configuration spécifique du projet React vers le projet Electron. Il ne dervrait y avoir que le *eslint.json* à copier à la racine du projet Electron.
1. Copier les dépendances (`dependencies` et `devDependencies`) du projet React vers le projet electron à part `vite`. Il ne devrait pas y avoir d'autres doublons, mais s'il y en a, il faut les supprimer.
1. Ajouter le plugin react dans *vite.renderer.config.mjs*. Vous pouvez le faire en remplaçant le contenu de ce fichier par le contenu de *vite.config.js* du projet React.

1. Lancer l'application Electron. Si tout fonctionne, vous pouvez supprimer le projet React

Voici les commandes qui permettent de faire ces étapes (fonctionne au moment où j'écris ces lignes):

```sh
npx create-electron-app@latest electron-react-app --template vite
npx create-vite@latest my-react-app --template react

cp my-react-app/index.html electron-react-app/src/index.html
cp -r my-react-app/public electron-react-app/public
cp -r my-react-app/src electron-react-app/src

cp my-react-app/eslint.config.json electron-react-app/eslint.config.json

cd electron-react-app
npm install react react-dom
npm install --save-dev @eslint/js @types/react @types/react-dom eslint vite-plugin-react @vitejs/plugin-react eslint-plugin-react-hooks eslint-plugin-react-refresh

cp ../my-react-app/vite.config.js ./vite.renderer.config.mjs

# Sous un shell sh (bash, zsh, etc.)
rm -rf ../my-react-app
# Sous powershell
rm -Force -Recurse ../my-react-app

npm start
```

![eletron react app](assets/electron-react.png)
