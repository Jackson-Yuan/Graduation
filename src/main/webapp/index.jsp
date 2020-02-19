<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/2/17
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(document).ready(
            $.ajax({
                url:"/community/health",
                type:"GET",
                success:function (data) {
                    console.log(data);
                }
            })
        )
    </script>
</head>
<body>
<h1>This is index</h1>
<<a href="logout">返回</a>
</body>
</html>
