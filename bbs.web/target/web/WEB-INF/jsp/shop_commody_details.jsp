<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<link href="<c:url value="/resource/slick-1.8.1/slick/slick.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/slick-1.8.1/slick/slick.css" />"
	rel="stylesheet" />
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%@ include file="/resource/jsp_component/common-script.jsp"%>
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
					<p class="value">
						<fmt:formatDate value="${commody.pubTime }" type="both" />
					</p>
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
						<li id="comment_panel_toggle_btn"><a href="#comment"
							data-toggle="tab">留言</a></li>
					</ul>
					<div class="tab-content">
						<div id="description" class="tab-panel active">${commody.description }</div>
						<div id="comment" class="tab-panel">
							<button type="button"
								class="btn btn-primary pub-commodycomment-btn"
								>发表回复</button>
							<ul id="comment-list" class="primary-comment-list">

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
						<span class="name">所在地：</span> <span class="value">//todo
							江苏南京</span>
					</div>
					<div class="other-info">
						<span class="name">成色：</span> <span class="value">//todo
							非全新</span>
					</div>
					<div class="buy-now">
						<button type="button" class="btn btn-primary">立即购买</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="pub-commodycomment-modal" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">发表评论</h4>
				</div>
				<div class="modal-body">
				    <form id="pub-commodycomment-form" class="pub-commodycomment-form" method="post">
				        <label for="content">评论内容: </label>   
				        <input type="text" name="content" class="form-control" />
				        <input type="hidden" name="belongPrimaryCommentId" class="form-control" />
				        <input type="hidden" name="replyTargetCommentId" class="form-control" />
				    </form>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" form="pub-commodycomment-form" class="btn btn-primary">发布评论</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script>
	   
	</script>
	<script type="text/javascript"
		src="<c:url value="/resource/slick-1.8.1/slick/slick.min.js" />"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.commody-album-list').slick({
				slidesToShow : 1,
				slidesToScroll : 1,
				arrows : false,
				fade : true,
				asNavFor : '.commody-thumb-list',
			});
			$('.commody-thumb-list').slick({
				slidesToShow : 3,
				slidesToScroll : 1,
				asNavFor : '.commody-album-list',
				centerMode : true,
				focusOnSelect : true
			});
		})
	</script>
	<script>
		let commodyId = "<c:out value="${commody.id}" />";
	</script>
	<script type="text/javascript"
		src="<c:url value="/resource/js/commody-comment-panel.js" />"></script>
	<script>
		let commentPanel = new CommentPanel();
	</script>
</body>
</html>