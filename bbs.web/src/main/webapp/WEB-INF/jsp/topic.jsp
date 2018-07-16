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
<link href="<c:url value="/resource/css/topic.css" />" rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topbar.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/announce-broad.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/post-list-item.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topic-nav-bar.css" />"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value="/resource/editor.md-master/css/editormd.min.css" />" />
<link rel="stylesheet"
	href="<c:url value="/resource/jsp_component/bbs-post-editor.css" />" />
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@ include file="/resource/jsp_component/topbar.jsp"%>

	<%@ include file="/resource/jsp_component/topic-nav-bar.jsp"%>

	<div class="container" id="topic-content-wrap">
		<div class="panel panel-default topic-container">
			<div class="panel-heading container-fluent topic-top-bar"
				id="post-heading">
				<div class="topic-top-bar-component col-md-3 topic-details">
					查看: ${topic.views } | 回复: ${topic.replies }</div>
				<div class="topic-top-bar-component col-md-9">
				    <span>${topic.title }</span>
				    <a href="#"><span id="collect-topic-btn" data-topic-id="${topic.id }" class="glyphicon glyphicon-heart
				        <c:if test="${isTopicCollected }">collected</c:if>
				     "></span></a>
				</div>
			</div>
			<div class="panel-body topic-body container-fluent">
				<c:forEach var="post" items="${posts }">
					<%@ include file="/resource/jsp_component/post-list-item.jsp"%>
				</c:forEach>
			</div>

			<div class="panel-footer topic-footer">
				<ul class="pagination post-pagination">
					<li><a href="#"> <span>&laquo;</span>
					</a></li>
					<c:forEach var="index" begin="1" end="${(topic.replies / 20) +1}">
						<li><a href="#">${index }</a></li>
					</c:forEach>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</div>
			
    <%@ include file="/resource/jsp_component/bbs-post-editor.jsp"%>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resource/js/forum.js" />"></script>
	<script src="<c:url value="/resource/jsp_component/topbar.js" />"></script>
	<script charset="utf-8" src="<c:url value="/resource/editor.md-master/editormd.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resource/js/topic.js" />"></script>
	<script type="text/javascript">
    $(document).ready(function() {
        var editor = editormd("editormd", {
            path : "<c:url value="/resource/editor.md-master/lib/" />",
            width : "90%",
            height: 500,
            emoji: true,
            markdown: "请在此处输入回复内容",
            saveHTMLToTextarea: true,
        });

        /*
        // or
        var editor = editormd({
            id   : "editormd",
            path : "../lib/"
        });
        */
    });
    let collectPostUrl = "<c:url value="/collect/post/" />";
    let collectTopicUrl = "<c:url value="/collect/topic/" />";
</script>
    <script type="text/javascript" src="<c:url value="/resource/jsp_component/notice-stomp.js" />"></script>
</body>
</html>
