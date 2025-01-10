from django.urls import path
from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("prompt-input", views.show_query_form, name="prompt-input"),
    path("run-query", views.process_query_form, name="run-query"),
    path("ai-chat", views.show_chat_view, name="ai-chat"),
    path("material-demo", views.show_material_demo, name="material-demo"),
    path("bulma-demo", views.show_bulma_demo, name="bulma-demo"),
    path("register", views.register_request, name="register"),
    path("login", views.login_request, name="login"),
    path("logout", views.logout_request, name="logout"),
]
