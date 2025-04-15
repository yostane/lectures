# Exercices sur les streams

!!! warning "Consignes"

    - Ne pas de faire aider par des IA ou genAI

## Exercice 1

-   On souhaite modéliser une collection de consoles et jeux rétro. Les consoles (classe `VideoGameConsole`) et les jeux rétro (classe `VideoGame`) sont des appareils de divertissement ayant les propriétés: `name`, `releaseYear` en commun. Les consoles ont en plus la propriété: `companyName` (la société qui l'a créé). Les jeux vidéos ont comme propriété supplémentaire l'éditeur du jeu (celui qui le distribue) ainsi que son développeur. On aimerait aussi savoir s'il est indépendant ou pas.
-   Définir les classes nécessaires.
-   Chaque jeu vidéo tient une liste des consoles compatibles (pour les jeux cross-platform) via la propriété: `platforms`.
-   `VideoGameConsole` contient en plus la propriété: `companyName` de type string.
-   Compléter la définition des classes et instancier les jeux et consoles suivantes:
    -   Console: `name: My first 16 bit Console`, `releaseYear: 1987`, `companyName: SEGA`
    -   Console: `name: Another 16 bit console`, `releaseYear: 1991`, `companyName: Nintendo`
    -   Console: `name: Awesome 3D console`, `releaseYear: 1996`, `companyName: Sony`
    -   Console: `name: 3D console with weird joystick`, `releaseYear: 1997`, `companyName: Nintendo`
    -   Jeu: `name: Alex Kidd`, `releaseYear: 1988`, `publisher: SEGA`
    -   Jeu: `name: Sonic`, `releaseYear: 1990`, `publisher: SEGA`
    -   Jeu: `name: Mario RPG`, `releaseYear: 1996`, `publisher: Nintendo`
    -   Jeu: `name: Final Fantasy 6`, `releaseYear: 1994`, `publisher: Square`
-   En utilisant les streams:
    -   Afficher les jeux sortis à partir de l'année 1990 triés par ordre croissant de l'année.
    -   Afficher le nom des consoles de la compagnie SEGA.
    -   Afficher le nom des consoles dont le nom contient le mot 16 bits.
    -   Le nom du premier jeu sorti
    -   Trouver le nombre de jeux de chaque éditeur en calculant dictionnaire dont la clé est l'éditeur ou son nom et en valeur le nombre de jeux
    -   Pour chaque éditeur, l'année de sortie du premier jeu en calculant dictionnaire dont la clé est l'éditeur ou son nom et en valeur une année

??? "Corrigé"

    ```java
    --8<--
    exo/RetroCollectionExercise.java
    --8<--
    ```

    ```java
    --8<--
    exo/VideoGameCollectionWithRecords.java
    --8<--
    ```


## Exercice 2

Les méthodes `Stream.iterate` et `Stream.generate` combinées avec `limite` permettent de créer des streams. Voici quelques exemples d'utilisation de ces méthodes: 

```java
// This will create a stream of 10 elements starting from -4 and incrementing by 2
Stream<Integer> streamIterated = Stream.iterate(-4, n -> n + 2).limit(10);
streamIterated.forEach(System.out::println);

// This will create a stream of 10 randome integers between 0 and 100
Stream<Integer> streamGenerated2 = Stream.generate(() -> RandomGenerator.getDefault().nextInt(0, 100)).limit(10);
streamGenerated2.forEach(System.out::println);
```

Répondez aux questions suivantes en utilisant les streams (pas de boucle `for`):

1. Créer un Stream de 10 entiers aléatoires compris entre -10 et 10. Afficher la somme, le min, le max et les éléments supérieurs à la moyenne.
1. Créer un `Stream<Character>` qui génère 10 voyelles aléatoires. Compter le nombre de fois qu'apparaît la lettre `a`.

## Exercice 3

La classe `IntStream` est une classe spécialisée sur les streams d'entiers. Elle est également le résultat d'une conversion d'une string en stream (chaque caractère est représenté par son code en entier).
Voici quelques exemples d'utilisation de cette classe:

```java
// This will create a stream of 10 elements starting from -4 and incrementing by 2
IntStream streamIterated = IntStream.iterate(-4, n -> n + 2).limit(10);
streamIterated.forEach(System.out::println);

// This will create a stream of 10 randome integers between 0 and 100
IntStream streamGenerated2 = IntStream.generate(() -> RandomGenerator.getDefault().nextInt(0, 100)).limit(10);
streamGenerated2.forEach(System.out::println);

//Convert a string to a stream of characters (each character is an integer)
IntStream streamOfChars = "hello".chars();
streamOfChars.forEach(System.out::println);

//count the number of l in a string
long count = "hello".chars().filter(ch -> ch == 'l').count();
System.out.println(count);
```

Répondez aux questions suivantes en utilisant les streams (pas de boucle `for`):

1. Calculer le nombre de voyelles dans une chaîne de caractères.
1. Générer un `IntStream` de 10 voyelles aléatoires. Compter le nombre de fois qu'apparaît la lettre `a`.
1. Calculer le nombre d'occurences de chaque lettre dans une chaîne de caractères.