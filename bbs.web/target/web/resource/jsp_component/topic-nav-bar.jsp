<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="topic-nav-bar">
	<div class="container topic-nar-bar-container clearfix">
		<ol class="breadcrumb">
            <li><a href="<c:url value="/" />">Home</a></li>
            <li><a href="<c:url value="/forum/forum/${topic.forum.id }" />">${topic.forum.forumName }</a></li>
            <li class="active">${topic.title }</li>
        </ol>
		<nav>
			<ul class="pagination post-pagination">
				<li>
				    <a href="#"> 
				        <span>&laquo;</span>
				    </a>
				</li>
				<c:forEach var="index" begin="1" end="${(topic.replies / 20) +1}" >
    				<li><a href="#">${index }</a></li>
				</c:forEach>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div> 
</div>