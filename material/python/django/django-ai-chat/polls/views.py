from django.shortcuts import render
from django.http import HttpResponse
from polls.models import Choice, Question


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


def showQuestionsWithTemplate(request):
    context = {"questions": Question.objects.all()}
    return render(request, "questions.html", context)


def test(request):
    return HttpResponse("<h1 style='color:red'>Tu peux pas test<h1>")
