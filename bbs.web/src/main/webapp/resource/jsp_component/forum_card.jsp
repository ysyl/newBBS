<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-4 col-sm-6 forum-card clearfix">
    <img class="forum-avatar" src="<c:url value="/resource/img/forum_avatar.png" />" />
    <div class="forum-card-heading">
        <a href="<c:url value="/forum/forum/${forum.id}" />"><h1>${forum.forumName}</h1></a>
    </div>
    <div class="forum-card-body">
            <c:set var="lastPost" value="${lastPostMap.get(forum.getId())}" />
            <p>主题:todo  帖数: todo</p>
          
            <a href="<c:url value="/forum/topic/${lastPost.getTopic().id}" />">最新回复</a>  
    </div>
</div>