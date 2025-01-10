# Développement de jeux 2D avec monogame

## Modèle de développement avec Monogame

- Le développement de jeux avec Monogame repose sur l'exécution d'une boucle infinie qui exécute 60 itération par seconde (pour avoir un jeu en 60 fps)
    - Ce modèle peut être retrouvé dans d'autres frameworks de jeux
- Chaque itération effectue les actions suivantes:
    1. Lire les touches du clavier
    1. Mettre à jour la logique du jeu
    1. Afficher le rendu de l'image actuelle
- Le framework Monogame permet au développeur de personnaliser le comportement des étapes 2 et 3.
    - Cela veut dire que l'on peut coder ce qui se passe sur chaque image (ou frame) et afficher ce qu'on veut à chaque image (frame)
- Voici une représentation en pseudo-code

```cs
var game = new Game();
game.Initialize(); // *
game.LoadContent(); // *
while (true){
    game.readInput();
    game.Update(); // *
    game.Draw(); // *
}
// *: peuvent être personnalisés (ou surchargés) avec l'héritage
```

## Lexique monogame

- Sprite: tout élément dans l'écran (personnage, ennemis, décors, etc.).
- `Texture2D`: c'est le rendu associé à un sprite.
    - Par exemple: si on prend le sprite de Mario, alors sa Texture2D contiendra le dessin du personnage à moustache.
    - Par exemple: si on prend le premier niveau du jeu Super Mario Bros, alors sa Texture2D contiendra le dessin du terrain, des obstacles, du ciel, des herbes et des nuages.
- On peut considérer un sprite comme un rectangle avec un rendu chargé depuis une Texture2D.
- `SpriteBatch`: une classe qui gère et dessine à l'écran un ensemble de sprites
    - Par exemple: le `SpriteBatch` du premier niveau de Super Mario Bros contiendrait les sprites de: Mario, les ennemies (Goombas et Paratroopers), terrain principal, sous-terrain, le drapeau, les blocs, les bonus et le HUD (Heads Up Display) (Score, vies, temps).
- Fichier `mgcb`: Fichier contenant les ressources d'un jeu Monogame (textures, sons, etc.)

## Premiers pas avec Monogame

- Ajout du modèle de projet: `dotnet new install MonoGame.Templates.CSharp`
- Vérifier qie le modèle a été ajouté avec un `dotnet new list`
- Créer le projet: `dotnet new mgdesktopgl -o first-game`
- `cd first-game`
- Vérifier dans csproj que TargetFramework est la dernière version du framework .net
- Lancer: `dotnet restore`
- Puis: `dotnet run`

## Exercice: deux carrés et intersection

- Créer un jeu monogame qui affiche deux carrés
- Le premier est situé au centre et est statique
- Le deuxième est placé aléatoirement dans l’écran et est contrôlé par le joueur
- Associer une [texture sous forme d'une couleur](https://docs.monogame.net/articles/getting_started/4_adding_content.html) à chacun des carrés
- Lorsque les deux carrés se touchent l’arrière-plan devient rouge, sinon il est bleu
- Le score du joueur augmente à chaque frame de 1 point si les carrés ne se touche pas, et il baisse de 5 points par frame s’il se touchent
- Afficher le score en temps réel
- Faire déplacer le premier carré aléatoirement de façon fluide (il ne faut pas qu’il se téléporte)

## Fichier mgcb

- Un fichier mgcb permet de contenir, de façon optimale, les ressources d’un jeu XNA / MonoGame
- Afin de manipuler ce fichier, il faut installer deux outils
    - Un éditeur pour ajouter des ressources: `mgcb`
    - Un compilateur pour qu’il puisse être optimisé pour l’exécution: `mgcb-editor-(platforme)`
- Pour installer correctement le compilateur, il faut d’abord avoir un fichier **.config/dotnet-tools.json** dans son projet avec la commande `dotnet new tool-manifest`
- Installer le compilateur: `dotnet tool install dotnet-mgcb` (il sera lancé automatiquement lorsqu'on fera `dotnet run`)
- Installer l’éditeur pour windows: `dotnet tool install dotnet-mgcb-editor`
- Puis le lancer en lançant la commande `dotnet mgcb-editor`
- Un fois l’éditeur ouvert, créer un nouveau mgcb dans `[racine du projet]/Content/Content.mgcb`
- Vous pouvez suivre ce [guide](https://docs.monogame.net/articles/getting_started/4_adding_content.html) pour voir comment ajouter et charger des ressources

## Animations

- [monogameextended](https://www.monogameextended.net/docs/features/animations/animations/) propose de simplifier l'animation des sprites.
