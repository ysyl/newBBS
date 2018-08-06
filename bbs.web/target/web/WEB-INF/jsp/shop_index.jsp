<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
<link href="<c:url value="/resource/css/usercenter.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topbar.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/announce-broad.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_common.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_index.css" />"
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
	<%@ include file="/resource/jsp_component/shop-top-bar.jsp"%>

	<div class="container" id="shop-container" data-spy="scroll"
		data-target="#shop-navbar">
		<div class="row container-fluent" id="shop-index-recommend">
			<div class="col-md-3" id="shop-index-classification-list">
				<div class="list-group">
					<c:forEach var="classification" items="${classInfo}">
						<li href="#" class="list-group-item"><div
								class="list-group-item-inner">
								<a href="#">${classification.name }</a>
								<div class="nav-list-tab">
									<c:forEach var="subClass" items="${classification.subClasses }">
										<a href="#" class="col-md-3">${subClass.name }</a>
									</c:forEach>
								</div>
							</div></li>
					</c:forEach>

				</div>
			</div>
			<div id="index-commody-recommend-carousel"
				class="carousel slide col-md-6" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#index-commody-recommend-carousel"
						data-slide-to="0"></li>
					<li data-target="#index-commody-recommend-carousel"
						data-slide-to="1"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="default-display-commody-1.jpg" alt="...">
						<div class="carousel-caption">测试标题1</div>
					</div>
					<div class="item">
						<img src="default-display-commody-2.jpg" alt="...">
						<div class="carousel-caption">测试标题2</div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control"
					href="#index-commody-recommend-carousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control"
					href="#index-commody-recommend-carousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			<div class="col-md-3" id="shop-control-group-wrap">
				<div id="shop-control-group">
					<button class="btn btn-default shop-control">发布商品</button>
					<button class="btn btn-default shop-control">我的收藏</button>
				</div>
			</div>

		</div>

		<div class="container-fluent row" id="shop-recommend-container">
			<div class="you-may-like col-md-3">
				<div class="you-may-like-user clearfix">
					<img
						src="<c:url value="/resource/upload/img/${currentUser.avatar }" />" />
					<p>
						Hi, <span>${currentUser.nickname }</span>
					</p>
					<p class="you-may-like-p">你可能感兴趣</p>
				</div>
				<div class="you-may-like-tag">
					<a href="#" class="tag">摩托车</a> <a href="#" class="tag">手机</a> <a
						href="#" class="tag">摩托车</a> <a href="#" class="tag">摩托车</a> <a
						href="#" class="tag">摩托车</a> <a href="#" class="tag">手机</a> <a
						href="#" class="tag">手机</a> <a href="#" class="tag">手机</a>
				</div>
			</div>
			<div class="new-items col-md-6">
				<div class="new-items-nav">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab-you-may-like"
							data-toggle="tab">猜你喜欢</a></li>
						<li><a href="#tab-new-items" data-toggle="tab">最新发布</a></li>
					</ul>
				</div>
				<div class="new-item-tab-content tab-content">
					<div id="tab-you-may-like" class="tab-panel active">
						<a href="#" class="new-item-tab-content-btn">换一批</a>
						<div class="row">
						    <c:set var="youMayLikeCommodySubList" value="${youMayLikeCommodyList.subList(0, 2) }" />
						    <c:forEach var="commody" items="${youMayLikeCommodySubList }">
						      	<div class="col-md-6">
							     	<div class="commody-img-wrap">
								    	<img class="commody-img" src="<c:url value="/resource/img/${commody.commodyImgList.get(0).fileName }" />"  />
								    </div>
								    <h5 class="commody-description">
									   <a href="#">${commody.title }</a>
								    </h5>
							    </div>
						    </c:forEach>
						</div>
					</div>
					<div id="tab-new-items" class="tab-panel">
						<a href="#" class="new-item-tab-content-btn">更多</a>
						<div class="row">
							<div class="col-md-6">
								<div class="commody-img-wrap">
									<img class="commody-img" src="default-commody.jpg" />
								</div>
								<h5 class="commody-description">
									<a href="#">最新发布商品标题</a>
								</h5>
							</div>
							<div class="col-md-6">
								<div class="commody-img-wrap">
									<img class="commody-img" src="default-commody.jpg" />
								</div>
								<h5 class="commody-description">
									<a href="#">最新发布商品标题</a>
								</h5>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="on-selling col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading">好友发布的商品</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>

		<div id="shop-index-commody-container" class="container-fluent ">
			<c:forEach var="entry" items="${recommendCommodyResultMap.entrySet() }">
				<%@ include
					file="/resource/jsp_component/commody-classification-recommend.jsp"%>
			</c:forEach>
		</div>

	</div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resource/js/forum.js" />"></script>
	<script src="<c:url value="/resource/jsp_component/topbar.js" />"></script>
	<script src="<c:url value="/resource/js/usercenter.js" />"></script>
</body>
</html>