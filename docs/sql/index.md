# Langage SQL avancé

## Introduction

SQL (Structured Query Language) est un langage de programmation utilisé pour gérer et manipuler des bases de données relationnelles.

## Base de données relationnelle

Les caractéristiques principales des bases de données relationnelles incluent :

- **Tables** : Les données sont organisées en tables composées de lignes et de colonnes.
- **Relations** : Les tables peuvent être liées entre elles par des clés primaires et étrangères.
- **Intégrité des données** : Les bases de données relationnelles utilisent des contraintes pour assurer la validité et la cohérence des données.

## Types de bases de données relationnelles

- Base de données sans serveur:
    - Fichier plat: CSV, JSON, XML, SQLite, H2
    - Mémoire: H2, SQLite
- Base de données avec serveur: MySQL, PostgreSQL, Oracle DB, SQL Server, H2

On peut observer que certaines bases de données supportent plusieurs types d'utilisation, comme H2.

## SQLite

SQLite est une base de données relationnelle légère et intégrée qui ne nécessite pas de serveur pour fonctionner. Elle est souvent utilisée pour les applications mobiles, les applications de bureau et les projets de développement rapide.

Quelques spécificités de SQLite:

- Les tables ont une clé primaire auto-incrémentée par défaut appelée `rowid`. Une colonne en `autoincrement` explicite n'est pas recommandée ([source](https://www.sqlite.org/autoinc.html)).
- Les fichiers de base données utilisent une extension `.db` ou `.sqlite`.
- Pas de support pour les procédures stockées, définition de fonctions (à part via du C), les vues ou les déclencheurs complexes.

## PostgreSQL

PostgreSQL est une base de données relationnelle open-source puissante et robuste qui prend en charge une large gamme de fonctionnalités avancées, telles que les transactions, les vues, les procédures stockées et les types de données personnalisés.

### Préparation

Ce fichier compose permet de lancer une base de données PostgreSQL et une Web UI d'administration appelée *adminer*.
Pour le lancer, il suffit de se placer à la racine du projet et d'exécuter la commande suivante:

```bash
docker-compose up
# ou avec podman-compose
podman-compose up
```

??? "compose.yml"

    ```yaml
    --8<--
    sql/compose.yml
    --8<--
    ```

Installer les extensions VSCode suivantes pour interagir avec la base de données: *SQLTools* et son driver *SQLTools PostgreSQL*.

### spécificités de PostgreSQL

- Support des enums (types de données énumérés) pour restreindre les valeurs possibles d'une colonne à un ensemble défini de valeurs.
- Support du JSON et du JSONB (JSON encodé en binaire au lieu de texte) pour le stockage de données semi-structurées (peut donc remplacer une BDD NoSQL).

??? "Définition d'une table utilisant du JSONB et d'une enum"

    ```sql
    --8<--
    sql/scripts/setup.sql
    --8<--
    ```

??? "Exemple de JSONB"

    [Documentation](https://www.postgresql.org/docs/current/functions-json.html)

    ```sql
    --8<--
    sql/scripts/demo-jsonb.sql
    --8<--
    ```

- Support des fonctions définies par l'utilisateur pour effectuer des opérations spécifiques sur les données.

??? "Exemple de fonction"

    ```sql
    --8<--
    sql/scripts/demo-functions.sql
    --8<--
    ```

- Support des vues pour créer des tables virtuelles basées sur des requêtes SQL. Les vues sont recalculées à chaque fois qu'elles sont utilisées, ce qui permet de garantir que les données affichées sont toujours à jour.

??? "Exemple de vue"

    ```sql
    --8<--
    sql/scripts/demo-views.sql
    --8<--
    ```

### PostgREST

PostgREST est un serveur web qui expose une API RESTful basée sur une base de données PostgreSQL. Il permet de créer rapidement des API pour interagir avec les données stockées dans PostgreSQL, en utilisant des requêtes SQL pour définir les endpoints et les opérations disponibles.

- Lancer une instance de postgres.
- Installer PostgREST [en suivant ce guide](https://docs.postgrest.org/en/v14/tutorials/tut0.html#step-2-install-postgrest)
- Créer une base de données pour accueillir les données de l'API en suivant [ce guide](https://docs.postgrest.org/en/v14/tutorials/tut0.html#step-3-create-database-for-api).

??? "BDD qui accueillera les données de l'API"

    ```sql
    --8<--
    sql/scripts/postgrest-setup.sql
    --8<--
    ```

- Créer un fichier de configuration pour PostgREST (qu'on peut appeler `postgrest-api.conf`) avec le contenu suivant:

??? "Configuration de PostgREST"
    ```conf
    --8<--
    sql/postgrest-api.conf
    --8<--
    ```

- Lancer le serveur PostgREST en utilisant la commande suivante `postgrest postgrest-api.conf`
- Tester l'API avec un `curl http://localhost:3000/todos`.

### Row Level Security (RLS)

Row Level Security (RLS) est une fonctionnalité de PostgreSQL qui permet de contrôler l'accès aux données au niveau des lignes d'une table. Avec RLS, les administrateurs de la base de données peuvent définir des politiques de sécurité qui restreignent l'accès aux données en fonction des rôles et des permissions des utilisateurs.

### Recherche full-text

Postgres supporte la recherche full-text, qui permet de rechercher des mots ou des phrases dans des colonnes de texte. Cette fonctionnalité est similaire à ce que proposer des moteurs de recherche comme Elasticsearch, mais elle est intégrée directement dans la base de données, ce qui peut simplifier l'architecture de l'application.

Il est possible d'utiliser deux approches pour la recherche full-text dans Postgres:

- Utiliser les opérateurs de recherche full-text intégrés, tels que `to_tsvector`, `@@` et `to_tsquery`, pour effectuer des recherches sur des colonnes de texte.
- utiliser une extension de recherche full-text tierce, telle que [pg_trgm](https://www.postgresql.org/docs/current/pgtrgm.html) ou [pg_search](https://github.com/paradedb/paradedb/tree/main/pg_search).

La fonctionnalité `GENERATED ALWAYS AS` permet de créer des colonnes générées automatiquement à partir d'autres colonnes de la table. Cela peut être utilisé pour créer une colonne de recherche full-text qui est automatiquement mise à jour chaque fois que les données de la table sont modifiées.

Alternativement, on peut aussi créer un index `GIN` de type `tsvector` sur une colonne textuelle pour améliorer les performances des recherches full-text avec `tsvector`.

??? "Exemple de recherche full-text avec les opérateurs intégrés"

    ```sql
    --8<--
    sql/scripts/demo-tsvector.sql
    --8<--
    ```

Sources:

- [neon.com: postgresql-full-text-search](https://neon.com/postgresql/postgresql-indexes/postgresql-full-text-search)
- [PostgreSQL Documentation: Text Search Controls](https://www.postgresql.org/docs/current/textsearch-controls.html)
- [neon.com: Postgres Full-Text Search vs Elasticsearch](https://neon.com/blog/postgres-full-text-search-vs-elasticsearch)
- [Instaclustr: PostgreSQL Full-Text Search](https://www.instaclustr.com/blog/postgresql-full-text-search/)

### Supabase

Supabase est une plateforme de développement d'applications qui fournit une suite d'outils pour créer des applications web et mobiles. Elle utilise PostgreSQL comme base de données principale et offre des fonctionnalités telles que l'authentification, le stockage de fichiers, les fonctions serverless et les API en temps réel.

## Sources

- [Mastocodeur/sql-fast-learner](https://github.com/Mastocodeur/sql-fast-learner)
- [stackoverflow.com](https://stackoverflow.com/a/56937212)
- [blog.logto.io](https://blog.logto.io/fr/maitriser-postgresql-jsonb)
