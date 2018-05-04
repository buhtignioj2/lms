<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>LMS</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath }" method="get">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${itemPage.content }" var="item" varStatus="status">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.category.name }</td>
						<td>
						<c:choose>
							<c:when test="${item.isrent}">
								<a href="${pageContext.servletContext.contextPath }/rent/${item.id}/${authUser.no }/${item.isrent}" class="btn">예약</a>
							</c:when>
							<c:otherwise>
								<a href="${pageContext.servletContext.contextPath }/rent/${item.id}/${authUser.no }/${item.isrent}" class="btn">대여</a>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
					</c:forEach>		
				</table>

				<div class="pager">
					<ul>
						<c:if test="${!itemPage.first}">
							<li><a href="${pageContext.servletContext.contextPath }?page=${itemPage.number-1}">◀</a></li>
							</c:if>
								<c:forEach begin="1" end="${itemPage.size }" var="i">
					 				<li class="selected"><a href="${pageContext.servletContext.contextPath }?page=${i-1}">${i}</a></li>
								</c:forEach>
							<c:if test="${!itemPage.last}">
							<li><a href="?page=${itemPage.number+1}">▶</a></li>
						</c:if>
					</ul>
				</div>			 
				
				<div class="bottom">
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>