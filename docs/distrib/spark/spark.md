# Apache Spark

Apache Spark est un moteur de traitement de données massives open source, conçu pour traiter de grandes quantités de données de manière distribuée. Il est particulièrement adapté pour les tâches d'analyse de données, de machine learning et de traitement en temps réel. Il est utilisable avec plusieurs langages de programmation, notamment Python, Scala et Java.

## Démarrage rapide

[Suivre le tutoriel get-started](https://spark.apache.org/docs/latest/quick-start.html)

## Liens

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

## Commandes utiles

```pwsh
# Lancement de spark-master
spark-class org.apache.spark.deploy.master.Master
# Lancement de spark-worker
spark-class org.apache.spark.deploy.worker.Worker [url du master]
# Soumettre un job écrit en Python
spark-submit --master [url du master] SimpleApp.py
```
