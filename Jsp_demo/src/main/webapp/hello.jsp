<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/6/28
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>hello jsp~~~</h1>

    <!-- 内容会直接放到_jspService()方法之中-->
    <%
        System.out.println("hello Jsp~~~");
        int i = 3;
    %>

    <%-- 内容会放到out.print()中，作为out.print()的参数 --%>
    <%="卢氏梦，你好啊~~~"%>
    <%=i%>

    <%-- 内容会放到_jspService()方法之外，被类直接包含--%>
    <%!
        void show(){};
        String name = "卢氏梦";
    %>



</body>
</html>
