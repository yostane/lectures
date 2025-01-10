from django.shortcuts import render, redirect
from django.http import HttpResponse, HttpRequest
from django.template import loader
from django.contrib.auth.models import User
from django.contrib.auth import login, authenticate, logout
from django.contrib.auth.forms import AuthenticationForm, UserCreationForm
from .forms import PromptForm
from .models import Prompt
from .helper import ask_model
from django.contrib.auth.decorators import login_required


# Create your views here.
def index(request):
    template = loader.get_template("index.html")
    context = {"prompts": Prompt.objects.all()}
    return HttpResponse(template.render(context, request))


@login_required(login_url="login")
def show_query_form(request):
    return render(request, "prompt-input.html")


@login_required(login_url="login")
def show_chat_view(request: HttpRequest) -> HttpResponse:
    # Process the form
    if request.method == "POST":
        form = PromptForm(request.POST)
        if form.is_valid():
            user = User.objects.all()[1]
            reply = ask_model(form.cleaned_data["query"])
            user.prompt_set.create(query=form.cleaned_data["query"], reply=reply)
            user.save()
    # Load the prompts of the current user and add it to the response
    user = User.objects.all()[1]
    data = {"prompts": user.prompt_set.all(), "prompt_form": PromptForm()}
    return render(request, "ai-chat.html", data)


def process_query_form(request):
    form = PromptForm(request.POST)
    if not form.is_valid():
        return HttpResponse(f"<h1>Invalid</h1>")
    user = User.objects.all()[1]
    user.prompt_set.create(query=form.cleaned_data["query"], reply="réponse à la main")
    user.save()
    return HttpResponse(f"<h1>The query was: {form.cleaned_data['query']}</h1>")


def show_material_demo(request: HttpRequest) -> HttpResponse:
    user = User.objects.all()[1]
    data = {"prompts": user.prompt_set.all()}
    return render(request, "material-demo.html", data)


@login_required(login_url="login")
def show_bulma_demo(request: HttpRequest) -> HttpResponse:
    user = request.user
    if request.method == "POST":
        form = PromptForm(request.POST)
        if form.is_valid():
            reply = ask_model(form.cleaned_data["query"])
            user.prompt_set.create(query=form.cleaned_data["query"], reply=reply)
            user.save()
    elif request.GET.get("load_id") != None:
        pass
    elif request.GET.get("del_id") != None:
        Prompt.objects.get(id=request.GET.get("del_id")).delete()
    # Load the prompts of the current user and add it to the response
    data = {"prompts": user.prompt_set.all(), "prompt_form": PromptForm()}
    return render(request, "bulma-demo.html", data)


def register_request(request: HttpRequest) -> HttpResponse:
    form = None
    if request.method == "POST":
        form = UserCreationForm(request.POST)
        if form.is_valid():
            # sauvegarde en bdd
            user = form.save()
            # création du user dans la session HTTP
            login(request, user)
            return redirect("bulma-demo")
    else:
        form = UserCreationForm()
    return render(
        request,
        "auth/register.html",
        {"register_form": form},
    )


def login_request(request: HttpRequest) -> HttpResponse:
    if request.method == "POST":
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            username = form.cleaned_data.get("username")
            password = form.cleaned_data.get("password")
            user = authenticate(username=username, password=password)
            if user is not None:
                login(request, user)
                return (
                    redirect(request.GET.get("next"))
                    if request.GET.get("next") != None
                    else redirect("bulma-demo")
                )
    form = AuthenticationForm()
    return render(
        request,
        "auth/login.html",
        {"login_form": form},
    )


def logout_request(request: HttpRequest) -> HttpResponse:
    logout(request)
    return redirect("bulma-demo")
