<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<
<c:set var="searchType" value="${searchType }" />

<div class="catelog-filter-wrap container">
	<div class="catelog-filter">
		<c:choose>
			<c:when test="${searchType.equals(searchTypeClassification)}">
				<c:set var="commodyStatisticMap" value="${subClassCommodyStatistic }" />
			</c:when>
			<c:otherwise>
				<c:set var="commodyStatisticMap" value="${searchCommodyKeywordStatisticMap}" />
			</c:otherwise> 
		</c:choose>
		<c:forEach var="entry" items="${commodyStatisticMap.entrySet() }">
			<div class="catalog-tag col-md-3">
				<a
					href="
					<c:choose>
				         <c:when test="${searchType.equals(searchTypeClassification)}">
				         <c:url value="/shop/commody/search/total?search_type=SUBCLASS&subclass_id=${entry.getKey().id }" />
				        </c:when>	
				        <c:otherwise>
				         <c:url value="/shop/commody/search/total?search_type=KEYWORD&keyword=${entry.getKey().content }" />
				        </c:otherwise>  
					</c:choose>  
					">
					<c:choose>
						<c:when test="${searchType.equals(searchTypeClassification)}">
                        ${entry.getKey().name }
                        </c:when>
						<c:otherwise>
                        ${entry.getKey().content }
                        </c:otherwise>
					</c:choose> (${entry.getValue() })
				</a>
			</div>
		</c:forEach>
	</div>
</div>