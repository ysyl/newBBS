<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<%@ page import="bbs.web.enuma.SearchType"%>
<%@ page import="bbs.web.enuma.OrderType"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resource/css/common.css" />" rel="stylesheet" />
<link href="<c:url value="/resource/css/usercenter.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topbar.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/announce-broad.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_common.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_index.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_search.css" />"
	rel="stylesheet" />
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<%@ include file="/resource/jsp_component/common-script.jsp"%>
</head>
<body>
	<%@ include file="/resource/jsp_component/topbar.jsp"%>
	<%@ include file="/resource/jsp_component/shop-top-bar.jsp"%>
	<c:set var="searchTypeClassification"
		value="<%=SearchType.CLASSIFICATION%>" />
	<c:set var="searchTypeSubClass" value="<%=SearchType.SUBCLASS%>" />
	<c:set var="searchTypeKeyword" value="<%=SearchType.KEYWORD%>" />
	<c:set var="searchTypeSeller" value="<%=SearchType.SELLER%>" />
	<c:set var="orderTypeNew" value="<%=OrderType.NEW%>" />
	<c:set var="orderTypePriceAsc" value="<%=OrderType.PRICE_ASC%>" />
	<c:set var="orderTypePriceDsc" value="<%=OrderType.PRICE_DSC%>" />

	<div class="shop-search-body-wrap">
		<div class="crumb-container container">
			<ol class="breadcrumb">
				<span class="crumb-prefix">个人闲置：</span>
				<li><a href="<c:url value="/shop/index" />">全部</a></li>
				<li><c:choose>
						<c:when test="${searchType.equals(searchTypeClassification)}">${classification.name }</c:when>
						<c:when test="${searchType.equals(searchTypeSubClass)}">${subClass.name }</c:when>
						<c:when test="${searchType.equals(searchTypeKeyword)}">${keyword }</c:when>
						<c:when test="${searchType.equals(searchTypeSeller)}">用户 ${user.nickname } 的所有商品</c:when>
					</c:choose></li>
			</ol>
		</div>
		<!-- 统计 -->
		<%@ include file="/resource/jsp_component/catelog-filter-wrap.jsp"%>

		<div class="search-filter-container container clearfix">
			<span class="search-keywords"> <c:choose>
					<c:when test="${searchType.equals(searchTypeClassification)}">${classification.name }</c:when>
					<c:when test="${searchType.equals(searchTypeSubClass)}">${subClass.name }</c:when>
					<c:when test="${searchType.equals(searchTypeKeyword)}">${keyword }</c:when>
					<c:when test="${searchType.equals(searchTypeSeller)}">用户 ${user.nickname } 的所有商品</c:when>
				</c:choose> 
			</span> <span class="search-filter-tool ">
				<div class="btn-group">
					<button class="btn btn-default" type="button">最新发布</button>
					<button class="price-btn active asc btn btn-default" type="button">
						价格 <span class="glyphicon glyphicon-chevron-up"></span> <span
							class="glyphicon glyphicon-chevron-down"></span>
					</button>
				</div>
			</span>
		</div>

		<div class="search-result-list-wrap container">
			<ul class="search-result-list">
				<c:forEach var="searchCommody" items="${searchCommodyList }">
					<%@ include
						file="/resource/jsp_component/commody-search-result-list-item.jsp"%>
				</c:forEach>
			</ul>
		</div>
	</div>

</body>
</html>