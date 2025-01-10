from django.db import models
from django.contrib.auth.models import User

# Create your models here.


class Prompt(models.Model):
    class Meta:
        # '-' dans '-date' -> ordre décroissant
        ordering = ["-date"]

    user = models.ForeignKey(User, on_delete=models.CASCADE)
    query = models.CharField(max_length=200)
    reply = models.CharField(max_length=2000)
    date = models.DateTimeField(auto_now_add=True)

    def __str__(self) -> str:
        return (
            f"Prompt of {self.user.username}: {self.query}. The reply was: {self.reply}"
        )
