<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resource/css/common.css" />" rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topbar.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/announce-broad.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/forum.css" />" rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/topic-list-item.css" />"
	rel="stylesheet" />
<!-- HTML5 shim å Respond.js æ¯ä¸ºäºè®© IE8 æ¯æ HTML5 åç´ ååªä½æ¥è¯¢ï¼media queriesï¼åè½ -->
<!-- è­¦åï¼éè¿ file:// åè®®ï¼å°±æ¯ç´æ¥å° html é¡µé¢ææ½å°æµè§å¨ä¸­ï¼è®¿é®é¡µé¢æ¶ Respond.js ä¸èµ·ä½ç¨ -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@ include file="/resource/jsp_component/topbar.jsp"%>

	<ol class="breadcrumb forum-breadcrumb">
		<li><a href="<c:url value="/" />">Home</a></li>
		<li class="active">${forum.forumName}</li>
	</ol>
	<div class="content-wrap">
		<div class="container">
			<div class="row">
				<div class="row-wrap clearfix">
					<div class="col-md-9 bbs-main-wrap">
						<ul class="nav nav-tabs bbs-nav-tabs">
							<li><a href="#recommand-post" data-toggle="tab">推荐</a></li>
							<li><a href="#hot-post" data-toggle="tab">热门</a></li>
							<li class="active"><a href="#new-post" data-toggle="tab">最新</a></li>
							<h2 class="tabs-brand">
								<i class="icon icon-list"></i> 主题
							</h2>
						</ul>
						<div class="tab-content" id="main-content">
							<div class="tab-panel bbs-explore-list active"
								id="recommand-post"></div>
							<div class="tab-panel bbs-hotpost-list" id="hot-post">
								<div class="post-list"></div>
							</div>
							<div class="tab-panel active bbs-recommand-list" id="new-post">
								<c:forEach var="topic" items="${topics }">
									<%@ include file="/resource/jsp_component/topic-list-item.jsp"%>
								</c:forEach>
							</div>
						</div>
					</div>

					<div class="col-md-3 bbs-side-bar">
						<div class="panel panel-default">
							<div class="panel-heading">公告</div>

							<ul class="list-group">
								<li class="list-group-item"><a href="">第一条公告</a></li>
								<li class="list-group-item"><a href="">第一条公告</a></li>
							</ul>
						</div>
						<div class="hot-user"></div>
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
