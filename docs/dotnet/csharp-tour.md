# Tour du langage C-Sharp

Nous allons faire un tour du langage C# sans forcément tout couvrir car le langage est très riche.

!!! warning

    Comme le langage C# évolue chaque année et apporte des amélioration et simplifications régulièrement, il se peut que les exemples de code vues ici soient différents de ce que vous trouvez dans la littérature.

## Premiers concepts

-   Création d'un projet appelé _hello-cs_ avec le CLI: `dotnet new console -n "hello_cs"`
-   Configuration du projet avec le fichier csproj
-   Développement: Lancement de l'application avec `dotnet run` ou depuis VSCode avec F5 ou Ctrl + F5
-   Concepts à couvrir: Types de base, fonctions, conditions, boucles, tableaux, etc.

## Quelques caractéristiques

-   C# est statiquement typé: une variable ne peut pas changer de type (contraire de dynamiquement typé)
-   C# supporte la programmation orienté objet et fonctionnelle
-   Différences avec les conventions de codage java:
    -   Les noms des méthodes, propriétés publiques et constantes publiques commencent avec une majuscule: `Console.WriteLine("Hello World!");`
    -   Un attribut privé est préfixé avec un `_`
    -   Les méthodes asynchrones sont suffixées avec le terme `async`
    -   Les interfaces commencent avec la lettre I (`IEnumerable`)
-   Autres conventions communes:
    -   Une méthode ou fonction commence par un verbe “WriteLine” et non “LineWrite”
    -   Le nom d’une classe commence par une majuscule
-   C# supporte la null safety: permet d'avertir ou d'interdire la manipulation de valeurs nulles sans précaution préalable de la part du codeur.

```cs
--8<--
tour.cs
--8<--
```

## Programmation orienté objet

-   Le programme est vu comme un ensemble d'objets qui interagissent entre eux.
-   Chaque object est défini par une classe qui elle même hériter d'autres classes ou interfaces.
-   Une classes peut définir des propriétés et des méthodes, qu'on appelle des **membres**.
    -   Propriété : une vue sur une donnée via ses **accesseurs** en lecture et / ou écriture (qu'on appelle getters et setter respectivement).
    -   Méthode : fonction qui est définie au sein de la classe
-   Une classe enfant peut hériter d'une seule classe parente en C#:
    -   Dans ce cas, la classe enfant contiendra implicitement tous les membres de la classe mère
    -   La classe enfant peut définir des membres supplémentaires qui lui seront propres
    -   La classe enfant peut redéfinir des membres de classe parent. On appelle cela une surcharge ou **override** en Anglais.
-   Notion de Propriété, méthode ou classe statique:
    -   Propriété d'instance : chaque instance a ses propres proriétés d'instances
    -   Propriété statique : elle sera partagée entre toutes les instances (comme une variable globale pour la classe)
    -   Méthode d'instance : sera exécutée dans le contexte de l'instance qui l'a appelée (accessible via `this`)
    -   Méthode statique : méthode qui a comme contexte que les propriété et méthodes statiques de sa classe
    -   Classe statique : une classe qui ne peut pas être instanciée et ne contiendra donc que des propriété et méthodes statiques
-   Méthode, propriété et classe abstraite:
    -   Méthode abstraite: méthode qui n'a pas d'implémentation
    -   Propriété abstraite: propriété dont les accesseurs ne sont pas définis
    -   Classe abstraite: une classe qui a au moins une propriété ou méthode abstraite
    -   Les membres abstraits sont destinés à être définis par une sous classe non abstraite.

```cs
// ComputerPiece.cs
--8<--
oop/ComputerPiece.cs
--8<--
// ILightable.cs
--8<--
oop/ILightable.cs
--8<--

// IOverclockable.cs
--8<--
oop/IOverclockable.cs
--8<--

// OopProgram.cs
--8<--
oop/OopProgram.cs
--8<--
```

### Constructeur vs bloc d'initialisation

-   Le constructeur est une méthode spéciale qui est appelée lors de l'instanciation d'une classe
-   Le bloc d'initialisation est un bloc de code qui est exécuté avant le constructeur
-   Il y a deux styles d'initialisation des propriétés d'une classe: l'initialisation via le constructeur et l'initialisation via le bloc d'initialisation
-   Chaque style a des avantages et inconvénients en terme de lisibilité et verbosité
-   Même si on peut mixer les deux styles d'initialisation, il est recommandé de choisir un style et de s'y tenir pour la cohérence du code

```cs title="Deux styles d'initialisation"
--8<--
class-styles/Program.cs
--8<--
```

### record

Les record sont des classes avec des fonctionnalités supplémentaires qui permettent de simplifier la création de classes simples.

-   Les records sont des classes immuables
-   Les records sont des classes finales (non héritables)
-   Les records ont des propriétés en lecture seule
-   Les records ont des méthodes `Equals`, `GetHashCode`, `ToString` et `With` générées automatiquement

```cs
--8<--
record/Program.cs
--8<--
```

## Programmation fonctionnelle

-   Les fonctions sont des éléments de première classe : Les fonctions sont comme des variables
-   Utilisation intensive de fonctions pures: fonction sans effet de bord, toujours le même résultat pour les mêmes entrées
    -   exemples de fonctions par pure: `WriteLine` (car elle change la console)
-   Immutabilité
    -   On ne peut pas changer la valeur d'une variable une fois initialisée
    -   On ne peut pas changer les propriétés d'un objet une fois instancié
    -   On ne peut pas ajouter ou supprimer des éléments d'une collection
-   On le code est développé sous forme d'une chaîne de traitements (comme dans une usine)

## Relation entre la POO et la programmation fonctionnelle

-   La POO est la prog. fonctionnelle ne sont pas mutuellement exclusifs
-   On peut développer en POO avec un style fonctionnelle:
    -   Les méthodes ne font pas de mutation de chmaps de l'objet
    -   Les propriétés sont uniquement en read-only
    -   Les `records` simplifient la création de ce genre de classes

## Autres fonctionnalités pratiques

-   Méthodes d'extension: permettent de rajouter une méthode à une classe sans passer par l'héritage
-   Null-safety
    -   Cette options est activée avec la propriété `<Nullable>enable</Nnullable>` au niveau du projet.
    -   Pour signaler des erreurs au lieu d'avertissements, utiliser la propriété `<WarningsAsErrors>Nullable</WarningsAsErrors>` au niveau du projet.

## Debug vs release

-   Mode debug => à utiliser pour le dev via `dotnet run`
    -   On peut débugger (point d'arrêt, inspecter des variables et la stack frame ou stack trace)
    -   Programme plus lourd en espace et Moins rapide
    -   `dotnet run` permet de générer et binaire debug et de l’exécuter juste après
-   Mode release: => à utiliser pour la mise en prod
    -   On peut pas débugger
    -   Programme moins spatieux et plus rapide
    -   `dotnet publish -c Release …`

## Mise en production d'un projet `C#`

-   Pour générer [le binaire selon l’OS](https://docs.microsoft.com/fr-fr/dotnet/core/tools/dotnet-publish): `dotnet publish -c Release -r <RID> --self-contained (false ou true)`
    -   `-c Release`: optimiser et ne pas inclure les infos de débogage
    -   `-r <RID>`: rid est à remplacer par [l’id du système cible](https://docs.microsoft.com/fr-fr/dotnet/core/rid-catalog). Exemples: `win-x64`, `linux-x64`, `osx-x64`, etc.
    -   `--self-contained`: permet d’embarquer ou non le runtime dotnet dans le livrable. Pour une livraison autonome préférer le `--self-contained` à `true` au lieu de `false`
-   Votre livrable se trouvera dans le dossier: `bin\Release\netx.x\<rid>\publish`
-   Tous les fichiers sont à installer dans les postes client à part le fichier `...deps.json` et le fichier `... .pdb`
-   Ensuite, il faudra soit fournir les binaires dans une archive, soit fournir un installeur
-   Visual Studio permet de générer des installeurs plus facilement
