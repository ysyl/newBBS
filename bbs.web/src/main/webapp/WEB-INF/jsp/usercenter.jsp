<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resource/css/common.css" />" rel="stylesheet" />
<link href="<c:url value="/resource/css/usercenter.css" />" rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topbar.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/announce-broad.css" />"
	rel="stylesheet" />
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@ include file="/resource/jsp_component/topbar.jsp"%>
	<div class="usercenter-container container">
      <div class="panel panel-default usercenter-panel">
        <div class="panel-heading usercenter-panel-heading">
            <div class="usercenter-avatar clearfix">
              <img src="user_avatar.gif" alt="user_avatar" />
              <div class="usercenter-avatar-userinfo">
                  <p class="user-nickname">${user.nickname }</p>
              </div>
            </div>
            <ul class="nav nav-tabs">
              <li><a href="#user-topic" data-toggle="tab">主题</a></li>
              <li><a href="#user-broad" data-toggle="tab">留言板</a></li>
              <li class=" active"><a href="#user-profile" data-toggle="tab">个人资料</a></li>
            </ul>
        </div>
        <div class="panel-body">
          <div class="tab-content">
            <div class="tab-panel" id="user-topic">
              <table class="table">
                <thead>
                  <th>主题</th>
                  <th>版块</th>
                  <th>回复/查看</th>
                  <th>最后回复</th>
                </thead>
                <tbody>
                  <c:forEach var="topic" items="${topics }">
                   <tr>
                    <td><a href="<c:url value="/topic/${topic.id }" />">${topic.title }</a></td>
                    <td><a href="<c:url value="/forum/${topic.forum.id }" />">${topic.forum.forumName }</a></td>
                    <td>
                      <p>${topic.replies }</p>
                      <p>${topic.views }</p>
                    </td>
                    <td>
                      <p><a href="<c:url value="/user/${topic.lastReplier.id }" />">${topic.lastReplier.nickname }</a></p>
                      <p>
                        <fmt:formatDate value="${topic.lastReplyPost.pubTime }"
                            type="both" />
                      </p>
                    </td>
                  </tr>
                  </c:forEach>
                 
                </tbody>
              </table>
            </div>
            <div class="tab-panel" id="user-broad">userbroad</div>
            <div class="tab-panel active" id="user-profile">
              <div class="user-profile">
                <div class="user-profile-autogenerated user-profile-component">
                  <p class="user-profile-nickname">${user.nickname }</p>
                  <p><span class="user-profile-field">统计信息</span>关注 ${user.followingAmount } 回帖数 todo  主题数 ${user.topicAmount }</P>
                </div>
                <div class="user-profile-manual user-profile-component">
                  <p><span class="user-profile-field">性别</span>男</p>
                </div>
                <div class="user-profile-statistics-info user-profile-component">
                  <p><span class="user-profile-field">积分</span>200</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resource/js/forum.js" />"></script>
	<script src="<c:url value="/resource/jsp_component/topbar.js" />"></script>
</body>
</html>