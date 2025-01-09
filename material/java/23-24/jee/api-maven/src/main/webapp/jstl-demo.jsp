<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- librairie de tags JSP (qui fait de la JSTL JSP Standard Tag Library) -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- autre librairie de tags JSP -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Première page JSP</title>
    <!-- https://docs.oracle.com/javaee/5/tutorial/doc/bnajb.html -->
    <%@ include file="default-head.jspf" %>
  </head>
  <body>
    <p>
      La date actuelle du serveur est : <%= (new java.util.Date()).toString()%>
    </p>

    <!-- TAG JSP ou balise JSP -->
    <c:set var="now" value="<%= new java.util.Date()%>" />

    <p>Date formatée (1): <fmt:formatDate type="time" value="${now}" /></p>

    <p>Date formatée (2): <fmt:formatDate type="date" value="${now}" /></p>

    <p>
      Date formatée (3): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
    </p>

    <a href="https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm"
      >Documentation</a
    >
  </body>
</html>
