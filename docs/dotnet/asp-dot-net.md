# ASP .Net

## Prérequis

- Faire confiance au certificat SSL local (pour le dev) `dotnet dev-certs https --trust`

## Création d'une API minimals (un seul fichier)

- Créer un Projet d'API "minimal API" `dotnet new webapi -o HelloApi`. Ensuite, `cd HelloApi`.
- Les éléments suivants sont créés (on peut voir avec un `ls`):
    - Program.cs: point d'entrée de l'application qui définit déjà un API Rest et un endoint get.
    - api01.csproj: fichier de configuration du projet.
    - api01.http: fichier de test de l'API avec l'extension VSCode *Rest Client*.
    - Properties, appsettings.Development.json et appsettings.json: permettent de configurer l'application et le serveur
- Lancer le serveur `dotnet run`, ou en mode hot reload `dotnet watch run`
- Tester l'API avec un client REST (comme *Rest Client* de VSCode)

```cs title="calls.http"
--8<--
aspdotnet/api01/api01.http
--8<--
```

## Autre exemple

```cs title="calls.http"
--8<--
aspdotnet/HelloApi/Program.cs
--8<--
```

## Ressources

- [Tutoriel officiel](https://learn.microsoft.com/en-us/aspnet/core/tutorials/min-web-api?tabs=visual-studio-code)
