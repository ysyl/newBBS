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
            <%@ include file="/resource/jsp_component/commody-card.jsp" %>	
		</c:forEach>
	</div>
</div>