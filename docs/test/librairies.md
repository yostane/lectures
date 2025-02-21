# Quelques librairies de tests

Généralement, automatiser des tests requiert trois choses:

1. L'outil ou le moteur d'exécution des tests et de restitution des résultats (sous forme visuelle ou dans un fichier / rapport)
1. Du code de test (soit le même langage que le projet, soit un langage différent) qui contient des assertions
1. Une librairie ou framework de test (qui fait le lien entre le code et le moteur)

## JUnit

Framework de test Java permet de tester son code via des assertions.
Explorons le projet de démarrage fourni par le [guide officiel](https://junit.org/junit5/docs/current/user-guide/)

### Exercices

1. Ecrire un test unitaire `StringTest` qui test ces méthodes de la classe `String`: `toUpperCase()`, `toLowerCase()` et `charAt()`.
1. Exo 2 de [cette série](http://deptinfo.cnam.fr/~graffion/UES/GLG101/tps/java/index.html)
    - Ignorer les CE invalides b5 et b6
1. Exercice 2 [de cette série](https://github.com/mjeanroy/exercices-java/blob/master/exercices-junit.txt) qui nécessite d'abord de faire d'abord ces exercices: [partie1](https://github.com/mjeanroy/exercices-java/blob/master/exercice-data-structures.txt), [partie2](https://github.com/mjeanroy/exercices-java/blob/master/exercice-data-structures2.txt)
1. Cet [exo de librecours.net](https://librecours.net/module/js/js18/test-unitaire_app.xhtml). Le code est à traduire du JS vers du Java.
1. Cet [exercice de librecours.net](https://librecours.net/module/js/js18/test-fonctionnel_app.xhtml). Le code est à traduire du JS vers du Java.
1. Ce [TD qui provient de labri](https://www.labri.fr/perso/renault/working/teaching/testlog/files/td2.pdf). Le `makefile` est l'équivalent de `maven` pour nous. Faire la question 3 avec cette commande à la place de l'outil proposé `mvn surefire-report:report`.

??? "Quelques astuces"

    - Exo2 : Fonctions corriger / modifier: `checkDay`, `checkYear`, `checkDayLimits`, renommer ou enlever `maxDayOfMonth(month)`, `testFebruaryValidLimitDates`, `testValidLimitDates`
    - [Quelques solutions](https://github.com/yostane/lectures/tree/main/material/test/exercices/junit-corrections)

## Tests dans un projet Spring MVC

### API REST sans base de données

- Générer un projet Spring avec [initializr](https://start.spring.io/), en choisissant les dépendances suivantes: Spring Web et Spring Boot DevTools.
- Ouvrir le projet sur VSCode
- Créer un `@RestController` avec deux routes en @GET et en @POST, un modèle et un service qui gère une liste statique en mémoire.
    - Je vous propose d'utiliser comme modèle une classe `Manga` avec trois champs `ISBN`, `name` et `nbPages`

    ```java
    --8<--
    test/exercices/spring-test-starter-01/src/main/java/com/cours/testlog/model/Manga.java
    --8<--
    ```

    ```java
    --8<--
    test/exercices/spring-test-starter-01/src/main/java/com/cours/testlog/controller/MangaController.java
    --8<--
    ```

    ```java
    --8<--
    test/exercices/spring-test-starter-01/src/main/java/com/cours/testlog/service/MangaService.java
    --8<--
    ```

- Lancer votre serveur et vérifier qu'il fonctionne avec la bonne commande (avec gradle `./gradlew bootRun`, avec maven `./mvnw springboot:run`) ou depuis votre IDE
- Écrire des tests unitaires pour le service
- Spring propose deux façons de tester le contrôleur (en d'autres termes l'API REST).
    - En lançant un serveur web (avec la stack HTTP complète) via la classe `TestRestTemplate`

    ```java
    @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
    public class MangaControllerTests {
        @Autowired
        private TestRestTemplate restTemplate;

        @Autowired
        private MangaService mangaService;

        @BeforeEach
        void setup() {
            mangaService.removeAll();
        }

        @Test
        public void testGetAll() {
            // https://www.baeldung.com/spring-rest-template-list
            var response = restTemplate.getForEntity("/manga", Manga[].class);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(0, response.getBody().length);

            Manga manga = new Manga();
            manga.setIsbn("sdsfds");
            manga.setName("my hero academia");
            manga.setNbPages(40);
            restTemplate.postForEntity("/manga", manga, Void.class);

            response = restTemplate.getForEntity("/manga", Manga[].class);
            assertNotNull(response.getBody());
            assertEquals(1, response.getBody().length);
            Manga responseManga = (Manga) response.getBody()[0];
            org.assertj.core.api.Assertions.assertThat(responseManga.getIsbn()).isEqualTo(manga.getIsbn());
            assertEquals(manga.getIsbn(), responseManga.getIsbn());
        }

        @Test
        public void testCannotAddSameIsbnTwice() {
            //TODO
        }
    }
    ```

    - En lançant un serveur bouchonné (on n'a pas la stack HTTP complète) via la classe `MockMVC`.
- Écrire le test de `testCannotAddSameIsbnTwice` qui vérifie que l'on ne peut pas ajouter deux mangas avec le même ISBN. Implémenter ce test avec `TestRestTemplate` et `MockMVC`.
- Ajouter une méthode PUT qui permet de modifier un manga existant (erreur 404 si le manga n'existe pas). Ajouter un test pour cette méthode.
- Ajouter une méthode DELETE qui permet de supprimer un manga existant (erreur 404 si le manga n'existe pas). Ajouter un test pour cette méthode.

### API REST avec une base de données

Nous allons utiliser la BDD H2 pour sa simplicité car c'est une BDD relationnelle (SQL) qui ne nécessite pas de serveur et réside en mémoire (RAM) par défaut.

- Générer un projet Spring avec [le créateur en ligne](https://start.spring.io/) en choisissant les dépendances suivantes: Spring Data JPA, H2 Database, Spring Boot DevTool et Spring Web.
- Ouvrir le projet sur VSCode
- Créer une classe "Model" avec l'annotation `@Entity` et les annotations `@Id` et `@GeneratedValue` sur sa clé primaire.
- Créer une interface `xxxxRepository: JpaRepository<Product, Long>` où xxx est le nom de votre modèle
- Créer un contrôleur avec les routes en @GET, @POST, PUT et DELETE, un modèle et un service qui gère communique avec votre repository
- Relancer les tests et s'assurer qu'ils fonctionnent toujours.

## Liens et références

- Anecdote: [SQLite](https://www.sqlite.org/testing.html) est réputé pour avoir une proportion importante de tests.
- <http://deptinfo.cnam.fr/~graffion/UES/GLG101/tps/java/index.html>
- <https://gayerie.dev/docs/testing/test/junit.html>
- <https://github.com/mjeanroy/exercices-java/blob/master/exercices-junit.txt>
