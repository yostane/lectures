# Exercices listes et dictionnaires

!!! warning "Consignes"

    - Ne pas se faire aider par des IA ou genAI

## Série 1

1. Créer une fonction qui génère une liste d'entiers aléatoires, entre -2 et 2 inclus. La génération s'arrête lorsque le même nombre est généré 3 fois d'affilée. Créer une autre fonction qui prend une liste d'entiers en argument et qui génère un dictionnaire dont les clés sont les entiers distincts de ce tableau et les valeurs sont le nombre de répétition dans la liste. Afficher le résultat de cette fonction sur une liste générée avec la première fonction.
    - Exemple : `{1, 1, -1, 2, 0, 0, 1, 1, 1}` => `{1: 5, -1: 1, 2: 1, 0: 2}`
1. Implémenter la fonction `Map<String, Integer> countWords(String text)` qui prend un long texte et renvoie un dictionnaire dont les clés sont les mots distincts et les valeurs sont le nombre d'occurrences de chaque mot dans la liste. Astuce, utiliser `String.split(" ")` pour séparer les mots. Par exemple, pour le texte suivant : `Il y a un chat et un chien. Le chat est noir et le chien est blanc.` le résultat sera : `{Il: 1, y: 1, a: 1, un: 2, chat: 2, et: 2, chien.: 1, Le: 1, est: 2, noir: 1, blanc.: 1}`.
    - Afficher le résultat de cette fonction sur le texte suivant : `Le feu ça brûle et ça fait mal et l'eau ça mouille mais ça moins mal que le feu`.
1. Les dictionnaires sont souvent utilisés pour la mise en cache et la mémorisation de résultats précédents (ou la mémoisation).
    - Créer une fonction `int countA(List<String> words)` qui compte le nombre total de **a ou A** dans la liste de mots.
        - Afficher le résultat de cette fonction avec cette liste de mots : `List.of("I", "love", "Java", "and", "the", "JVM", "which", "is", "the", "Java", "Virtual", "Machine")`. Le résultat doit être `4`.
        - Dans cette liste, le calcul doit être fait une seule fois pour `Java` et le résultat est réutilisé pour l'occurrence suivante. Pareil pour `the`.
    - Créer une fonction `int compteFibonacci(int n)` qui calcule le fibonacci et qui utilise la mémoisation afin d'optimiser le calcul.
        - En d'autres termes, si `compteFibonacci(10)` => `55` et `compteFibonacci(9)` => `34` sont déjà exécutés. Alors `compteFibonacci(11)` calcule depuis le dictionnaire et renvoie `89` sans recalculer `compteFibonacci(10)` et `compteFibonacci(9)`.
        - Aussi, si `compteFibonacci(10)` est déjà exécuté, alors `cache` contient tous les fibonacci de `0` à `10`.

??? "Solutions"

    ```java title="stats" linenums="1"
    --8<--
    java/common/exo/ex-lists-maps/randnumcount.java
    --8<--
    ```

## Série 2

1.
