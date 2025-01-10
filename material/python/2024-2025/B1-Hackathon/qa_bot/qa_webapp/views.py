from django.http import HttpRequest, HttpResponse
from django.shortcuts import render

from qa_webapp.forms import QuestionForm
from qa_webapp.utils.mdeberta_utils import answer

# Create your views here.
def index(request: HttpRequest) -> HttpResponse:
    if request.method == "POST":
        form = QuestionForm(request.POST)
        if form.is_valid():
            q = form.cleaned_data["question"]
            response = answer(q)
            print(response)
            return render(request, "hello.html", response)
    return  render(request, "hello.html")