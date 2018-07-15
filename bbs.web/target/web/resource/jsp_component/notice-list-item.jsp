<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<c:set var="isTopicTrendNotice"
	value="${TopicTrendNotice.isInstance(trendNotice) }" />
<c:set var="isPostTrendNotice"
	value="${PostTrendNotice.isInstance(trendNotice) }" />
<c:set var="isUserTrendNotice"
	value="${UserTrendNotice.isInstance(trendNotice) }" />
<div class="post-item clearfix">
	<a class="post-item-avatar" href="#"><img src="./avatar.png" /></a>
	<div class="post-item-content">
		<p>
			<c:if test="${isTopicTrendNotice }">
				<c:set var="notice" value="${TopicTrendNotice.cast(trendNotice) }" />
				<a class="notice-topic-title"
					href="<c:url value="/topic/${notice.topicId }" />">
					${notice.getTopicTitle() } </a>
				<span>收到了一条</span>
				<a href="<c:url value="/post/notice.getRepostId()" />">新回复</a>
				<span>${notice.getPubTime() }</span>
			</c:if>
			<c:if test="${isPostTrendNotice }">
				<c:set var="notice" value="${PostTrendNotice.cast(trendNotice) }" />
				<a class="notice-post-digest"
					href="<c:url value="/topic/${postNotice.getTopicId() }" />">${postNotice.getPostDigest() }</a>
				<span>收到了一条</span>
				<a href="<c:url value="/topic/${postNotice.getTopicId }" />">新回复</a>
			</c:if>
			<c:if test="${isUserTrendNotice }">
				<c:set var="notice" value="${UserTrendNotice.cast(trendNotice) }" />
				<a class="author" href="#">isUserTrendNotice</a>
				<span>${notice.getPubTime() }</span>
				<span>${notice.getActionType }</span>
				<span>${notice.getTargetType }</span>
				<a href="<c:url value="${notice.getTargetId }" />">${notice.getTargetDigest().subString(0, 10) }</a>
				<span>${notice.getPubTime() }</span>
			</c:if>
		</p>
	</div>
</div>