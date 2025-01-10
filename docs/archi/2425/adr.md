# Les ADR

## Définitions
Un **AD** (Architectural Decision) est un choix de design justifié qui répond à un besoin fonctionnel ou non qui, dans l'architecture du projet est très important.

Un **ADR** (Architectural Decision Records) sert à expliquer le raisonnement derrière un AD. Il explique pourquoi le choix a été fait, quelles sont les raisons, les intérêts ou non et les conséquences de ce choix sur le projet.

Le but de l'ADR va donc être de documenter cette décision, et ainsi de montrer que toute l'équipe a accepté ce choix.

L'ensemble des ADR constitue un __decision log__. 

Ce decision log va être stocké et écrit en Markdown dans le même repo que le code, afin d'avoir une proximité entre les choix d'architectures et le code pour les équipes de développement.

L'intérêt d'un ADR est qu'il ne faut pas forcément énormément de connaissances en architecture logicielle, il est possible d'expliquer simplement la décision sans avoir de termes techniques. Evidemment, les personnes plus expérimentées vont quand même pouvoir écrire un ADR plus complet s'ils le souhaitent.

## Comment écrire un ADR?

Un template d'ADR est souvent basé sur la même structure : 

**Contexte - Décision - Conséquences**

* Le contexte décrit les circonstances quelconques, que ce soit technique, politique, sociales ou purement pour le business qui influence les décisions dans le design du projet.

* La décision explique brièvement le choix qui a été fait pour répondre au contexte, en donnant ou non la liste de choix qui ont été écartés.

* Enfin, on expliquera les conséquences de ce choix, qu'elles soient positives ou négatives, et les prédictions qui suivront ce choix.

### Exemple 1 : 

Imaginons une situation : 

Nous avons une équipe de développeurs qui doivent rendre une application web dans des délais très faibles. Ils doivent faire un choix de framework afin de pouvoir rendre leur application dans les délais.

Leur ADR va ressembler à :

* Dans le cadre d'un projet pour un client, nous devons créer une application web, mais nous rencontrons des problèmes dans les délais. 

* Nous avons décidé d'utiliser le framework Angular, en écartant les framework Vue et Next 
  
* Afin de pouvoir rendre rapidement notre application, en ayant des fonctionnalités comme l'architecture MVC et le MEAN stack, en acceptant de futurs problèmes de mises à jours de versions ou encore le fait que le contenu soit souvent client-side.

### Exemple 2 : 

Si on continue dans ce projet, peut-être que le choix de BDD avec MongoDB de base n'est pas le meilleur, surtout que le client souhaite stocker des données qui sont relatives entre elles.

Nous aurons donc un ADR plus simple.

* Dans le cadre du projet pour le même client, nous devons choisir une BDD, en sachant que le client veut stocker des données qui sont en relations entre elles.

* Nous avons décidé d'utiliser PostgresQL
  
* Car cela permet de gérer des données relationnelles et est très stable, en acceptant un manque de scalabilité horizontale et de devoir éventuellement sharder la base de données.