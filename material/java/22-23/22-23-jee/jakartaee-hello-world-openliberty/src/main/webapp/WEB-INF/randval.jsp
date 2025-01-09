<%@ page pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Test</title>
  </head>
  <body>
    <c:out value="Bonjour" /><br />
    <p>Hello ${ randomValue }. has won ? ${ hasWon }</p>

    <c:forEach var="number" items="${ testNumbers }">
      <c:out value="${ number }"/><br>
    </c:forEach>
  </body>
</html>
