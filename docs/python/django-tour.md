# Django

Django est un Framework de développement de applications web ou d'APIs REST.

Dans ce qui suite, nous résumons le tutoriel de démarrage [proposé par Django](https://www.djangoproject.com/start/).

## Exensions VS Code recommandées

Veuillez lire les instructions de configuration de chaque extension:

- Formatteur et linteur de templates: [monosans.djlint](https://marketplace.visualstudio.com/items?itemName=monosans.djlint)
- Coloration syntaxique des templates: [batisteo.vscode-django](https://marketplace.visualstudio.com/items?itemName=batisteo.vscode-django)

## Tutoriel couvrant les bases

### Création et démarrage d'un projet

- De préférence, créer un environnement virtuel: `python3 -m venv venv` ou `python -m venv venv`
- Installer la dernière version de Django `pip install Django==[version]` ([cette page](https://www.djangoproject.com/download/) permet de trouver la dernière version)
- Vérifier que l'installation a réussi: `python -m django --version`
- Créer un **projet django**: `django-admin startproject [nom du projet]`
- Démarrer le serveur de développement avec `python manage.py runserver` et ouvrir le lien affiché par la sortie de la commande.
- Structure du projet

```sh
mysite/
    manage.py # Script de gestion du projet (fichier à ne pas modifier)
    mysite/ # Informations et paramètres du projet
        __init__.py # Permet d'être considéré par Python comme un module
        settings.py # Paramètres du projet
        urls.py # Les routes que le projet gère
        asgi.py # Point d'entée pour les serveurs de type ASGI
        wsgi.py # Point d'entée pour les serveurs de type WSGI
```

### Ajout d'une application

- Un projet Django contient plusieurs **applications**
- Pour Django, une **application** est un paquet Python qui proposer un ensemble de fonctionnalités (pages Web, Interface d'administration, API REST, Middlewares, etc.)
    - Les applications sont censées être autonomes et réutilisables dans différents projets.
- Le projet que vous venons de créer utilise déjà quelques applications. Vous pouvez les vérifier dans `settings.py`
- Ajouter une nouvelle application: `python manage.py startapp polls`. Consulter le contenu du dossier créé.
- Nous allons ajouter une page. Pour ce faire, suivons ces étapes:
    - Ajouter une page dans `views.py`

    ```py
    from django.http import HttpResponse


    def index(request):
        return HttpResponse("Hello, world. You're at the polls index.")
    ```

    - Associer une route à la page que nous venons de créer dans `urls.py` (`""` signifie que la page sera associée à la **racine de l'application**)

    ```py
    from django.urls import path

    from . import views

    urlpatterns = [
        path("", views.index, name="index"),
    ]
    ```

    - Comme nous n'avons pas encore défini la route de l'application au sein du projet, il faut le faire maintenant en mettant à jour le fichier `[nom du projet]/urls.py`

    ```py
    from django.contrib import admin
    from django.urls import include, path

    urlpatterns = [
        # la route polls/ utiliser le fichier urls.py du dossier polls (d'où le polls.urls)
        path("polls/", include("polls.urls")), 
        path("admin/", admin.site.urls),
    ]
    ```

- Ouvrir la page que nous venons de créer en utilisant l'url: `[url du servur de dev]/[chemon de l'app]`. Pour notre cas, ce sera: `http://localhost:8000/polls/`
- _Exercice_: ajouter une page `http://localhost:8000/polls/hello` qui affiche 'Hello World' dans une balise `h1`

### Bases de données

- Django utilise un mécanisme de **migrations** qui permet de suivre les évolutions de la structure la BDD dans le temps
    - Ce système est très pratique pour permettre des mises à niveau de la BDD de l'application de production sans avoir à appliquer à la main les changement faits durant le développement.
    - C'est similaire à ce que fait Git (qui mémorise les changements faits sur un fichier) qui permet de reconstruire la dernière version d'un fichier en partant de sa version initiale et en appliquant tous les changement faits à travers les différents commits.
- Sur Django, cela fonctionne en trois phases:
    1. Définir ou mettre à jour les modèles (équivalent d'une table côté code Django)
    1. Définir le point de migration à partir de l'état actuel des modèles: `python manage.py makemigrations polls`
    1. Appliquer les migrations aux bases de données liées à l'application: `python manage.py migrate`
- Django sait gérer les migrations des application enregistrées dans la liste `INSTALLED_APPS` du fichier `settings.py`.
- Comme les applications pré-resneignées ont déjà défini leur modèles et points de migration, il ne reste qu'a les appliquer à la BDD du projet: `python manage.py migrate`
- Vérifier le contenu de la BDD (par défaut c'est le fichier `db.sqlite3`)
    - 💡 Il est possible de changer la BDD dans le fichier `settings.py`
- Dans la suite, nous allons ajouter des tables dans l'application que nous avons créé précédemment en suivant donc les trois phases introduites plus haut:
    1. Définir les modèles dans `[dossier de l'app]/models.py`

        ```py
        from django.db import models


        class Question(models.Model):
            question_text = models.CharField(max_length=200)
            pub_date = models.DateTimeField("date published")


        class Choice(models.Model):
            question = models.ForeignKey(Question, on_delete=models.CASCADE)
            choice_text = models.CharField(max_length=200)
            votes = models.IntegerField(default=0)
        ```

    1. Dans settings.py, ajouter `"polls.apps.PollsConfig"` dans la liste `INSTALLTED_APPS`. Ceci nous permet d'utiliser les migrations. Définissons le points de migration: `python manage.py makemigrations polls`. Surveiller la sortie de la console.
        - Pour vérifier qui sera généré si on exécute cette migration par la suite: `python manage.py sqlmigrate polls 0001`
    1. Appliquer les migrations à la BDD: `python manage.py migrate`

### Shell Django

- Il est possible de tester les API de Django et agir sur notre projet depuis le terminal
- Lancer la commande : `python manage.py shell` qui ouvre un invite interactif (affiche les résultat après chaque commande) Python lié à notre projet Django.
- Exécuter les commandes suivantes une par une:

```py
from polls.models import Choice, Question

# Devrait afficher <QuerySet []> car la table est vide
Question.objects.all() 

from django.utils import timezone
q = Question(question_text="What's new?", pub_date=timezone.now())
q.save() # enregistrer dans la BDD
q.id # devrait afficher 1
q.question_text
q.pub_date
q.question_text = "What's up?"
q.save()
# Devrait affichier <QuerySet [<Question: Question object (1)>]>
# Noter le Question object (1) qui n'est pas très lisible
Question.objects.all()
q.choice_set.create(choice_text= "Choix 1", votes = 2)
q.save()
```

- Afin d'améliorer l'affichage des objets au sein de notre projet, définir la méthode `__str__(self):` dans chacune des classes modèles et réessayer d'appeler un `Question.objects.all()`.

### Affichage des données dans des pages web

- Ce code permet d'afficher les questions et les choix sous forme de listes à puces.

```py
def index(request):
    content = "<h1>Questions</h1>"
    content += "<ul>"
    for question in Question.objects.all():
        content += "<li>"
        content += f"{question.question_text} - {question.pub_date}. {question.choice_set.count()} choix"
        content += "<ul>"
        str_choices = [
            f"<li>{c.choice_text} / {c.votes}</li>" for c in question.choice_set.all()
        ]
        content += "".join(str_choices)
        content += "</ul>"
        content += "</li>"
    content += "</ul>"
    return HttpResponse(content)
```

!!! note "Compréhension de listes"

    Cette Syntaxe permet de générer une nouvelle liste à partir d'une liste existante.
    
    Par exemple `[x+1 for x in [1, 2, 3, 4]]` générera la liste `[1, 2, 3, 4, 5]`.
    Sur le même principe, `[f"<li>{c.choice_text} / {c.votes}</li>" for c in question.choice_set.all()]` gérera une liste de chaines de caractères.

### Utilisation d'un template

- Jusqu'à présent, le HTML des vues est codé _"en dur"_ dans le code
- La technique recommandée est de faire les traitement dans le code et déléguer l'affichage à un fichier HTML particulier qu'on appelle **"template"**
    - Ce modèle est appelé modèle **MVC** (Model View Controller)
- Les templates doivent être placés dans `[dossier de l'app]/templates`

```py title="à mettre dans views.py"
from django.shortcuts import render

def showQuestionsWithTemplate(request):
    context = {"questions": Question.objects.all()}
    return render(request, "questions.html", context)

# ajouter path("questions", views.showQuestionsWithTemplate, name="questions"), dans urls.py
```

```html title="à mettre dans templates/questions.html"
--8<--
django/django-ai-chat/polls/templates/questions.html
--8<--
```

### Exercices

1. Ajouter une page http://localhost:8000/ynav/hello qui affiche 'Hello World' dans une balise h1
1. Ajouter une page http://localhost:8000/ynav/user/profile qui répond avec un html complet.
    - Exemple de contenu:
    ```html
    <html>
    <head>
        <title>Profile</title>
    </head>
    <body>
        <h1>Profile</h1>
        <p>First Name: John</p>
        <p>Last Name: Doe</p>
    </body>
    </html>
    ```
    - Astuce: Utiliser la fonction `HttpResponse` de Django et `"""` pour mettre du texte multi-lignes.
        - Exemple
        ```python
        from django.http import HttpResponse

        def profile(request):
            return HttpResponse("""<html>
            <head>
                <title>Profile</title>
            </head>
            <body>
                <h1>Profile</h1>
                <p>First Name: John</p>
                <p>Last Name: Doe</p>
            </body>
            </html>""")
        ```
1. Créer une page qui affiche l'heure côté serveur. Exemple: `Il est 12:00`.
    - Astuce: Utiliser la librairie `datetime` de Python.
    - Exemple:
    ```python
    import datetime
    t = f"Il est {datetime.now().strftime('%H:%M')}"
    ```
1. Créer une page qui utilise un template pour afficher la valeur du query param p. Exemple: `http://localhost:8000/ynav/query?p=hello` affiche `hello`.
    - Astuce: Utiliser `request.GET.get('p')` pour récupérer la valeur du paramètre p.
    - Exemple:
    ```python
    def query(request):
        p = request.GET.get('p')
        return render(request, 'query.html', {'p': p})
    ```
1. Créer une page qui utiliser un template pour afficher le profil de l'utilisateur avec les valeurs des query params `first_name` et `last_name`. Exemple: `http://localhost:8000/ynav/query/profile?first_name=John&last_name=Doe` affiche John Doe dans la page.
1. Créer une page qui affiche tous entiers compris entre un mix et un max passés en query params. Exemple: `http://localhost:8000/ynav/query/range?min=1&max=5` affiche `1 2 3 4 5`.
    - Afficher les entiers dans un liste à puce (`<ul>`).
1. Créer une page qui affiche un formulaire avec un champ `name` et un bouton `submit`. Lorsque le formulaire est soumis, la page affiche `Hello <name>`. Exemple: `http://localhost:8000/ynav/form` affiche un formulaire avec un champ `name` et un bouton `submit`. Lorsque le formulaire est soumis avec le nom `John`, la page affiche `Hello John`. (astuce: créer une class `NameForm` qui hérite de `forms.Form` et ajouter un champ `name` de type `forms.CharField`).
1. Afficher une table de multiplication. Exemple: `http://localhost:8000/ynav/multiplication?n=5` affiche la table de multiplication de 5.
    ```txt
    5 x 1 = 5
    5 x 2 = 10
    ...
    5 x 10 = 50
    ```
1. Créer une table `Pakiman` avec les champs `name`, `type`, `level` (entier) et `attack` (entier). Créer une page qui permet d'ajouter des `Pakiman` à la base de données. Créer une page qui affiche tous les `Pakiman` de la base de données. Créer une page qui affiche les `Pakiman` dont le niveau est supérieur au query param passé dans la requête. Exemple: `http://localhost:8000/ynav/pakiman?level=5` affiche les `Pakiman` dont le niveau est supérieur à 5. 
    - Astuce: Utiliser `models.Model` pour définir le modèle `Pakiman`.

## L'application admin

- L'application **admin** propose une interface web basique de type CRUD
- Accessible depuis `[URL du serveur]/admin`. Elle propose une page de connexion
    - Les utilisateurs sont gérés via l'application auth. On y reviendra plus tard.
- Ajoutons un super utilisateur (comme un root dans Linux) `python manage.py createsuperuser`
- Se connecter à l'interface d'admin avec le compte nouvellement créé et faire quelques manipulations
- Les tables proposées par l'interface d'admin proviennent de l'application **auth** qui a enregistré la possibilité d'éditer ses tables depuis l'interface d'admin
- Faisons pareil avec les tables de l'application que nous avons créé. Dans le fichier `[app]/admin.py` ajouter une ligne `admin.site.register([modèle(s)])`
    - Pour notre cas ce sera: `admin.site.register([Question, Choice])`

## Utilisation d'une librairie de composants

### Material UI

ça semble compliqué à priori

- Télécharger la librairie: Ajouter dans `requirements.txt`  et relancer un `pip install -r requirements.txt`
- Activer la librairie: dans `settings.py` ajouter cette app juste avant nos propres apps `"theme_material_kit"`
- Appliquer la migration comme on a ajouté une nouvelle app `pythom manage.py migrate`
- Ajout des urls proposées par l'app en dernière priorité: Dans le `urls.py` global, ajouter `path("", include('theme_material_kit.urls'))`

### Bulma

- Suivre la [doc officielle](https://bulma.io/documentation/overview/start/)
- Voir exemple d'intégration dans le projet d'exemple
- Ajouter les styles bulma dans les formulaires avec [django-bulma-form-templates](https://pypi.org/project/django-bulma-form-templates/)

## Formulaires d'enregistrement et de connexion

- `django.contrib.auth.forms` propose des formulaires prédéfinis comme les: `AuthenticationForm et UserCreationForm`
- [Les custom template tags](https://docs.djangoproject.com/en/4.2/howto/custom-template-tags/) permettent d'agir sur le rendu html. Cela peut être utile pour insérer des styles dans les formulaires avant d'en faire le rendu.

- [tuto](https://ordinarycoders.com/blog/article/django-user-register-login-logout)
- [Templates de formulaires](https://pypi.org/project/django-bulma-form-templates/)

## Ressources

- [Différentes méthodes pour gérer les environnements](https://djangostars.com/blog/configuring-django-settings-best-practices/)
- [Gestion des environnements avec `django-environ`](https://django-environ.readthedocs.io/)
- [Using Django with Multiple Databases](https://dboostme.medium.com/using-django-with-multiple-databases-introduction-8f0ffb409995)
- [Checklist de déploiement](https://docs.djangoproject.com/en/4.2/howto/deployment/checklist/)
