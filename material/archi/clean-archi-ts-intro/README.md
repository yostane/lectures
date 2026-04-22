# clean-archi

Explication des dossiers :

-   business-domain : entités
-   application : le métier
-   interfaces : fait le lien entre les use cases et les interfaces externes (API, base de données, etc). C'est là qu'on définit les controlleurs (api et pages web) et les repository (données)
-   infrastructure : mise en place des différents frameworks

Lancer l'application :

```sh
cd infrastructure
bun index.ts # ou bun run dev
```
