<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<li class="result-list-item clearfix">
	<div class="commody-info">
		<img
			src="<c:url value="/resource/img/${searchCommody.commodyImgList.get(0).fileName }" />" />
		<h4 class="commody-info-title">
			<a href="<c:url value="/shop/commody/${searchCommody.id }" />">${searchCommody.title }</a>
		</h4>
		<p class="commody-info-price">
			￥<span class="price-num">${searchCommody.price }</span>
		</p>
		<p class="commody-info-description">${searchCommody.description }</p>
		<p class="commody-info-pub-time">${dateUtils.getShortTime(searchCommody.pubTime) }</p>
	</div>
	<div class="user-info">
		<img
			src="<c:url value="/resource/img/${searchCommody.user.avatar }" />" />
		<div class="pull-left">
			<h5 class="user-nickname">
				<a href="#">${searchCommody.user.nickname }</a> <a href="#"><span
					class="glyphicon glyphicon-comment"></span></a>
			</h5>
			<p class="user-location">//todo 江苏南京</p>
		</div>
	</div> <a class="more-commody"
	href="<c:url value="/shop/commody/search/total?search_type=SELLER&user_id=${searchCommody.user.id }" />">该卖家的商品</a>
</li>