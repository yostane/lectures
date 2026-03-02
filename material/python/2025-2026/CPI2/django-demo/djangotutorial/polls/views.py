from django.shortcuts import render
from django.http import HttpResponse


def index(request):
    return HttpResponse("<h1>Hello, world.</h1> You're at the polls index.")


def about(request):
    return HttpResponse(
        """
<h1>About me</h1>
<p style="border: 1px black solid">This is a django tutorial</p>                    
""")


def links(request):
    return HttpResponse(
        """
<html>
  <head>
  <style>
    ul {
      background: blue
    }
  </style>
  </head>
  <body>
    <ul>
      <li>Link 1</li>
      <li>Link 2</li>
    </ul>
  </body>
</html>
""")
