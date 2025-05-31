# Coiled

[Coiled](https://coiled.io/) est un service cloud qui permet, entre autres, de déployer des clusters Dask en quelques clics. Il est particulièrement adapté pour les utilisateurs de Jupyter et de pandas.

## Lien entre Dask et Coiled

Dask a été créé par Matthew Rocklin qui est lui-même CEO de Coiled.

## Démarrage rapide

- Créer un compte gratuit sur [Coiled](https://coiled.io/) et s'y connecter.
- Aller sur le [get started](https://cloud.coiled.io/get-started) et suivre les instructions.
- Pour la suite, on suppose que Coiled installé dans l'environnement virtuel et qu'on est connecté `coiled login`.
- Lancer un Hello world sur une VM avec cette commande `coiled run echo "Hello, world"`

## Quelques exemples

### Traitement des données NASA earthdata

Cet exemple pris du site [de Coiled](https://coiled.io/example/nasa-cloud-datasets) permet de montrer comment déléguer des traitement sur le Cloud. En effet, le décorateur `@coiled.function` permet de lancer une fonction sur un cluster Dask Coiled. Il est possible de spécifier le nombre de workers, la mémoire, etc.

Concrètement, cet exemple,  traiter 500Go de données de façon distribuée sur le Cloud et affiche ensuite le résultat sous forme d'un graphique en local.

- Créer un compte [urs.earthdata.nasa.gov](https://urs.earthdata.nasa.gov/)
- Véerifier qu'on est bien connecté à Coiled avec la commande `coiled login`
- Installer les dépendances suivantes dans l'environnement virtuel :

    ```sh
    pip install coiled earthaccess xarray numpy matplotlib netcdf4 h5netcdf
    ```

- Lancer le script suivant :

    ```py
    --8<--
    distrib/dask-coiled/nasa_earth.py
    --8<--
    ```

### Traitement des données Uber et Lyft

A priori, il faut lier son compte à AWS pour accéder au dataset.

```py
--8<--
distrib/dask-coiled/coiled_uber_lyft.py
--8<--
```

## Notebooks sur le cloud

Les notebooks Coiled sont un moyen pratique pour exécuter des notebooks Jupyter sur le cloud. Ils sont basés sur JupyterLab et permettent de faire tout ce qu'on peut faire en local mais avec la puissance de calcul du cloud. On peut meême utiliser PyPark après avoir installé Java (par exemple un `conda install openjdk=21`) et la librairie `pyspark` avec un `pip install pyspark`.
