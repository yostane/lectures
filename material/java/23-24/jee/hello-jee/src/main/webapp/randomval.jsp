<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Random val</title>
    <%@ include file="default-head.jspf" %>
  </head>
  <body>
    <c:set var="rnd" value="<%= java.lang.Math.random() %>" />
    <p>Generated random value <c:out value="${rnd}" /></p>
    <h1>
      <c:choose>
        <c:when test="${rnd >= 0.5}"> Gagné 🏆 </c:when>
        <c:otherwise> Perdu 😱 </c:otherwise>
      </c:choose>
    </h1>
  </body>
</html>
