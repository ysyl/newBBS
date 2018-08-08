<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<c:set var="classification" value="${entry.getKey() }" />
<c:set var="commodyList" value="${entry.getValue() }" />
<div class="panel panel-default shop-commody-classification-panel">
	<div class="panel-heading">
		<!-- 取出Classification -->
		<span>${classification.name }</span> <a href="<c:url 
		  value="/shop/commody/search/total?search_type=CLASSIFICATION&classification_id=${classification.id }" />" class="pull-right">更多</a>
		
	</div>
	<div class="panel-body commody-row">
		<c:forEach var="commody" items="${commodyList.subList(0, 4) }">
			<div class="commody-card">
				<div class="commody-card-body">
					<div class="commody-card-display">
						<img src="<c:url value="/resource/img/${commody.commodyImgList.get(0).fileName }" />" />
					</div>
					<div class="commody-card-price">
						<span class="price-icon">￥</span><span class="price">${commody.price }</span>
					</div>
				</div>
				<div class="commody-card-header clearfix">
					<h4 class="commody-title"><a href="<c:url value="/shop/commody/${commody.id }" />">${commody.title }</a></h4>
					<p>
						${commody.description.substring(0, commody.description.length() > 9?9:commody.description.length())}<span class="time">${dateUtils.getShortTime(commody.pubTime) }</span> 
					</p>
				</div>
				<div class="commody-card-footer">留言：${commody.replies }</div>
                <a href="javascript:void(0)" class="commody-collect-btn-wrap" data-commody-id = "<c:out value="${commody.id }" />">
				<div class="commody-collect-btn">
					<span class="glyphicon glyphicon-heart"></span>
				</div>
				</a>
			</div>
		</c:forEach>
	</div>
</div>