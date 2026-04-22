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

- Faire un `bun install` pour vérifier que le workspace monorepo est bien initialisé :

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

- Créez `02-use-cases/src/MemberDTO.ts` :

    ```typescript
    --8<-- archi/clean-archi-ts-demo/02-use-cases/src/MemberDTO.ts
    ```

- Créez `02-use-cases/src/MemberRepository.ts` :

    ```typescript
    import { MemberDTO } from "./MemberDTO";

    export interface MemberRepository {
        save(member: Member): Promise<void>;
        findById(id: string): Promise<MemberDTO | null>;
    }
    ```

- 

### Use Case

Créez `src/use-cases/implementations/RegisterMemberUseCase.ts` :

```typescript
import { Member } from "01-entities";
import { MemberRepository } from "../interfaces/MemberRepository";

export class RegisterMemberUseCase {
    constructor(private readonly memberRepository: MemberRepository) {}

    async execute(name: string, email: string): Promise<string> {
        const member = new Member(crypto.randomUUID(), name, email);
        await this.memberRepository.save(member);
        return member.id;
    }
}
```

### Repository (Infrastructure)

Créez `src/infrastructure/repositories/InMemoryMemberRepository.ts` :

```typescript
import { Member } from "@/domain/entities/Member";
import { MemberRepository } from "@/use-cases/interfaces/MemberRepository";

export class InMemoryMemberRepository implements MemberRepository {
    private members = new Map<string, Member>();

    async save(member: Member): Promise<void> {
        this.members.set(member.id, member);
    }

    async findById(id: string): Promise<Member | null> {
        return this.members.get(id) || null;
    }
}
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

## Extensions Possibles

- Ajoutez un serveur HTTP avec Bun's built-in server pour exposer une API REST.
- Intégrez une vraie base de données (SQLite, PostgreSQL).
- Ajoutez des tests unitaires avec un framework comme Vitest.
- Implémentez plus de use cases (mise à jour, suppression de membres).

Ce tutoriel démontre les principes fondamentaux de la Clean Architecture avec TypeScript et Bun. Pour des applications plus complexes, considérez l'utilisation de frameworks comme NestJS pour faciliter l'injection de dépendances et la gestion des routes.
