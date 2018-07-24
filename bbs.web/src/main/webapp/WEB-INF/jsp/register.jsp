<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Register</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resource/css/login.css" />" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
        <form class="form-login" action="<c:url value="/principal/register" />" method="post">
            <div class="form-group">
                <label for="username">用户名</label>
                <input type="text" class="form-control" placeholder="username" name="username" />
            </div>
            <div class="form-group">
                <label for="nickname">昵称</label>
                <input type="text" class="form-control" placeholder="nickname" name="nickname" />
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control" placeholder="email" name="email" />
            </div>
            <div class="form-group">
                <label for="sex">性别</label>
                <input type="text" class="form-control" placeholder="sex" name="sex" />
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" placeholder="password" name="password"/>
            </div>
            <div class="form-group">
                <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
            </div>
            <button type="submit" class="btn btn-primary">submit</button>
        </form>
    </div>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>