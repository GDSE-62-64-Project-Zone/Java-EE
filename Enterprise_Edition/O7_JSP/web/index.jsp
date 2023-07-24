<%--
  Created by IntelliJ IDEA.
  User: sanu
  Date: 2023-07-24
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<h1>Java Servlet Page</h1>
<%--Scriplet--%>
<%--We can define several lines of java codes--%>
<%
    String s="Hello JSP";
    int age=10;
%>

<%--Expression--%>
<%--We can print a variable inside a html elelment--%>
<h1><%=s%></h1>
<h1><%=age%></h1>

<%--Declration--%>
<%--we can define a sigle variable--%>
<%! String name="Galle";%>
<body>

</body>
</html>
