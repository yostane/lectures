from django.urls import path

from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("hello", views.hello, name="hello"),
    path("user/profile", views.user_profile, name="user_profile"),
    path("about", views.about, name="about"),
    path("dynamic", views.dynamic, name="dynamic"),
    path("questions", views.questions, name="questions"),
    path("questions/createform", views.create_question_form, name="create_question_form"),
    path("questions/submit_question", views.submit_question, name="submit_question"),
    path("query/profile", views.show_query_profile, name="show_query_profile"),
    path("query/range", views.show_range, name="show_range"),
    path("query", views.show_p_param, name="show_p_param"),
    path("time", views.show_time, name="show_time"),
    path("nameform", views.name_form, name="name_form"),
    path("multiplication", views.multiplication, name="multiplication"),
    path("pakiman", views.pakiman, name="pakiman"),
]