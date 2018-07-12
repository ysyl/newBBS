<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<li class="search-result-list-item list-group-item"><a href="<c:url value="/topic/${topic.id }" />">${topic.title }</a>
	<p>${topic.mainPost.content } 回复:${topic.replies } 查看:${topic.views } 
	最后回复: <fmt:formatDate value="${topic.lastReplyPost.pubTime }" type="both"/>
	</p></li>