# API TypeScript + Bun en Clean Architecture

Ce tutoriel présente une implémentation d'une API simple en TypeScript utilisant Bun, organisée selon les principes de la Clean Architecture. Nous allons améliorer l'exemple précédent en ajoutant une API REST et en structurant le projet de manière différente.

## Prérequis

- Avoir suivi le [tutoriel précédent](./clean-archi-ts-bun.md) pour avoir une base de code avec les entités, use cases et repository.

## Préparation du projet

Pour montrer la flexibilité de la clean architecture, nous allons proposer une autre structure de dossiers.
Nous regroupons les entités et use cases dans un module `core`, et les adapters (repository, controllers) dans des modules séparés. L'interface (API REST) sera dans un module dédié.

```
racine/
├── core/
│   ├── entities/
│   ├── use-cases/
    ├── package.json
├── adapter-in-memory-repository/
    ├── package.json
├── adapter-controllers/
    ├── package.json
├── interface-express/
    ├── package.json
├── package.json
```

Dans ce qui suit, nous allons nous focaliser sur l'implémentation de l'API REST dans le module `interface-express` et des controleurs dans `adapter-controllers`.