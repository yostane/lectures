# Programmation distribuée

## Quelques définitions

- La programmation distribuée est une technique de programmation qui permet d'exécuter des tâches sur plusieurs ordinateurs ou nœuds en parallèle. Elle est utilisée pour traiter de gros volumes de données ou pour exécuter des calculs complexes de manière efficace.
- Un cluster est un ensemble de plusieurs ordinateurs ou nœuds qui travaillent ensemble pour exécuter des tâches. Dans le contexte de la programmation distribuée, un cluster est utilisé pour exécuter des tâches sur plusieurs ordinateurs en parallèle.
- Un [dataframe](https://en.wikipedia.org/wiki/Dataframe) est une structure de données qui permet de stocker des données tabulaires (lignes et colonnes où chaque colonne est identifiée par un nom). Il est similaire à une table dans une base de données ou à une feuille de calcul dans Excel. Dans le contexte de la programmation distribuée, les dataframes gèrent de gros volumes de données.

## Programmation distribuée vs d'autres concepts

- vs microservices:
    - microservices: une approche de conception où une application est divisée en plusieurs services plus petits qui peuvent être déployés indépendamment.
    - systèmes distribués: composés de plusieurs ordinateurs qui travaillent ensemble pour effectuer une tâche unique.
- vs parallélisme:
    - parallélisme: une technique de programmation qui consiste à exécuter plusieurs tâches simultanément.
    - programmation distribuée: une technique de programmation qui consiste à exécuter des tâches sur plusieurs ordinateurs.
- vs des outils non distribués comme pandas:
    - pandas: une bibliothèque Python pour l'analyse de données qui fonctionne sur un seul ordinateur.
    - programmation distribuée: permettent d'accomplir ce que fait pandas mais de façon distribuée (sur plusieurs ordinateurs), et donc permettent de traiter de plus gros volumes de données. Il faut noter que les traitements distribués ne concernent pas uniquement les données massives, mais aussi les traitements massifs (par exemple, le calcul de la valeur d'une fonction sur un très grand nombre de points).

Plusieurs technologies permettent de mettre en place des systèmes distribués. Les plus connues sont: Hadoop, Apache Spark, Apache Flink, Apache Storm, Apache Kafka, Apache Samza, Apache Beam, Google Cloud Dataflow, Amazon Kinesis, etc.

## Dask et Coiled

- [Dask](https://www.dask.org/) s'appuie sur pandas pour traiter de façon distribuée de gros volumes de données et propose en plus la possibilité de lancer des tâches parallèles.
- [Coiled](https://coiled.io/) est un service de calcul sur le cloud pour développeurs Python.

Dask a été créé par Matthew Rocklin qui est lui-même CEO de Coiled.

## Sources

- [What Are Distributed Systems?](https://www.splunk.com/en_us/blog/learn/distributed-systems.html)
- [The Top Distributed Data Processing Technologies: A Comprehensive Overview](https://medium.com/@singhal.ankur8/the-top-distributed-data-processing-technologies-a-comprehensive-overview-712756db3242)
- [Qu'est-ce qu'un système distribué ?](https://www.atlassian.com/fr/microservices/microservices-architecture/distributed-architecture)
- [Ingénierie de la fouille et de la visualisation de données massives (RCP216)](https://cedric.cnam.fr/vertigo/Cours/RCP216/index.html)
