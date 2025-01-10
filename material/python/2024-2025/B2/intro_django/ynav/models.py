from django.db import models

# Create your models here.
# ORM: Object Relational Mapper (Relational vient des BDD relationnelles (celles qu'on manipule avec SQL))

class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField("date published")


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)

class Pakiman(models.Model):
    name = models.CharField(max_length=200)
    type = models.CharField(max_length=200)
    level = models.IntegerField(default=1)
    attack = models.IntegerField(default=1)