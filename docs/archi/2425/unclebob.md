# 👨‍💻 Uncle Bob (Robert C. Martin)

## 🧔 Qui est Uncle Bob ?

Robert C. Martin, surnommé **Uncle Bob**, est une figure emblématique du développement logiciel moderne. Il est reconnu comme l’un des pionniers dans la formalisation des bonnes pratiques de développement et la promotion de la qualité du code.

---

## 🏆 Contributions principales :

### 1. **Auteur de livres influents :**
- *Clean Code* (2008) : 
    Une référence pour écrire du code clair et maintenable.
- *The Clean Coder* (2011):
     Des conseils pour adopter une éthique professionnelle et programmation.
- *Clean Architecture* (2017) : Présente des principes d'architecture     durable

### 2. **Co-auteur du Manifeste Agile :**
Uncle Bob est l’un des 17 signataires du **Manifeste Agile** publié en 2001.

### 3. **Créateur des principes SOLID :**
Un ensemble de cinq principes fondamentaux pour concevoir des logiciels robustes et maintenables.

### 4. **Créateur et promoteur de la Clean Architecture :**
Uncle Bob a conceptualisé la **Clean Architecture**, un ensemble de principes pour construire des systèmes logiciels flexibles, évolutifs et faciles à maintenir.

---

## ⚙️ Les principes SOLID

Les principes **SOLID**, sont des lignes directrices pour structurer et organiser du code de manière robuste, évolutive et maintenable.

### 🧩 Signification de SOLID :

1. **S - Responsabilité unique (Single Responsibility Principle)** :
   - Chaque classe ou module doit avoir **une seule responsabilité**

2. **O - Ouvert/fermé (Open/Closed Principle)** :
   - Un module doit être **ouvert à l’extension**, mais **fermé à la modification**

3. **L - Substitution de Liskov (Liskov Substitution Principle)** :
   - Les classes dérivées doivent pouvoir **remplacer** leurs classes parent sans altérer le comportement du programme.
    - EX: Une instance de type T doit pouvoir être remplacée par une instance de type G, tel que G sous-type de T, sans que cela ne modifie la cohérence du programme

4. **I - Ségrégation des interfaces (Interface segregation principle)** :
   - Préférer utiliser plusieurs interface spécifique plutot qu'une seule interface. Il ne faut pas que les classes dépendes de méthodes qu'elles n'utilisent pas

5. **D - Inversion des dépendances (Dependency inversion principle)** :
   - il faut dépendre des abstractions, pas des implémentations

### 🎯 Avantages de SOLID :
- Facilite la **maintenance** et l’évolution du code.
- Encourage une conception modulaire et testable.
- Réduit la dette technique à long terme.

---

## 🏛️ Qu'est-ce que la Clean Architecture ?

La **Clean Architecture** est une méthode d'organisation du code logiciel en couches indépendantes

### 🎯 Objectifs :
1. **Indépendance des couches** : 
   - Le domaine métier est isolé des interfaces, bases de données et frameworks.
   - *Indépendance vis-à-vis des technologies:* 
   En découplant la logique métier des technologies utilisées vous n’êtes plus lié à des choix technologiques spécifiques
   - *Maintenance et Évolution simplifiées:* 
   La clarté et l’organisation du code facilitent sa compréhension et sa maintenance. Ajouter de nouvelles fonctionnalités ou modifier des comportements existants devient plus aisé
   - *Sécurité renforcée*
2. **Adaptabilité** : 
   - Les détails techniques (frameworks, API, etc.) peuvent être changés sans impacter le cœur métier.
3. **Testabilité** : Chaque composant peut être testé indépendamment.
4. **Longévité** : Une architecture solide réduit la dette technique et facilite les évolutions futures.


### 🔄 Structure en couches :

La Clean Architecture est souvent représentée sous la forme de cercles concentriques :

1. **Les Entités (Entities)** : Incarnent les règles et cas d’usage les plus généraux de l’application
2. **Les Cas d’Usage (Use Cases)** : Ils encapsulent toute la logique métier spécifique à l’application
3. **Les Adaptateurs d’Interface (Interface Adapters)** : Cette couche fait le lien entre les cas d’usage et les couches les plus externes. 
Elle adapte les données aux formats nécessaires pour les cas d’usage et les inferfaces externes
4. **Les Interfaces Utilisateurs (UIs) et les Frameworks et Drivers (Frameworks & Drivers)** : La couche externe comprend tout ce qui est en contact avec le monde extérieur, comme l’interface utilisateur, les systèmes de bases de données, les serveurs web, etc

        +-----------------------------+
        |    Frameworks & Drivers    |
        +-----------------------------+
                   ▲
        +-----------------------------+
        |   Interface Adapters        |
        +-----------------------------+
                   ▲
        +-----------------------------+
        |         Use Cases           |
        +-----------------------------+
                   ▲
        +-----------------------------+
        |           Entities          |
        +-----------------------------+

### Défis: