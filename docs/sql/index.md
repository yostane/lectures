# Langage SQL avancé
s
## Introduction

SQL (Structured Query Language) est un langage de programmation utilisé pour gérer et manipuler des bases de données relationnelles.

## Base de données relationnelle

Les caractéristiques principales des bases de données relationnelles incluent :

-   **Tables** : Les données sont organisées en tables composées de lignes et de colonnes.
-   **Relations** : Les tables peuvent être liées entre elles par des clés primaires et étrangères.
-   **Intégrité des données** : Les bases de données relationnelles utilisent des contraintes pour assurer la validité et la cohérence des données.

## Types de bases de données relationnelles

- Base de données sans serveur:
    - Fichier plat: CSV, JSON, XML, SQLite, H2
    - Mémoire: H2, SQLite
- Base de données avec serveur:  MySQL, PostgreSQL, Oracle DB, SQL Server, H2

On peut observer que certaines bases de données supportent plusieurs types d'utilisation, comme H2.

## SQLite

SQLite est une base de données relationnelle légère et intégrée qui ne nécessite pas de serveur pour fonctionner. Elle est souvent utilisée pour les applications mobiles, les applications de bureau et les projets de développement rapide.

Quelques spécificités de SQLite:

- Les tables ont une clé primaire auto-incrémentée par défaut appelée `rowid`. Une colonne en `autoincrement` explicite n'est pas recommandée ([source](https://www.sqlite.org/autoinc.html)).
- Les fichiers de base données utilisent une extension `.db` ou `.sqlite`.

## PostgreSQL

PostgreSQL est une base de données relationnelle open-source puissante et robuste qui prend en charge une large gamme de fonctionnalités avancées, telles que les transactions, les vues, les procédures stockées et les types de données personnalisés.

## Sources

-   [Mastocodeur/sql-fast-learner](https://github.com/Mastocodeur/sql-fast-learner)
