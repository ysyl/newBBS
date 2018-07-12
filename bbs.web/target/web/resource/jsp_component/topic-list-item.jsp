<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<li class="list-group-item clearfix topic-list-item"><a
	class="topic-list-item-header"
	href="<c:url value="/topic/${topic.id }" />">${topic.title }</a>
	<div class="topic-list-item-right post-last-replier">
		<a href="<c:url value="/user/${topic.author.id }" />">${topic.lastReplier.nickname }</a>
		<p>
		  <fmt:formatDate value="${topic.lastReplyPost.pubTime }"
		      type="both"/>
		</p>
	</div>
	<div class="topic-list-item-right topic-detailsnum">
		<a class="post-list-item-author" href="#">${topic.replies }</a>
		<p>${topic.views }</p>
	</div>
	<div class="topic-list-item-right topic-author">
		<a href="#">${topic.author.nickname }</a>
		<p>
		  <fmt:formatDate value="${topic.pubTime }"
		      type="both"/>
		</p>
	</div></li>