from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User


class PromptForm(forms.Form):
    # doit être pareil quel l'attribut name de l'input
    query = forms.CharField(label="query", max_length=100)
