<%--
  Created by IntelliJ IDEA.
  User: issunjh
  Date: 2021/6/14
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../../static/js/jquery-3.6.0.js"></script>
<html>
<head>
    <title>出错啦！！！</title>
</head>
<body>
    <h1>出错啦！</h1>
    <h3 style="text-align: center">${requestScope.exception.message}</h3>
</body>
</html>
