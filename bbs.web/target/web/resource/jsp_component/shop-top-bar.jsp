<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="shop-navbar" class="navbar navbar-default container">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#shop-navbar-collapsed"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">交易区 </a>
		</div>
		<div class="collapse navbar-collapse" id="shop-navbar-collapse">
			<ul class="nav navbar-nav">
				<c:forEach var="classification" items="${classInfo}">
					<li><a href="#">${classification.name }</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</nav>

