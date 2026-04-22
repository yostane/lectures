# Clean Architecture avec TypeScript + Bun

Ce tutoriel vous guide pas à pas pour créer une application simple en Clean Architecture avec TypeScript et Bun.
Ce dernier est un runtime JavaScript/TypeScript rapide et moderne, compatible avec Node.js, qui offre une gestion des paquets intégrée et des performances supérieures.

## Prérequis

- Bun installé sur votre machine (voir [documentation officielle](https://bun.sh/docs/installation)).
- Connaissances de base en TypeScript et `package.json`.

## Initialisation du Projet

Nous allons créer un workspace monorepo pour organiser notre projet selon les différentes couches de la Clean Architecture.

- Créez un nouveau dossier pour votre projet avec la structure de dossiers souhaitée et initialisez-le avec Bun :

    ```bash
    mkdir clean-archi-app
    cd clean-archi-app
    bun init # puis, Choisir -> blank
    ```

- Ensuite, créer un sous-projet (qu'on appelle module) par couche de la Clean Architecture :

    ```bash
    bun init --yes "01-entities"
    bun init --yes "02-use-cases"
    bun init --yes "03-adapters"   
    bun init --yes "04-interfaces"
    ```

- Ensuite, renseigner les sous-projets (ou modules) dans le `package.json` à la racine du projet, dans la section `workspaces` :


    ```json
    --8<-- archi/clean-archi-ts-demo/package.json
    ```

- Faire un `bun install` pour vérifier que le workspace monorepo est bien initialisé. Cette commande installe les dépendances de tous les modules et crée les liens symboliques nécessaires entre eux. **Donc, un seul `bun install` à la racine suffit.**

    ```bash
    bun install
    ```

- Vous devriez avoir la structure suivante:

```
racine/
├── 01-entities/
    ├── package.json
├── 02-use-cases/
    ├── package.json
├── 03-adapters/
    ├── package.json
├── 04-interfaces/
    ├── package.json
├── package.json
```

## Implémentation des Couches

### Entité (Domain)

- Créez `01-entities/src/Member.ts` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/01-entities/src/Member.ts
    ```

- Dans `01-entities/index.ts`, exportez l'entité :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/01-entities/index.ts
    ```

### Use Cases

Contient : 

- La logique métier de l'application, orchestrant les interactions entre les entités et les interfaces.
- Les interfaces des `repositories` (abstractions pour la persistance des données). Ces derniers seront implémentés dans la couche d'infrastructure.

Suivre les étapes suivantes pour implémenter la couche des Use Cases :

- Importer les entités dans `02-use-cases/package.json` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/02-use-cases/package.json
    ```

- Lancer `bun install` à la racine du projet pour que les dépendances soient résolues.
- Définir l'interface repository `02-use-cases/src/MemberRepository.ts` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/02-use-cases/src/MemberRepository.ts
    ```

- Définir le use case `02-use-cases/src/MemberUseCase.ts` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/02-use-cases/src/MemberUseCase.ts
    ```

### Infrastructure (adapters)
 
Cette couche définit :

- L'implémentation concrète des interfaces de la couche des Use Cases, comme les repositories.
- L'implémentation des contrôleurs pour exposer les use cases via une API (REST, GraphQL, etc.).

Suivre les étapes suivantes pour implémenter la couche d'infrastructure :

- Ajouter les dépendances nécessaires dans `03-adapters/package.json` :

    ```json
    --8<-- archi/clean-archi-ts-demo/03-adapters/package.json
    ```

- Lancer `bun install` à la racine du projet pour que les dépendances soient résolues.
- Créez `src/src/InMemoryMemberRepository.ts` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/03-adapters/src/InMemoryMemberRepository.ts
    ```

- Exportez le repository dans `src/index.ts` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/03-adapters/src/index.ts
    ```

### Contrôleur (Interface Adapters)

Créez `src/interfaces/controllers/MemberController.ts` :

```typescript
import { RegisterMemberUseCase } from "@/use-cases/implementations/RegisterMemberUseCase";

export class MemberController {
    constructor(
        private readonly registerMemberUseCase: RegisterMemberUseCase,
    ) {}

    async register(name: string, email: string): Promise<{ memberId: string }> {
        try {
            const memberId = await this.registerMemberUseCase.execute(
                name,
                email,
            );
            return { memberId };
        } catch (error) {
            throw new Error(`Erreur lors de l'inscription: ${error.message}`);
        }
    }
}
```

## Point d'Entrée

Créez `src/main.ts` :

```typescript
import { MemberController } from "./interfaces/controllers/MemberController";
import { RegisterMemberUseCase } from "./use-cases/implementations/RegisterMemberUseCase";
import { InMemoryMemberRepository } from "./infrastructure/repositories/InMemoryMemberRepository";

// Injection des dépendances
const memberRepository = new InMemoryMemberRepository();
const registerMemberUseCase = new RegisterMemberUseCase(memberRepository);
const memberController = new MemberController(registerMemberUseCase);

// Simulation d'utilisation
async function main() {
    try {
        const result = await memberController.register(
            "John Doe",
            "john@example.com",
        );
        console.log("Membre inscrit avec ID:", result.memberId);
    } catch (error) {
        console.error(error.message);
    }
}

main();
```

## Exécution de l'Application

Lancez l'application en mode développement :

```bash
bun run dev
```

Ou construisez et exécutez :

```bash
bun run build
bun run start
```

Vous devriez voir dans la console : "Membre inscrit avec ID: [un UUID]".

## Problèmes Potentiels

- `bun pm cache clean` : Nettoie le cache de Bun, utile si vous rencontrez des problèmes de dépendances ou de build.
- `bun pm cache rm -g` : Supprime le cache global de Bun, ce qui peut résoudre des problèmes liés à des paquets globaux corrompus ou obsolètes.

## Extensions Possibles

- Ajoutez un serveur HTTP avec Bun's built-in server pour exposer une API REST.
- Intégrez une vraie base de données (SQLite, PostgreSQL).
- Ajoutez des tests unitaires avec un framework comme Vitest.
- Implémentez plus de use cases (mise à jour, suppression de membres).

Ce tutoriel démontre les principes fondamentaux de la Clean Architecture avec TypeScript et Bun. Pour des applications plus complexes, considérez l'utilisation de frameworks comme NestJS pour faciliter l'injection de dépendances et la gestion des routes.
