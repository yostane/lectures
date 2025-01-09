<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Random val</title>
    <%@ include file="../favicon-head.jspf" %>
  </head>
  <body>
    <h1>
      <c:choose>
        <c:when test="${hasWon}"> Gagné 🏆 </span></c:when>
        <c:otherwise> Perdu 😱 </c:otherwise>
      </c:choose>
    </h1>
    <h1>
      En ternaire: ${hasWon ? "Gagné 🏆" : "Perdu 😱"}
    </h1>

    <p>Random value was: ${randVal}</p>
  </body>
</html>
