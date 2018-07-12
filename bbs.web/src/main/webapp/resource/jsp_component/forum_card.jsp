<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-4 col-sm-6 forum-card clearfix">
    <img class="forum-avatar" src="<c:url value="/resource/img/forum_avatar.png" />" />
    <div class="forum-card-heading">
        <a href="<c:url value="/forum/${forum.id}" />"><h1>${forum.forumName}</h1></a>
    </div>
    <div class="forum-card-body">
            <p>主题:todo  帖数: todo</p>
            <a href="#">最后发表: todo</a>
    </div>
</div>