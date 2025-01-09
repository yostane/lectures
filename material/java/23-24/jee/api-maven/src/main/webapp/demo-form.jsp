<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib uri
= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <head>
    <%@ include file="default-head.jspf" %>
    <title>Première page JSP</title>
  </head>
  <body>
    <h1>Enter two integers</h1>
    <div class="container">
      <form action="calculate" method="post">
        <div class="row">
          <label for="nb1">Number 1</label>
          <input type="number" name="nb1" />
        </div>
        <div class="row">
          <label for="nb2">Number 2</label>
          <input type="number" name="nb2" />
        </div>
        <div class="row">
          <input type="submit" value="Submit" />
        </div>
      </form>
    </div>
  </body>
</html>
