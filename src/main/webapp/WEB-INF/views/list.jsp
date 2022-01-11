<%--
  Created by IntelliJ IDEA.
  User: Kun Qin
  Date: 2022/1/10
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
</head>
<%--web路径问题--%>
<%--不以/为开头的相对路径，找资源时，以当前路径为基准，经常容易出问题--%>
<%--而以/为开头的相对路径，以服务器的路径为标准(http://localhost:3306),需要加上项目名才能找到
http://localhost:3306/crud
--%>
<%

    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
<%--
<script type="text/javascript" src="/crud/static/js/jquery-1.12.4.min.js"></script>
--%>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
    <%--搭建显示页面--%>
    <div class="container">

    </div>

</body>
</html>
