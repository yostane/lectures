<%@ page contentType="text/html;charset=UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title>Random val</title>
    <%@ include file="../default-head.jspf" %>
  </head>
  <body>
    <h1>Calculator result</h1>
    <p>Sum: ${calculatorResult.sum}</p>
    <p>Difference: ${calculatorResult.difference}</p>
  </body>
</html>
