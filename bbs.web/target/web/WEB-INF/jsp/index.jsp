<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resource/css/common.css" />" rel="stylesheet" />
    <link href="<c:url value="/resource/jsp_component/topbar.css" />" rel="stylesheet" />
    <link href="<c:url value="/resource/css/index.css" />" rel="stylesheet" />
    <link href="<c:url value="/resource/jsp_component/forum_card.css" />" rel="stylesheet" />
    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%@ include file="/resource/jsp_component/common-script.jsp" %>
  </head>
    <body>
    <%@ include file="/resource/jsp_component/topbar.jsp" %>
   
    <div id="forum-container" class="container well">
    <c:out value="${count }" />
        <c:forEach var="forum" items="${requestScope.forums}">
            <%@ include file="/resource/jsp_component/forum_card.jsp" %>
        </c:forEach>
    </div>
  </body>
</html>
