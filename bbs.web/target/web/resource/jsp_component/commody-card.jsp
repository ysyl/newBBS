<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<div class="commody-card">
	<div class="commody-card-body">
		<div class="commody-card-display">
			<img
				src="<c:url value="/resource/img/${commody.commodyImgList.get(0).fileName }" />" />
		</div>
		<div class="commody-card-price">
			<span class="price-icon">￥</span><span class="price">${commody.price }</span>
		</div>
	</div>
	<div class="commody-card-header clearfix">
		<h4 class="commody-title">
			<a href="<c:url value="/shop/commody/${commody.id }" />">${commody.title }</a>
		</h4>
		<p>
			${commody.description.substring(0, commody.description.length() > 9?9:commody.description.length())}<span
				class="time">${dateUtils.getShortTime(commody.pubTime) }</span>
		</p>
	</div>
	<div class="commody-card-footer">留言：${commody.replies }</div>
	<!-- 如果当前页面没有user，说明不在用户中心页面，手动将user设置为currentUser -->
	<c:set var="user" value="${user!=null?user:currentUser }" />
	<sec:authorize
		access="isAuthenticated() and @principalChecker.isMeByUid(${user.id })">
		<a href="javascript:void(0)" class="commody-collect-btn-wrap"
			data-commody-id="<c:out value="${commody.id }" />">
			<div
				class="commody-collect-btn
                        <c:if test="${commodyCollectedSituation.get(commody.id) }" > collected </c:if>
				    ">
				<span class="glyphicon glyphicon-heart"></span>
			</div>
		</a>
	</sec:authorize>
</div>