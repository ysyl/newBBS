<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<div class="row post-list-item">
    <c:set var="isChecked" value="${postMap.get(post) }"/>
	<div class="col-md-3 user-details">
		<div class="thumbnail">
			<img class="user_avatar" src="<c:url value="/resource/upload/img/${post.author.avatar }" />" alt="user_avatar" />
			<div class="caption">
				<a href="<c:url value="/user/${post.author.id }" />"><h4>${post.author.nickname }</h4></a>
				<a href="#"><span data-user-id="${post.author.id }" class="glyphicon glyphicon-heart  follow-btn" ></span></a>
				<div class="user-info container-fluent clearfix">
					<div class="user-info-component col-md-4">
						<p>${post.author.topicAmount }</p>
						<p>帖子</p>
					</div>
					<div class="user-info-component col-md-4">
						<p>${post.author.followingAmount }</p>
						<p>关注</p>
					</div>
					<div class="user-info-component col-md-4">
						<p>${post.author.credit }</p>
						<p>积分</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-9 user-post">
	   <a class="collect-btn
	       <c:if test="${isChecked }">collected</c:if>
	    " href="#"><span  data-post-id="${post.id }" class="glyphicon glyphicon-heart"></span></a>
	   <a class="reply-btn"  href="#editormd" ><span data-post-id="${post.id }" data-post-author-name="${post.author.nickname }" class="glyphicon glyphicon-send"></span></a>
	   <br>
	   <c:if test="${post.replyPost != null }" >
	       <p><span>回复： </span><span>${post.replyPost.author.nickname }: </span>${post.replyPost.content  }……</p>
	   </c:if>
	   <c:choose>
	       <c:when test="${post.htmlContent.length() > 0}">
	           ${post.htmlContent }
	       </c:when>
	       <c:otherwise>
	          ${post.content } 
	       </c:otherwise>
	   </c:choose>
	</div>
</div>