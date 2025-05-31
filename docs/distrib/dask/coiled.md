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

```py
--8<--
distrib/dask-coiled/coiled_uber_lyft.py
--8<--
```

## Traitement des données NASA earthdata

Le décorateur `@coiled.function` permet de lancer une fonction sur un cluster Dask Coiled. Il est possible de spécifier le nombre de workers, la mémoire, etc.

- Créer un compte [urs.earthdata.nasa.gov](https://urs.earthdata.nasa.gov/)
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
