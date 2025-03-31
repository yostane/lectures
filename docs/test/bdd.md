# Behavior Drivent Development

Méthode BDD: [Comment utiliser la méthode BDD ?](https://www.all4test.fr/blog-du-testeur/projets-agiles-methode-bdd/)

- Feature: Définit le comportement attendu
- Scenario: Définit un cas d'utilisation
- Given: Définit les préconditions
- When: Définit l'action
- Then: Définit le résultat attendu

## Cucumber

- Tutoriels
    - [Cucumber 10-minute tutorial](https://cucumber.io/docs/guides/10-minute-tutorial/)
    - Commande maven pour générer un projet Cucumber

    ```sh
    mvn archetype:generate "-DarchetypeGroupId=io.cucumber" "-DarchetypeArtifactId=cucumber-archetype" "-DarchetypeVersion=7.20.1" "-DgroupId=hellocucumber" "-DartifactId=hellocucumber" "-Dpackage=hellocucumber" "-Dversion=1.0.0-SNAPSHOT" "-DinteractiveMode=false"
    ```

    - [iblasquez/tuto_bdd_cucumber](https://github.com/iblasquez/tuto_bdd_cucumber)
    - [Exemple d'intégration avec Selenium](https://proleed.academy/exercises/cucumber/cucumber-practice-exercises.php)
    - [cucumber-bdd-tutorial](https://www.softwaretestinghelp.com/cucumber-bdd-tutorial/)
- [Langages supportant Cucumber et alternatives pour d'autres langages](https://cucumber.io/docs/installation/)

## Katas BDD

Les katas sont des exercices de programmation qui permettent de s'entraîner à la programmation.
Ceux-ci peuvent aussi être utilisés pour apprendre la méthode BDD.

Exemples de sites de katas: [Code wars](https://www.codewars.com/), [Coding Dojo](https://codingdojo.org/kata/Bowling/).

Nous allons réaliser le [kata bowling](https://codingdojo.org/kata/Bowling/).
Principe : le professeur code ce que les élèves lui disent.
Chaque élève prend la parole à son tour pendant 10 minutes et doit dire ce que le professeur doit coder.

## Exercices

1. Développer le jeu du pendu avec la méthode BDD ([Doc si vous êtes bloqué](https://gayerie.dev/docs/testing/test_acceptation/cucumber.html)).
1. [Faire le TP d'intégration avec Selenium](https://proleed.academy/exercises/cucumber/cucumber-practice-exercises.php)
1. Développer un jeu de morpion avec la méthode BDD.

##
