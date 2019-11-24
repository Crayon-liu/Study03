<%--
  Created by IntelliJ IDEA.
  User: Crayon
  Date: 2019/11/23
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </head>
  <body>
<div align="center">
<a href="${pageContext.request.contextPath}/userListServlet" style="size: 50px;text-align: center;">
  查询所有用户
</a>
</div>
  </body>
</html>
