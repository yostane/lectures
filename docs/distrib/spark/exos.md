# Exercices PySpark

1. Log filtering
    - Input data: a simplified log of a web server (i.e., a textual file). Each line of the file is associated with a URL request
    - Output: the lines containing the word "google". Store the output in a local folder, for simplicity

        ```logs
        # Input data
        66.249.69.97 --[24/Sep/2014:22:25:44  +0000]  "GET http://www.google.com/bot.html”
        66.249.69.97 --[24/Sep/2014:22:26:44  +0000]  "GET  http://www.google.com/how.html”
        66.249.69.97 --[24/Sep/2014:22:28:44 +0000] "GET http://dbdmg.polito.it/course.html”
        71.19.157.179 --[24/Sep/2014:22:30:12  +0000]  "GET http://www.google.com/faq.html”
        66.249.69.97 --[24/Sep/2014:31:28:44 +0000] "GET http://dbdmg.polito.it/thesis.html”

        # Output data
        66.249.69.97 --[24/Sep/2014:22:25:44  +0000]  "GET http://www.google.com/bot.html”
        66.249.69.97 --[24/Sep/2014:22:26:44  +0000]  "GET  http://www.google.com/how.html”
        71.19.157.179 --[24/Sep/2014:22:30:12  +0000]  "GET http://www.google.com/faq.html”
        ```

1. Log analysis
    - Input data: log of a web server (i.e., a textual file). Each line of the file is associated  with a URL request
    - Output: the list of distinct IP addresses associated with the connections to a googlepage (i.e., connections to URLs containing the term `www.google.com`). Store the output in a local folder, for simplicity

        ```logs
        #Input data
        
        66.249.69.97 --[24/Sep/2014:22:25:44  +0000]  "GET http://www.google.com/bot.html”
        66.249.69.97 --[24/Sep/2014:22:26:44  +0000]  "GET  http://www.google.com/how.html”
        66.249.69.97 --[24/Sep/2014:22:28:44 +0000] "GET http://dbdmg.polito.it/course.html”
        71.19.157.179 --[24/Sep/2014:22:30:12  +0000]  "GET http://www.google.com/faq.html”
        66.249.69.95 --[24/Sep/2014:31:28:44 +0000] "GET http://dbdmg.polito.it/thesis.html”
        66.249.69.97 --[24/Sep/2014:56:26:44  +0000]  "GET http://www.google.com/how.html”
        56.249.69.97 --[24/Sep/2014:56:26:44  +0000]  "GET http://www.google.com/how.html”

        # Output data
        66.249.69.97
        71.19.157.179
        56.249.69.97
        ```

1. Maximum value
    - Input data: a collection of (structured) textual csv files containing the daily value of PM10 for a set of sensors. Each line of the files has the following format: `sensorId,date,PM10  value (μg/m3)\n`
    - Output: report the maximum value of PM10. Print the result on the standard output

        ```logs
        #Input data
        
        sensorId,date,PM10  value (μg/m3)
        s1,2016-01-01,20.5
        s2,2016-01-01,30.1
        s1,2016-01-02,60.2
        s2,2016-01-02,20.4
        s1,2016-01-03,55.5
        s2,2016-01-03,52.5

        # Output data
        60.2
        ```

1. Top-k maximum values
    - Input data: a collection of (structured) textual csv files containing the daily value of PM10 for a set of sensors. Each line of the files has the following format:<br> `sensorId,date,PM10 value (μg/m3)\n`
    - Output: report the top-3 maximum values of PM10. Print the result  on the standard  output.

        ```logs
        #Input data
        
        sensorId,date,PM10  value (μg/m3)
        s1,2016-01-01,20.5
        s2,2016-01-01,30.1
        s1,2016-01-02,60.2
        s2,2016-01-02,20.4
        s1,2016-01-03,55.5
        s2,2016-01-03,52.5

        # Output data
        60.2
        ```

??? Solutions

    ```python title="log-filtering.py"
    --8<--
    distrib/exercices/log-filtering.py
    --8<--
    ```

    ```python title="log-analysis.py"
    --8<--
    distrib/exercices/log-analysis.py
    --8<--
    ```

## Exos supplémentaires

- Python
    - [Travaux pratiques - Introduction à Spark](https://cedric.cnam.fr/vertigo/Cours/RCP216/tpSparkPython.html#spark-concepts-de-base-avec-exemples)
    - [Marlowess/spark-exercises](https://github.com/Marlowess/spark-exercises) (vérifier les branches pour les version récentes de pyspark)
    - [Databricks Spark DF, SQL, ML Exercise](https://databricks-prod-cloudfront.cloud.databricks.com/public/4027ec902e239c93eaaa8714f173bcfc/6244269837918943/3546103630347710/4066658260255490/latest.html) - [Solutions](https://databricks-prod-cloudfront.cloud.databricks.com/public/4027ec902e239c93eaaa8714f173bcfc/1219081465903405/3466270665734845/5074805361045397/latest.html)
    - [areibman/pyspark_exercises](https://github.com/areibman/pyspark_exercises) (pas de solutions avec pyspark)
- Scala
    - [jaceklaskowski spark-workshop](https://jaceklaskowski.github.io/spark-workshop/exercises/)
    - [Travaux pratiques - Introduction à Spark et Scala](https://cedric.cnam.fr/vertigo/Cours/RCP216/tpSparkScala.html)
