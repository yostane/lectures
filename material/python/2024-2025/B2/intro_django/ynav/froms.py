from django import forms

class QuestionForm(forms.Form):
    # doit être pareil quel l'attribut name de l'input
    question = forms.CharField(label="question", max_length=100)
    choice1 = forms.CharField(label="choice1", max_length=100)
    choice2 = forms.CharField(label="choice2", max_length=100)
    votes1 = forms.IntegerField(label="votes1")
    votes2 = forms.IntegerField(label="votes2")

class NameForm(forms.Form):
    name = forms.CharField(label="name", max_length=100, min_length=1)

class PakimanForm(forms.Form):
    name = forms.CharField(label="name", max_length=100, min_length=1)
    type = forms.CharField(label="type", max_length=100, min_length=1)