# Generated by Django 5.1.2 on 2024-11-15 16:04

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('ynav', '0002_pakiman'),
    ]

    operations = [
        migrations.AddField(
            model_name='pakiman',
            name='attack',
            field=models.IntegerField(default=1),
        ),
    ]
