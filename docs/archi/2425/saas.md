# Le modèle SAAS



Le **Software as a Service (SaaS)** est un modèle de distribution de logiciels où les applications sont hébergées par un fournisseur de services et accessibles aux utilisateurs via Internet. Cela a pour but d'eviter aux clients d'installer et de maintenir des logiciels sur leurs propres serveurs ou appareils, simplifiant ainsi la gestion et réduisant les coûts liés à l'infrastructure.



Le SaaS est fait partie du **cloud computing**. Celui-ci comprend trois modèles de services :

- **Infrastructure as a Service (IaaS)** : Fournit des ressources informatiques virtualisées (serveurs, stockage, réseaux) sur Internet.
- **Platform as a Service (PaaS)** : Offre une plateforme complète pour le développement, le déploiement et la gestion d'applications sans se soucier de l'infrastructure.
- **Software as a Service (SaaS)** : Propose des applications logicielles complètes accessibles via Internet, sans nécessiter d'installation locale.

![IaaS, PaaS, SaaS Diagram](https://www.redhat.com/rhdc/managed-files/styles/wysiwyg_full_width/private/iaas-paas-saas-diagram4-1638x1046_0.png.webp?itok=tK7XWtcK)

---
### Le modèle économique
Les applications SaaS reposent majoritairement sur des modèles de souscription. Contrairement à une licence perpétuelle, ce modèle de distribution logicielle relie chaque compte à une souscription qui garantit l'accès au SaaS pendant une période donnée, généralement sur une base annuelle ou mensuelle.  

  
 

Generalement les entreprises choisissent  l'un des deux modèles de déploiement suivant : 

- Dans leur propre datacenter
- Ou via un fournisseur de services cloud public (par exemple, AWS, Azure ou IBM Cloud) qui s'occupe de la gestion de l'environnement cloud sur lequel la solution SaaS est hébergée. 

--- 

### L'architecture générale du SaaS : Multi-tenant (Multi-locataire)

Dans une architecture multi-tenant, une seule instance de l'application sert à plusieurs clients. Chaque client partage les mêmes ressources, mais les données et les configurations sont isolées les unes des autres pour garantir la confidentialité et la sécurité .

L'utilisateur loue donc l'infrastructure peut y accéder au moyen d'une API ou d'un tableau de bord. 

- **Partage des ressources** : Optimise l'utilisation des ressources en répartissant les coûts entre les locataires.
- **Isolation des données** : Les données de chaque client sont séparées logiquement pour éviter tout accès non autorisé.

![multitenant](https://learn.microsoft.com/fr-fr/azure/architecture/guide/saas-multitenant-solution-architecture/images/saas-business-model.png)



---

## Exemples d'architecture SaaS
### Google Workspace

- Fournit une suite complète d'outils de productivité tels que Gmail, Google Docs, Sheets, Slides et Google Meet, accessibles via le cloud.
- **Collaboration en temps réel** : Permet à plusieurs utilisateurs de travailler simultanément sur le même document, favorisant la collaboration et l'efficacité.
- **Architecture multi-locataire** : Les ressources sont partagées entre les utilisateurs tout en garantissant la sécurité et l'isolation des données de chaque client.
- **Écosystème intégré** : Offre une intégration transparente avec d'autres services Google et des applications tierces via des API et des extensions.
- **Sécurité et conformité** : Mise en œuvre de mesures de sécurité avancées, y compris l'authentification à deux facteurs, la gestion des appareils mobiles et le chiffrement des données, tout en respectant les normes de conformité internationales.
