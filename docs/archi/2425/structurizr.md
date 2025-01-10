# Présentation de Structurizr

## 1. Introduction à Structurizr

### Qu'est-ce que Structurizr ?

Structurizr est une plateforme conçue pour créer, gérer et partager des diagrammes d'architecture logicielle.
Contrairement aux outils traditionnels comme Visio ou Lucidchart,
Structurizr adopte une approche "Architecture as Code".

### Origine

-   **Créateur :** Simon Brown, consultant en architecture logicielle et auteur du modèle C4.
-   **Date de création :** 2014.
-   **Motivation :**
    -   Répondre au besoin d'avoir des diagrammes précis et à jour directement issus du code source.
    -   Réduire l'écart entre la documentation et l'implémentation réelle.
    -   Faciliter la collaboration sur l'architecture logicielle.

### Pourquoi Structurizr ?

-   Génération de diagrammes à jour.
-   Documentation vivante et intégrée.
-   Approche "Architecture as Code" pour une meilleure gestion versionnée et automatisation.

---

## 2. Fonctionnalités principales

### Création de diagrammes

Structurizr est optimisé pour les diagrammes C4

### Architecture as Code

-   Définition d'architectures avec du code (Java, .NET, TypeScript, DSL).
-   Avantages :
    -   Reproductibilité.
    -   Intégration avec CI/CD.
    -   Versionnement des diagrammes.

### Affichages et visualisations

-   Navigation interactive entre les niveaux de diagrammes.
-   Styles configurables (layouts, thèmes, couleurs).
-   Exportation en images ou formats web.
-   [Tree-views](img/tree-views.jpg)
-   [Interactive force-directed graphs](./img/interactive-force-directed-graphs.jpg)

### Documentation intégrée

-   Support des **ADR** (Architecture Decision Records).
-   Ajout de descriptions contextuelles aux diagrammes.

---

## 3. Alternatives

-   **PlantUML :** Génération de diagrammes textuels.
-   **Mermaid.js :** Intégré à des plateformes comme GitHub.

---

## 4. Démonstration avec Structurizr-Lite

### Objectifs

1. Créer un projet Structurizr.
2. Générer un diagramme simple (exemple: diagramme de contexte).
3. Naviguer entre les différents niveaux de diagrammes.
4. Présenter les possibilités d'exportation et l'intégration avec la documentation.

### Étapes de la démo

#### 1. Installation

-   Télécharger [Structurizr Lite](https://docs.structurizr.com/lite).
-   Image Docker Structurizr Lite : `structurizr/lite`.
-   Configurer un projet local avec un fichier `.dsl`.

#### 2. Création d'un diagramme

-   Lancer Structurizr-Lite et visualiser le diagramme.

#### 3. Fonctionnalités

-   Ajouter des conteneurs ou composants au modèle :
-   Changer les styles ou layouts.

#### 4. Lien avec les ADR et documentation

-   Ajouter des fichiers markdown pour documenter les décisions d'architecture.
-   Intégrer une vue combinée (diagrammes et ADR).

#### 5. Reverse engineering

[Reverse Engineer Java](img/reverse-engineer-java.jpg)

---

## 5. Structurizr et la documentation d'architecture

### Liens avec les ADR

-   Structurizr peut intégrer des **ADR** pour relier les diagrammes aux décisions architecturales.

### Documentation vivante

-   Structurizr génère automatiquement une documentation en ligne.
-   Toujours synchronisé avec les mises à jour du modèle.

---
