# Tour du langage Java

Nous allons faire un tour du langage Java sans forcément tout couvrir car il est très riche en fonctionnalités.

!!! warning

    Comme le langage Java évolue apporte fréquemment des amélioration et simplifications, il se peut que les exemples de code vues ici soient différents de ce que vous trouvez dans la littérature.

## Premiers pas

```java title="Hello world"
--8<--
tour/helloworld.java
--8<--
```

```java title="Premières instructions"
--8<--
tour/hello.java
--8<--
```

```java title="Opérations de base"
--8<--
tour/operators.java
--8<--
```

```java title="Types primitifs"
--8<--
tour/BaseTypesDemo.java
--8<--
```

```java title="Lire au clavier"
--8<--
tour/ScannerDemo.java
--8<--
```

```java title="Nombres aléatoires"
--8<--
tour/RandomDemo.java
--8<--
```

## Classes, héritage et interfaces

- En java, une classe ne peut hériter que d'une seule classe (héritage simple) et peut implémenter (terme utilisé quand une classe hérite d'une interface) plusieurs interfaces.
    - Pour info, Python et C++ permettent l'héritage multiple.
- Une classe qui implémente une interface doit implémenter toutes les méthodes de cette interface.
- Interface: une  classe où il n'y a que les synopsis des méthodes dans leur implémentation.
    - Synopsis (ou la signature): le nom, les arguments et le type de retour de la méthode
- Les classes modélisent la relation **être**, tandis que les interfaces modélisent des attributs, des traits ou des caractéristiques.
- Visibilité des propriétés et méthodes d'une classe:
    - Privé : `private` : visible uniquement dans la classe
    - Public : `public` : visible dans tout le projet
    - Protégé : `protected` : visible dans la classe, les sous-classes et les classes du même package

```java
--8<--
tour/ClasseInterface.java
--8<--
```

## Les record

- Un `record` est une classe qui ne peut pas être étendue et qui ne peut pas avoir de méthodes abstraites.
- Il est utilisé pour représenter des données immuables.
- Les méthodes `equals`, `hashCode` et `toString` sont automatiquement générées par le compilateur.

```java
--8<--
java/tour/RecordDemo.java
--8<--
```

## Collections

- **Tableaux** : Java propose plusieurs types pour travailler avec des tableaux (ou listes) d'objets. Voici les plus importants:
    - Tableau : `Array` : tableau de taille fixe.
    - List : `List` : tableau de taille dynamique (on peut ajouter ou supprimer des éléments). On utilise généralement `List` en type de variable et `ArrayList` pour instancier un tableau dynamique.
- **Dictionnaire** : Appelé **Map** en Java, il permet de stocker des paires clé-valeur. Il est possible d'utiliser n'importe quel type d'objet comme clé ou valeur. On utilise généralement `Map` en type de variable et `HashMap` pour instancier un dictionnaire.
- Les listes et les dictionnaires n'acceptent pas les types primitifs (ou les types de base) comme `int` et `double`, il faut passer par les types objets (comme `Integer` ou `Double`) pour les utiliser dans ces collections.
- L'itérateur est un moyen alternatif de parcourir les éléments d'une collection sans avoir à gérer les indices.

```java
--8<--
tour/CollectionDemo.java
--8<--
```

## Types génériques

```java
--8<--
tour/GenericsDemo.java
--8<--
```

## Programmation fonctionnelle

- Les fonctions sont des éléments de première classe : Les fonctions sont comme des variables
- Utilisation intensive de fonctions pures : fonction sans effet de bord, toujours le même résultat pour les mêmes entrées
    - exemples de fonctions par pure: `print` (car elle change la console)
- Immutabilité
    - On ne peut pas changer la valeur d'une variable une fois initialisée
    - On ne peut pas changer les propriétés d'un object une fois instancié
    - On ne peut pas ajouter ou supprimer des éléments d'une collection
- On le code est développé sous forme d'une chaîne de traitements (comme dans une usine)

### Relation entre la POO et la programmation fonctionnelle

- La POO est la prog. fonctionnelle ne sont pas mutuellement exclusifs
- On peut développer en POO avec un style fonctionnelle:
    - Les méthodes ne font pas de mutation de champs de l'objet
    - Les propriétés sont uniquement en read-only
    - Les `records` simplifient la création de ce genre de classes

### Interfaces fonctionnelles

```java
--8<--
tour/FunctionalInterfaceDemo.java
--8<--
```

Equivalent en Kotlin:

```kt
--8<--
tour/FirstClassFunctions.kt
--8<--
```

Liste des [interfaces fonctionnelles prédéfinies](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html) qui sont séparées en [4 catégories](https://www.ggorantala.dev/what-are-java-built-in-functional-interfaces/):

- **Consumer** : Fonction qui prend des arguments génériques et ne renvoie rien (type de retour void)
- **Supplier** : Fonction qui ne prend aucun argument et renvoie un valeur dont le type est générique
- **Function** : Fonction qui peut prendre des arguments génériques et retourne une valeur générique.
- **Predicate** : Fonction qui peut prendre des arguments génériques et retour un booléen. Un predicate peut être considéré comme un cas particulier d'une **Function** dont le type de retour est un booléen.

La convention est de rajouter le terme bi pour les fonctions avec deux arguments (comme `BiPredicate`). Voici des exemples de définition de quelques interfaces fonctionnelles:

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

package java.util.function;
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

### Streams

Permettent de manipuler des collections de tailles arbitraires de manière déclarative.

```java
--8<--
tour/StreamDemo.java
--8<--
```

Une [documentation plus complète est proposée le site de baeldung](https://www.baeldung.com/java-8-streams)

## Null safety

_Définition: la null safety est toute fonctionnalité qui permet de ne plus avoir de null pointer exception à l'exécution._

Java propose deux possibilités pour aovir une sorte de null safety qui ne sont moins puissantes que ce que l'on peut trouver dans d'autres langages comme Kotlin, Swift ou TypeScript par exemple.

```java title="Type optionnel"
--8<--
tour/OptionalDemo.java
--8<--
```

```java title="Annotations null"
--8<--
tour/nonnull-annotations/app/src/main/java/org/example/App.java
--8<--
```

## Les exceptions

Les exceptions sont des retours alternatifs d'une méthode qui permettent de signaler une erreur. L'équivalent du `return` pour les exceptions est `throw` en java. Il permet de sortir de la fonction tout en retournant une valeur. Cette valeur doit hériter de la classe `Throwable` et peut être récupérée via un block `try-catch`.
