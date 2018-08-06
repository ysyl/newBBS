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
<link href="<c:url value="/resource/css/shop_details.css" />"
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

	<div class="shop-details-container">
		<div class="commody-bar-wrap navbar navbar-default container">
			<div class="navbar-header commody-bar-user-info">
				<img src="" />
				<p>${commody.user.nickname }</p>
			</div>
			<ul class="commody-bar nav navbar-nav">
				<li class="commody-bar-views-info">
					<p class="title">浏览次数</p>
					<p class="value">${commody.views }</p>
				</li>
				<li class="commody-bar-modify-info">
					<p class="title">最近编辑时间</p>
					<p class="value">//todo 2018-07-30 15:51</p>
				</li>
			</ul>
			<a href="#" class="report">举报</a>
		</div>

		<div class="commody-main-container container">
			<div class="col-sub col-md-8">
				<div class="commody-carousel">
					<div class="commody-album-list-wrap">
						<div class="commody-album-list">
							<c:forEach var="commodyImg" items="${commody.commodyImgList }">
								<div class="commody-album-list-item">
									<img
										src="<c:url value="/resource/img/${commodyImg.fileName }" />" />
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="commody-thumb-list">
						<c:forEach var="commodyImg" items="${commody.commodyImgList }">
							<div class="commody-thumb-list-item">
								<img
									src="<c:url value="/resource/img/${commodyImg.fileName }" />" />
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="commody-desc">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#description" data-toggle="tab">商品介绍</a></li>
						<li><a href="#comment" data-toggle="tab">留言</a></li>
					</ul>
					<div class="tab-content">
						<div id="description" class="tab-panel active">${commody.description }</div>
						<div id="comment" class="tab-panel">
							<ul class="primary-comment-list">
								<li class="primary-comment">
									<div class="primary-comment-wrap row">
										<div class="primary-comment-user-info col-md-3">
											<img class="user-avatar" src="avatar.png" />
											<h5 class="user-nickname">
												<a href="<c:url value="#" />">
												    verrickt</a>
											</h5>
										</div>
										<div class="primary-comment-content col-md-9">
											<p class="primary-comment-content">鱼塘聚集你身边所有活跃在闲鱼上的小伙伴儿，省运费更信任！还有“塘主”为你提供帮助和服务</p>
										</div>
									</div>
									<ul class="reply-comment-list clearfix">
										<li class="reply-comment row">
											<div class="reply-comment-user-info col-md-3">
												<img class="user-avatar" src="avatar.png" />
												<h5 class="user-nickname">verrickt</h5>
											</div>
											<div class="reply-comment-content col-md-9">
												<p class="reply-comment-content">嵌套回复内容</p>
											</div>
										</li>

										<li class="reply-comment row">
											<div class="reply-comment-user-info col-md-3">
												<img class="user-avatar" src="avatar.png" />
												<h5 class="user-nickname">verrickt</h5>
											</div>
											<div class="reply-comment-content col-md-9">
												<p class="reply-comment-content">
													<span class="reply-to">回复 zhou ：</span>嵌套回复内容
												</p>
											</div>
										</li>
									</ul>
								</li>
								<li class="primary-comment">
									<div class="primary-comment-wrap row">
										<div class="primary-comment-user-info col-md-3">
											<img class="user-avatar" src="avatar.png" />
											<h5 class="user-nickname">
												<a href="#">verrickt</a>
											</h5>
										</div>
										<div class="primary-comment-content col-md-9">
											<p class="primary-comment-content">鱼塘聚集你身边所有活跃在闲鱼上的小伙伴儿，省运费更信任！还有“塘主”为你提供帮助和服务</p>
										</div>
									</div>
									<ul class="reply-comment-list clearfix">
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="col-main col-md-4">
				<div class="commody-property">
					<h3 class="title">${commody.title }</h3>
					<div class="price-info">
						<span class="name">价格：</span><span class="value">¥${commody.price }</span> 
					</div>
					<div class="other-info">
						<span class="name">所在地：</span> <span class="value">//todo 江苏南京</span>
					</div>
					<div class="other-info">
						<span class="name">成色：</span> <span class="value">//todo 非全新</span>
					</div>
					<div class="buy-now">
						<button type="button" class="btn btn-primary">立即购买</button>
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
	<script src="<c:url value="/resource/js/usercenter.js" />"></script>
</body>
</html>