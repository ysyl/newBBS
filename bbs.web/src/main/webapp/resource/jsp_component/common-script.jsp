<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false"%>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script charset="utf-8"
	src="<c:url value="/resource/editor.md-master/editormd.min.js" />"></script>

<script type="text/javascript">
//用户名，用于拼接订阅链接
let username = "<sec:authentication property="name" />";
//ajax拉取所有通知的url
let pullNoticesUrl = "<c:url value="/notice/trend/all" />";
//订阅stomp，实时获得通知的url
let subscribeTrendNoticeUrl = "/user/" + username + "/topic/notice";
//连接stomp的url
let connectUrl = "<c:url value="/stomp" />";
//ajax抓取通知的url
let pullNoticesCountUrl = "<c:url value="/notice/trend/count" />";
//刷新订阅时间的url
let stompFreshLastReadTimeUrl = "/app/fresh";
let ajaxFreshLastReadTimeUrl = "<c:url value="/notice/trend/freshLastReadTime" />"
</script>

<script type="text/javascript"
	src="<c:url value="/resource/jsp_component/notice-stomp.js" />"></script>
<script src="<c:url value="/resource/jsp_component/searchSelector.js" />"></script>