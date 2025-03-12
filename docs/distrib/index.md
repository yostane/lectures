# Programmation distribuée

- vs microservices:
    - microservices: une approche de conception où une application est divisée en plusieurs services plus petits qui peuvent être déployés indépendamment.
    - systèmes distribués: composés de plusieurs ordinateurs qui travaillent ensemble pour effectuer une tâche unique.
- vs parallélisme:
    - parallélisme: une technique de programmation qui consiste à exécuter plusieurs tâches simultanément.
    - programmation distribuée: une technique de programmation qui consiste à exécuter des tâches sur plusieurs ordinateurs.

Plusieurs technologies permettent de mettre en place des systèmes distribués. Les plus connues sont: Hadoop, Apache Spark, Apache Flink, Apache Storm, Apache Kafka, Apache Samza, Apache Beam, Google Cloud Dataflow, Amazon Kinesis, etc.

## Apache Spark

- [Site officiel](https://spark.apache.org/)
- [Suivre le tutoriel get-started](https://spark.apache.org/docs/latest/quick-start.html)
- Python
    - [pyspark tutorial sparkbyexamples.com](https://sparkbyexamples.com/pyspark-tutorial/)
    - [Tutoriel Pyspark : Débuter avec Pyspark](https://www.datacamp.com/fr/tutorial/pyspark-tutorial-getting-started-with-pyspark)
    - [Pyspark tutorial](https://www.tutorialspoint.com/pyspark/index.htm)
- Scala
    - [Apache Spark Tutorial](https://lintool.github.io/SparkTutorial/)
    - [Tutorial on tutorialspoint](https://www.tutorialspoint.com/apache_spark/index.htm)
- [Plateforme Databricks](https://docs.databricks.com/aws/en/spark)

```pwsh
# Lancement de spark-master
spark-class org.apache.spark.deploy.master.Master
# Lancement de spark-worker
spark-class org.apache.spark.deploy.worker.Worker [url du master]
# Soumettre un job écrit en Python
spark-submit --master [url du master] SimpleApp.py
```

## Exercices

- Python
    - [areibman/pyspark_exercises](https://github.com/areibman/pyspark_exercises)
- Scala
    - [jaceklaskowski spark-workshop](https://jaceklaskowski.github.io/spark-workshop/exercises/)

## Sources

- [What Are Distributed Systems?](https://www.splunk.com/en_us/blog/learn/distributed-systems.html)
- [The Top Distributed Data Processing Technologies: A Comprehensive Overview](https://medium.com/@singhal.ankur8/the-top-distributed-data-processing-technologies-a-comprehensive-overview-712756db3242)
- [Qu'est-ce qu'un système distribué ?](https://www.atlassian.com/fr/microservices/microservices-architecture/distributed-architecture)
