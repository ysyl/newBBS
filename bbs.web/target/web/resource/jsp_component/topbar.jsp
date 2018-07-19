<%@page import="bbs.subscriptionsystem.notice.entity.TopicTrendNotice"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="TopicTrendNotice"
	value="<%=bbs.subscriptionsystem.notice.entity.TopicTrendNotice.class%>" />
<c:set var="PostTrendNotice"
	value="<%=bbs.subscriptionsystem.notice.entity.PostTrendNotice.class%>" />
<c:set var="UserTrendNotice"
	value="<%=bbs.subscriptionsystem.notice.entity.UserTrendNotice.class%>" />
<c:set var="currentUser" value="${sessionScope.user }" />
<%@ include file="/resource/jsp_component/script-sockjs-stomp.jsp" %>
<nav class="navbar navbar-default">
	<div class="container-fluid bbs-navbar-container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class=""><a href="<c:url value="/" />">论坛首页<span
						class="sr-only">(current)</span></a></li>
				<li><a href="#">积分商城</a></li>
				<li><a href="#">交易区</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" id="notice-panel-toggle">通知<span class="badge" id="new-notice-remind"></span><span class="caret"></span></a>
					<ul class="dropdown-menu notice-menu" id="notice-menu">
						<ul class="nav nav-pills">
							<li><a href="#trend" data-toggle="pill">动态</a></li>
							<li><a href="#friend" data-toggle="pill">好友消息</a></li>
							<li><a href="#focus" data-toggle="pill">关注信息</a></li>
						</ul>
						<div class="tab-content" id="notice-menu-content">
							<div class="tab-panel active" id="trend">
<%-- 							<c:forEach var = "trendNotice" items="${noticeMap.get('trend') }"> --%>
<%-- 						      <%@ include file="/resource/jsp_component/notice-list-item.jsp" %>	 --%>
<%-- 							</c:forEach> --%>
							</div>
							<div class="tab-panel" id="friend"></div>
							<div class="tab-panel" id="focus"></div>   
						</div>
					</ul> </a></li>
			</ul>
			<div class="navbar-right" id="user-avatar">
		      <img src="/resource/upload/img/${currentUser.avatar }" />	
		      <a href="javascript: void(0)">${currentUser.nickname }</a>
			</div>
			<form class="navbar-form navbar-right"
				action="<c:url value="/search" />" method="get">
				<div class="form-group search-form">
					<div class="input-group">
						<input type="text" name="title"
							class="form-control search-form-input" placeholder="Search">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								id="search-selector" data-toggle="dropdown">
								本版 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">本版</a></li>
								<li><a href="#">全局</a></li>
								<li><a href="#">用户</a></li>
							</ul>
							<button type="submit" class="btn btn-default">搜索</button>
						</div>
					</div>
				</div>
			</form>
			<div id="nav-user-info" class="navbar-right" >
			 头像
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>