# Exercices Pandas et Pyplot

## Série 1

Réaliser cet exercice sur le dataset **titanic.csv**.

1. Calculer le nombre de survivants et de morts.
1. Calculer le pourcentage de survivants.
1. Calculer le pourcentage de survivants par classe.
1. Calculer le pourcentage de survivants par sexe.
1. Calculer le nombre de passagers dont l'âge est supérieur à la moyenne.
1. Donner le nom du passager qui a payé le plus cher son billet.
1. Donner le nom du passager le plus âgé.
1. Donner le nom du passager le plus jeune.
1. La personne qui le nom complet le plus long.
1. Le nom de la personne la plus âgée qui a survécu.

## Série 2

Réaliser cet exercice sur le dataset **titanic.csv**.

1. Afficher l'histogramme du nombre d'hommes et de femmes.
1. Analyser la répartition des ages des passagers en utilisant les graphiques suivants:
    - Histogramme des ages des passagers par tranche (utiliser les tranches par défaut de pandas).
    - Boxplot de la répartition des ages des passagers.
1. Analyser le lien entre la survie et le sexe en utilisant les graphiques suivants:
    - Histogramme du pourcentage de survivants par sexe.
    - Boxplot de la répartition des ages des survivants par sexe.
    - Interpréter les résultats.
1. Analyser le lien entre la survie et la classe du passager en utilisant les graphiques suivants:
    - Histogramme du pourcentage de survivants par classe.
    - Boxplot de la répartition des ages des survivants par classe.
    - Interpréter les résultats.

## Série 3 (Streamlit)

1. Proposer une application Streamlit qui permet de visualiser les données du dataset **titanic.csv** en affichant les informations et contrôles suivants:
    - Un `multiselect` qui permet de choisir le sexe (un des deux ou les deux).
    - Un `toggle` qui permet de changer l'unité de la monnaie (dollar ou euro).
    - Somme totale des billets (total de la colonne Fare).
    - Graphique en barre de la somme totale par classe.
1. Proposer une application Streamlit qui permet de visualiser les données du dataset **air_quality_no20.csv**. Cette application doit afficher les informations et contrôles suivants:
    - Un `selectbox` qui permet de choisir la station de mesure.
    - Sélection de la période de mesure (par exemple avec deux `selectbox` pour choisir la date de début et de fin).
    - Un graphique en courbe qui affiche la mesure de la station sélectionnée pour la période donnée.
