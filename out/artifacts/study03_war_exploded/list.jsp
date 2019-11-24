<%--
  Created by IntelliJ IDEA.
  User: Crayon
  Date: 2019/11/23
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>列表信息</title>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td,th{
            text-align: center;
        }
    </style>
</head>
<body>
        <div class="container">
            <h2 style="text-align: center;size: 25px;">查询列表信息</h2>

            <div  style="float: left;">
                <form class="form-inline">
                    <div class="form-group">
                        <label for="exampleInputName2">姓名</label>
                        <input type="text" class="form-control" id="exampleInputName2">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">邮箱</label>
                        <input type="email" class="form-control" id="exampleInputEmail2" >
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </div>

            <div style="float: right;margin: 5px;">
                <a class="btn btn-primary" href="list.jsp">添加联系人</a>
                <a class="btn btn-primary" href="list.jsp">添加联系人</a>
            </div>

            <table class="table table-bordered">
                <tr>
                    <th><input type="checkbox"></th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>籍贯</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${users}" var="user" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="list.jsp">修改</a><a class="btn btn-default btn-sm" href="list.jsp">删除</a></td>
                </tr>
                </c:forEach>
                <tr>
                    <td colspan="8" align="center"><a class="btn btn-primary" href="list.jsp">添加联系人</a></td>
                </tr>
            </table>
            <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
            </div>

</div>
</body>
</html>
