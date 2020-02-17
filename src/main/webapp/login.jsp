<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/2/17
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="static/layout.css" rel="stylesheet">
</head>
<body>
<form method="post" action="login">
    <input type="text" value="userName">
    <input type="password" value="password">
    <input type="submit" value="Submit">
</form>
<p id="error">${requestScope.error}</p>
</body>
</html>
