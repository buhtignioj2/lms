<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>lms</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/admin/rent.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/admin/include/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>예약일</th>
						<th>반납일</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }"/>
					<c:forEach items="${list }" var="reserve" varStatus="status">
						<tr>
							<td>${count - status.index }</td>
							<td>${reserve.item.title }</td>
							<td>${reserve.item.category.name }</td>
							<td>
								${reserve.rentDate }
							</td>
							<td>
								${reserve.returnDate }
							</td>
						</tr>
					</c:forEach>
				</table>
<%-- 				<div class="pager">
					<ul>
						<li><a href="${pageContext.servletContext.contextPath }/rent">◀</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/rent">6</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/rent">7</a></li>
						<li class="selected">8</li>
						<li>9</li>
						<li>10</li>
						<li>▶</li>
					</ul>
				</div> --%>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp" />
		</div>
	</div>
</body>
</html>