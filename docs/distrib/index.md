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
    - [UrbanInstitute/pyspark-tutorials](https://github.com/UrbanInstitute/pyspark-tutorials)
- Scala
    - [Apache Spark Tutorial](https://lintool.github.io/SparkTutorial/)
    - [Tutorial on tutorialspoint](https://www.tutorialspoint.com/apache_spark/index.htm)
- Java
    - [Apache Spark in Practice](https://medium.com/cloudnesil/apache-spark-in-practice-84704bc8a3a)
- [Tuto sparkUI](https://medium.com/@suffyan.asad1/beginners-guide-to-spark-ui-how-to-monitor-and-analyze-spark-jobs-b2ada58a85f7)
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
    - [Travaux pratiques - Introduction à Spark](https://cedric.cnam.fr/vertigo/Cours/RCP216/tpSparkPython.html#spark-concepts-de-base-avec-exemples)
    - [Marlowess/spark-exercises](https://github.com/Marlowess/spark-exercises) (vérifier les branches pour les version récentes de pyspark)
    - [Databricks Spark DF, SQL, ML Exercise](https://databricks-prod-cloudfront.cloud.databricks.com/public/4027ec902e239c93eaaa8714f173bcfc/6244269837918943/3546103630347710/4066658260255490/latest.html) - [Solutions](https://databricks-prod-cloudfront.cloud.databricks.com/public/4027ec902e239c93eaaa8714f173bcfc/1219081465903405/3466270665734845/5074805361045397/latest.html)
    - [areibman/pyspark_exercises](https://github.com/areibman/pyspark_exercises) (pas de solutions avec pyspark)
- Scala
    - [jaceklaskowski spark-workshop](https://jaceklaskowski.github.io/spark-workshop/exercises/)
    - [Travaux pratiques - Introduction à Spark et Scala](https://cedric.cnam.fr/vertigo/Cours/RCP216/tpSparkScala.html)

## Sources

- [What Are Distributed Systems?](https://www.splunk.com/en_us/blog/learn/distributed-systems.html)
- [The Top Distributed Data Processing Technologies: A Comprehensive Overview](https://medium.com/@singhal.ankur8/the-top-distributed-data-processing-technologies-a-comprehensive-overview-712756db3242)
- [Qu'est-ce qu'un système distribué ?](https://www.atlassian.com/fr/microservices/microservices-architecture/distributed-architecture)
- [Ingénierie de la fouille et de la visualisation de données massives (RCP216)](https://cedric.cnam.fr/vertigo/Cours/RCP216/index.html)
