# Coiled

[Coiled](https://coiled.io/) est un service cloud qui permet de déployer des clusters Dask en quelques clics. Il est particulièrement adapté pour les utilisateurs de Jupyter et de pandas.

## Démarrage

- Créer un compte gratuit sur [Coiled](https://coiled.io/) et s'y connecter.
- Aller sur le [get started](https://cloud.coiled.io/get-started) et suivre les instructions.
- Pour la suite, on suppose que coiled installé dans l'environnement virtuel et qu'on est connceté `coiled login`.
- Lancer un Hello world sur une VM avec cette commande `coiled run echo "Hello, world"`

```py
import coiled
import dask.dataframe as dd

cluster = coiled.Cluster(n_workers=10)
client = cluster.get_client()
print(client)

# Charger les données depuis S3 (il faut que votre compte Coiled ait accès à ce bucket S3)
df = dd.read_parquet("s3://coiled-data/uber/")
# How often do New Yorkers tip?
(df.tips != 0).mean().compute()
```
