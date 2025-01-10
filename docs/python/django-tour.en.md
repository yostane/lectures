# Django Tour

Django is a framework for developing web applications or REST APIs.

In the following, we summarize the [Django getting started tutorial](https://www.djangoproject.com/start/).

## Recommended VS Code Extensions

Please read the configuration instructions for each extension:

- Template formatter and linter: [monosans.djlint](https://marketplace.visualstudio.com/items?itemName=monosans.djlint)
- Template syntax highlighting: [batisteo.vscode-django](https://marketplace.visualstudio.com/items?itemName=batisteo.vscode-django)

## Creating and Starting a Project

- Preferably, create a virtual environment: `python3 -m venv venv` or `python -m venv venv`
- Install the latest version of Django: `pip install Django==[version]` ([this page](https://www.djangoproject.com/download/) helps find the latest version)
- Verify the installation: `python -m django --version`
- Create a **Django project**: `django-admin startproject [project name]`
- Start the development server with `python manage.py runserver` and open the link displayed by the command output.
- Project structure:

```sh
mysite/
    manage.py # Project management script (do not modify this file)
    mysite/ # Project information and settings
        __init__.py # Allows Python to consider it as a module
        settings.py # Project settings
        urls.py # Routes managed by the project
        asgi.py # Entry point for ASGI servers
        wsgi.py # Entry point for WSGI servers
```

## Adding an Application

- A Django project contains several **applications**
- For Django, an **application** is a Python package that offers a set of functionalities (web pages, admin interface, REST API, middlewares, etc.)
    - Applications are meant to be autonomous and reusable in different projects.
- The project we just created already uses some applications. You can check them in `settings.py`
- Add a new application: `python manage.py startapp polls`. Check the content of the created folder.
- We will add a page. To do this, follow these steps:
    - Add a page in `views.py`

    ```py
    from django.http import HttpResponse

    def index(request):
        return HttpResponse("Hello, world. You're at the polls index.")
    ```

    - Associate a route with the page we just created in `urls.py` (`""` means the page will be associated with the **root of the application**)

    ```py
    from django.urls import path

    from . import views

    urlpatterns = [
        path("", views.index, name="index"),
    ]
    ```

    - Since we haven't defined the application's route within the project yet, we need to do it now by updating the `[project name]/urls.py` file

    ```py
    from django.contrib import admin
    from django.urls import include, path

    urlpatterns = [
        # the polls/ route uses the urls.py file from the polls folder (hence polls.urls)
        path("polls/", include("polls.urls")), 
        path("admin/", admin.site.urls),
    ]
    ```

- Open the page we just created using the URL: `[dev server URL]/[app path]`. In our case, it will be: `http://localhost:8000/polls/`
- _Exercise_: add a page `http://localhost:8000/polls/hello` that displays 'Hello World' in an `h1` tag

## Databases

- Django uses a **migrations** mechanism to track changes in the database structure over time
    - This system is very convenient for upgrading the production application's database without manually applying changes made during development.
    - It's similar to what Git does (tracking changes made to a file) which allows reconstructing the latest version of a file from its initial version by applying all changes made through different commits.
- In Django, it works in three phases:
    1. Define or update the models (equivalent to a table on the Django code side)
    1. Define the migration point from the current state of the models: `python manage.py makemigrations polls`
    1. Apply the migrations to the databases linked to the application: `python manage.py migrate`
- Django manages the migrations of applications registered in the `INSTALLED_APPS` list in the `settings.py` file.
- Since the pre-registered applications have already defined their models and migration points, we just need to apply them to the project's database: `python manage.py migrate`
- Check the content of the database (by default it's the `db.sqlite3` file)
    - 💡 It is possible to change the database in the `settings.py` file
- Next, we will add tables to the application we created earlier by following the three phases introduced above:
    1. Define the models in `[app folder]/models.py`

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

    1. In `settings.py`, add `"polls.apps.PollsConfig"` to the `INSTALLED_APPS` list. This allows us to use migrations. Define the migration point: `python manage.py makemigrations polls`. Monitor the console output.
        - To check what will be generated if we execute this migration later: `python manage.py sqlmigrate polls 0001`
    1. Apply the migrations to the database: `python manage.py migrate`

## Django Shell

- It is possible to test Django APIs and interact with our project from the terminal
- Run the command: `python manage.py shell` which opens an interactive Python prompt (displays results after each command) linked to our Django project.
- Execute the following commands one by one:

```py
from polls.models import Choice, Question

# Should display <QuerySet []> because the table is empty
Question.objects.all() 

from django.utils import timezone
q = Question(question_text="What's new?", pub_date=timezone.now())
q.save() # save to the database
q.id # should display 1
q.question_text
q.pub_date
q.question_text = "What's up?"
q.save()
# Should display <QuerySet [<Question: Question object (1)>]>
# Note the Question object (1) which is not very readable
Question.objects.all()
q.choice_set.create(choice_text= "Choice 1", votes = 2)
q.save()
```

- To improve the display of objects within our project, define the `__str__(self):` method in each model class and try calling `Question.objects.all()` again.

## Displaying Data in Web Pages

- This code displays questions and choices as bullet lists.

```py
def index(request):
    content = "<h1>Questions</h1>"
    content += "<ul>"
    for question in Question.objects.all():
        content += "<li>"
        content += f"{question.question_text} - {question.pub_date}. {question.choice_set.count()} choices"
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

!!! note "List Comprehension"

    This syntax allows generating a new list from an existing list.
    
    For example, `[x+1 for x in [1, 2, 3, 4]]` will generate the list `[1, 2, 3, 4, 5]`.
    Similarly, `[f"<li>{c.choice_text} / {c.votes}</li>" for c in question.choice_set.all()]` will generate a list of strings.

## Using a Template

- So far, the HTML of the views is hard-coded in the code
- The recommended technique is to do the processing in the code and delegate the display to a specific HTML file called a **template**
    - This model is called the **MVC** (Model View Controller) model
- Templates should be placed in `[app folder]/templates`

```py "to be placed in views.py"
from django.shortcuts import render

def showQuestionsWithTemplate(request):
    context = {"questions": Question.objects.all()}
    return render(request, "questions.html", context)

# add path("questions", views.showQuestionsWithTemplate, name="questions"), in urls.py
```

```html "to be placed in templates/questions.html"

```

## The Admin Application

- The **admin** application offers a basic CRUD web interface
- Accessible from `[server URL]/admin`. It provides a login page
    - Users are managed via the auth application. We will come back to this later.
- Add a superuser (like a root in Linux) `python manage.py createsuperuser`
- Log in to the admin interface with the newly created account and perform some operations
- The tables offered by the admin interface come from the **auth** application which registered the ability to edit its tables from the admin interface
- Let's do the same with the tables of the application we created. In the `[app]/admin.py` file, add a line `admin.site.register([model(s)])`
    - In our case, it will be: `admin.site.register([Question, Choice])`

## Using a Component Library

### Material UI

It seems complicated at first

- Download the library: Add it to `requirements.txt` and rerun `pip install -r requirements.txt`
- Activate the library: in `settings.py` add this app just before our own apps `"theme_material_kit"`
- Apply the migration as we added a new app `python manage.py migrate`
- Add the URLs provided by the app with the lowest priority: In the global `urls.py`, add `path("", include('theme_material_kit.urls'))`

### Bulma

- Follow the [official documentation](https://bulma.io/documentation/overview/start/)
- See an example of integration in the sample project
- Add Bulma styles to forms with [django-bulma-form-templates](https://pypi.org/project/django-bulma-form-templates/)

## Registration and Login Forms

- `django.contrib.auth.forms` offers predefined forms like `AuthenticationForm` and `UserCreationForm`
- [Custom template tags](https://docs.djangoproject.com/en/4.2/howto/custom-template-tags/) allow acting on the HTML rendering. This can be useful for inserting styles into forms before rendering them.

- [Tutorial](https://ordinarycoders.com/blog/article/django-user-register-login-logout)
- [Form templates](https://pypi.org/project/django-bulma-form-templates/)

## Resources

- [Different methods for managing environments](https://djangostars.com/blog/configuring-django-settings-best-practices/)
- [Managing environments with `django-environ`](https://django-environ.readthedocs.io/)
- [Using Django with Multiple Databases](https://dboostme.medium.com/using-django-with-multiple-databases-introduction-8f0ffb409995)
- [Deployment checklist](https://docs.djangoproject.com/en/4.2/howto/deployment/checklist/)
