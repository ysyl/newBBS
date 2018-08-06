<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<c:set var="classification" value="${entry.getKey() }" />
<c:set var="commodyList" value="${entry.getValue() }" />
<div class="panel panel-default shop-commody-classification-panel">
	<div class="panel-heading">
		<!-- 取出Classification -->
		<span>${classification.name }</span> <a href="#" class="pull-right">更多</a>
	</div>
	<div class="panel-body commody-row">
		<c:forEach var="commody" items="${commodyList }">
			<div class="commody-card">
				<div class="commody-card-body">
					<div class="commody-card-display">
						<img src="<c:url value="/resource/img/${commody.commodyImgList.get(0).fileName }" />" />
					</div>
					<div class="commody-card-price">
						<span class="price-icon">￥</span><span class="price">${commody.price }</span>
					</div>
				</div>
				<div class="commody-card-header">
					<h4 class="commody-title">${commody.title }</h4>
					<p>
						${commody.description }<span class="time">//todo 5分钟前</span> 
					</p>
				</div>
				<div class="commody-card-footer">留言：${commody.replies }</div>
				<div class="commody-collect-btn">
					<span class="glyphicon glyphicon-heart"></span>
				</div>
			</div>
		</c:forEach>
	</div>
</div>