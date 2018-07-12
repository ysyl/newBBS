<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="panel panel-default">
	<div class="panel-heading">公告</div>
    <div class="panel-body">
	   <c:if test="${announces.size() == 0 }">
	   <p>无公告</p>     
	   </c:if>
    </div>
	<ul class="list-group">
	   <c:forEach var="announce" items="${announces }">
	       <li class="list-group-item"><a href=""></a></li>
	   </c:forEach>
	</ul>
</div>