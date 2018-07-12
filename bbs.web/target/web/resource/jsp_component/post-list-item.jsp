<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<div class="row post-list-item">
	<div class="col-md-3 user-details">
		<div class="thumbnail">
			<img class="user_avatar" src="<c:url value="/resource/img/user_avatar.gif" />" alt="user_avatar" />
			<div class="caption">
				<a href="#"><h4>${post.author.nickname }</h4></a>
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
		<p>${post.content }</p>
	</div>
</div>