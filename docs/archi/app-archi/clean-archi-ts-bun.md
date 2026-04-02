# Clean Architecture avec TypeScript + Bun

Ce tutoriel vous guide pas à pas pour créer une application simple en Clean Architecture avec TypeScript et Bun. Bun est un runtime JavaScript/TypeScript rapide et moderne, compatible avec Node.js, qui offre une gestion des paquets intégrée et des performances supérieures.

## Prérequis

- Bun installé sur votre machine (voir [documentation officielle](https://bun.sh/docs/installation)).
- Connaissances de base en TypeScript et `package.json`.

## Initialisation du Projet

Créez un nouveau dossier pour votre projet et initialisez-le avec Bun :

```bash
mkdir clean-archi-app
cd clean-archi-app
bun init
```

Cela crée un `package.json` de base. Modifiez-le pour ajouter les dépendances nécessaires :

```json
{
    "name": "clean-archi",
    "module": "index.ts",
    "type": "module",
    "private": true,
    "workspaces": [
        "interfaces",
        "use-cases",
        "business-domain",
        "infrastructure"
    ],
    "devDependencies": {
        "@types/bun": "latest"
    },
    "peerDependencies": {
        "typescript": "^5"
    }
}
```

Installez les dépendances :

```bash
bun install
```

## Structure des Dossiers

Organisez votre projet selon les couches de la Clean Architecture :

```
src/
├── domain/
│   ├── entities/
│   │   └── Member.ts
│   └── value-objects/
├── use-cases/
│   ├── interfaces/
│   │   └── MemberRepository.ts
│   └── implementations/
│       └── RegisterMemberUseCase.ts
├── interfaces/
│   ├── controllers/
│   │   └── MemberController.ts
│   ├── presenters/
│   └── dtos/
├── infrastructure/
│   ├── repositories/
│   │   └── InMemoryMemberRepository.ts
│   └── frameworks/
└── index.ts
```

## Implémentation des Couches

### Entité (Domain)

Créez `src/domain/entities/Member.ts` :

```typescript
export class Member {
    constructor(
        public readonly id: string,
        public name: string,
        public email: string,
    ) {}

    updateName(newName: string): void {
        if (newName?.trim().length === 0) {
            throw new Error("Le nom ne peut pas être vide");
        }
        this.name = newName.trim();
    }
}
```

### Interface du Repository (Use Cases)

Créez `src/use-cases/interfaces/MemberRepository.ts` :

```typescript
import { Member } from "@/domain/entities/Member";

export interface MemberRepository {
    save(member: Member): Promise<void>;
    findById(id: string): Promise<Member | null>;
}
```

### Use Case

Créez `src/use-cases/implementations/RegisterMemberUseCase.ts` :

```typescript
import { Member } from "@/domain/entities/Member";
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
