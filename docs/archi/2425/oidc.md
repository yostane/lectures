# OAuth et OpenID Connect (OIDC)

OAuth et OpenID Connect (OIDC) sont des protocoles standardisés qui jouent des rôles complémentaires dans les architectures de sécurité des applications. 

- **OAuth** est utilisé pour gérer l'autorisation, permettant à une application d'accéder à des ressources protégées au nom d'un utilisateur. 
- **OIDC** ajoute une couche d'authentification, permettant de vérifier l'identité d'un utilisateur de manière sécurisée.

---

## OAuth : Pour l’autorisation

OAuth est conçu pour permettre à une application d'agir au nom d'un utilisateur **sans connaître directement ses identifiants**. Le client (application) obtient un **jeton d'accès**, qui est utilisé pour accéder aux ressources de l'utilisateur hébergées sur un serveur distant.

### Exemple de cas d'utilisation :
1. Vous connectez une application tierce à votre Google Drive pour lire vos fichiers.
2. Vous donnez explicitement à l'application l'autorisation d'accéder à vos fichiers, **sans partager vos identifiants Google**.
3. L'application reçoit un jeton d'accès limité, lui permettant d'effectuer les actions autorisées.

**Remarque** : OAuth ne garantit pas que l'application connaisse votre identité — son seul but est de fournir un moyen sécurisé d’accéder à des ressources.

---

## OIDC : Pour l’authentification

OIDC ajoute une couche d'authentification au protocole OAuth. En plus d'un jeton d'accès, il fournit un **ID Token**. Ce jeton est un objet signé numériquement (JSON Web Token - JWT) contenant des informations sur l'utilisateur, comme son nom, son email et un identifiant unique.

**OIDC** permet donc de répondre à la question : *"Qui est l'utilisateur connecté ?"*, en toute sécurité, en fournissant des informations vérifiées par un serveur d'identité.

---

## Synthèse

| **Aspect**               | **OAuth**                     | **OIDC**                      |
|--------------------------|-------------------------------|-------------------------------|
| **Objectif principal**    | Autoriser l'accès à des ressources protégées. | Authentifier un utilisateur. |
| **Focus**                | Autorisation (Qu'est-ce que le client peut faire ?) | Authentification (Qui est connecté ?) |
| **Jetons utilisés**       | Jeton d'accès (Access Token). | ID Token (JWT) + Jeton d'accès. |
| **Exemple d'utilisation** | Donner accès à une application tierce à vos fichiers. | Se connecter à une application avec Google. |