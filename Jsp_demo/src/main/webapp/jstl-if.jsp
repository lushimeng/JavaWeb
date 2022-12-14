<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/7/3
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <c:if test="${status == 1}">
    输出状态1的内容！！！
  </c:if>

  <c:if test="${status == 2}">
    输出状态2的内容！！！
  </c:if>


</body>
</html>
