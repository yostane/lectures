# Le framework .Net

Le framework .Net et le framework officiel qui accompagne le langage C#.

## Qu'est-ce qu'un framework ?

On peut voir un framework comme une librairie dont l'usage est structurant dans un projet. Ils proposent généralement:

- Des outils (par exemple un CLI)
- Des librairies et API
- Un documentation
- Des langages de programmation qu’il supporte

Il faut aussi s’intéresser à son:

- Prix
- Communauté et le support en cas de problème
- Documentation

## Historique

- Avant les années 2000, les seuls gros frameworks de MicroSoft sont les API Win32 et COM (qu'on peut coder en C++ et VB).
    - La sortie du JDK de Sun Microsystems a grandement amélioré l'expérience développeur. Microsoft a d'ailleurs développé une déclinaison personnalisée (MSVM) qui a été abandonnée suite au procès contre SUN.
- 2000: MicroSoft lance .Net et “.Net Framework“ 1.0 (C#, VB) mais qui ne sont compatibles qu'avec Windows.
    - Le code source du framework est en C++.
- 2004: Sortie de Mono qui est un portage .Net pour Linux OSS (Open Source) indépendant de MicroSoft.
- 2013: Microsoft déclare durant la conférence Build (Apple: WWDC, Google: Google IO) son souhait de faire de l'Open Source avec la fameuse citation: Microsoft♥️Linux.
- Depuis 2014: Création de Fondation .Net et sortie de projets .Net en OSS
- .Net Core (octobre 2014), EFCore, MSBuild, VSCode, .NetStandard, etc.
- Fin 2020, sortie de .Net 5 et abandon du terme **.Net Core** en faveur de **.Net** tout court

!!! warning ".Net et .Net Framework sont deux frameworks différents"

    Bien qu'ayant des classes et fonctions communtes, **.Net Framework** et **.Net** sont deux frameworks différents. Le premier est déprécié et n'est compatible qu'avec Windows. Le deuximèe est d'actualité et est multiplatforme.

## Quelques APIs

- Types primitifs: System.Boolean and System.Int32, etc.
- Collections: System.Collections.Generic.List<T>, System.Collections.Generic.Dictionary<TKey,TValue>, etc.
    - Les collection désignent les structures de données ou les types qui stockent un ensemble de données. Exemples: tableau, listes, dictionnaire (Map), ensembles (Set), chaîne de caractères
- Types utilitaires: System.Net.Http.HttpClient, System.IO.FileStream, etc.
- Data types, such as System.Data.DataSet, and System.Data.Entity.DbSet.
- High-performance types, such as System.Span<T>, System.Numerics.Vector, and Pipelines

## Langages du .Net

- .Net supporte officiellement C# et F#
- F# : langage fonctionnel pure développé par Microsoft
- C# : langage de programmation développé par Microsoft (inspiré de Java et C++ à la base et s’inspire encore d’autres langages)
- Le langage C# est le plus utilisé en .net

## Collections

.Net fournit les types de collections courantes et des méthodes pour les manipuler.
Il propose même des fonctionnalités intéressantes comme l'indexation à l'envers et par intervalle.

```cs
--8<--
dotnet/collections/Program.cs
--8<--
```

## LINQ

LINQ fournit des fonctions et des mots-clés permettant de manipuler des collections de données.
LINQ est un acronyme pour **Language Integrated Query**.
Deux syntaxes sont possible: la syntaxe de requête (ressemble à du SQL) et la syntaxe de méthode (ressemble aux méthodes fitler map et reduce qu'on trouve dans d'autres langages).

```cs
--8<--
dotnet/linq-demo/Program.cs
--8<--
```

## Fichiers

- C# propose plusieurs façons de manipuler des fichiers
- Les classes `StreamReader` et `StreamWriter` permettent de manipuler les fichiers sous forme de flux de données synchrones.
- Il existe aussi des méthodes utilitaires pour lire et écrire le contenu du fichier en une fois sans passer pas des streams. La [Doc de C# montre comment effectuer les tâches communes](https://learn.microsoft.com/en-us/dotnet/standard/io/common-i-o-tasks)

!!! hint "Les streams"

    - Un `Stream` (ou flux en Français) permet de manipuler des données au fur et à mesure (sans avoir à les charger intégralement en mémoire)
    - L'avantage des streams et qu'ils permettent consommer généralement moins de mémoire et qu'il permettent de commencer à traiter plus rapidement la données car on n'est pas obligé d'attendre 
    - Les streams sont donc pariculièrement utile quand on veut traveiller avec des fichiers ou si on fait du réseau car les temps d'accès sont moins rapides qu'un
    - Par contre, la données est déjà intégralement chargée en mémoire, les streams ne sont pas pertinents.

```cs
--8<--
file_demo/Program.cs
--8<--
```

## Programmation asynchrone

- Pour chaque programme que vous lancez, un processus est créé
    - Un processus est lancé avec un seul thread au démarrage et peut en gérer plusieurs par la suite
- Les processus et les threads s’exécutent de façon asynchrone (on dit aussi, de façon concurrente)
    - En général, on crée des Thread avec un `new Thread()` ou une syntaxe similaire selon le langage
    - Dans un processeur avec un seul noyau (single core), les threads s'exécutent sur le même noyau
    - Dans un processeur avec plusieurs noyaux (single core), les threads peuvent s'exécutent sur des noyaux différents. On parle alors de programmation parallèle
- Cependant, les processus et les threads sont des fonctionnalités gérés au niveau de votre OS et non au niveau du langage et son runtime
    - Cela rend leur manipulation et optimisation un peu compliquée
- C'est pour cela que certains langages proposent leur propre approche de programmation asynchrone
    - Cela permet de proposer un modèle de programmation plus simple et des optimisation plus faciles
- En C#, le modèle de programmation asynchrone repose sur les **tâches asynchrones** (ou `async Tasks`)
