from django.apps import AppConfig
from .helper import init_model


class PromptaiConfig(AppConfig):
    default_auto_field = "django.db.models.BigAutoField"
    name = "promptai"

    def ready(self):
        pass
        # init_model()
