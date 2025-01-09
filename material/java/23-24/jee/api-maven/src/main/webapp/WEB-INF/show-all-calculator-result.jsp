<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Random val</title>
    <%@ include file="../default-head.jspf" %>
  </head>
  <body>
    <h1>Result history</h1>
    <ul>
      <c:forEach var="result" items="${results}">
        <li>sum: ${result.sum} - difference: ${result.difference}</li>
      </c:forEach>
    </ul>
  </body>
</html>
