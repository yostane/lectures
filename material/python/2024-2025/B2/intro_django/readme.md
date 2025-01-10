# Django

## Exercices

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
1. Créer une page `/ynav/time` qui affiche l'heure côté serveur. Exemple: `Il est 12:00`.
    - Astuce: Utiliser la librairie `datetime` de Python.
    - Exemple:
    ```python
    import datetime
    t = f"Il est {datetime.datetime.now().strftime('%H:%M')}"
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
1. Créer une page qui affiche un formulaire avec un champ `name` et un bouton `submit`. Lorsque le formulaire est soumis, la page affiche `Hello <name>`. Exemple: `http://localhost:8000/ynav/nameform` affiche un formulaire avec un champ `name` et un bouton `submit`. Lorsque le formulaire est soumis avec le nom `John`, la page affiche `Hello John`. (astuce: créer une class `NameForm` qui hérite de `forms.Form` et ajouter un champ `name` de type `forms.CharField`).
1. Afficher une table de multiplication. Exemple: `http://localhost:8000/ynav/multiplication?n=5` affiche la table de multiplication de 5.
    ```txt
    5 x 1 = 5
    5 x 2 = 10
    ...
    5 x 10 = 50
    ```
1. Créer une table `Pakiman` avec les champs `name`, `type`, `level` (entier) et `attack` (entier). Créer une page qui permet d'ajouter des `Pakiman` à la base de données. Créer une page qui affiche tous les `Pakiman` de la base de données. Créer une page qui affiche les `Pakiman` dont le niveau est supérieur au query param passé dans la requête. Exemple: `http://localhost:8000/ynav/pakiman?level=5` affiche les `Pakiman` dont le niveau est supérieur à 5. 
    - Astuce: Utiliser `models.Model` pour définir le modèle `Pakiman`.