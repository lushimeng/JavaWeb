<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/7/3
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach begin="0" end="10" step="1" var="i">  <!-- begin, end, step, var-->
        ${i} <br>
    </c:forEach>


</body>
</html>
