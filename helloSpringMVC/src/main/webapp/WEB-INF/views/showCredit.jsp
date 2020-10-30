<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<table border="1">
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수학점</th>
			<th>상세보기</th>
		</tr>

		<c:forEach var="credit" items="${credits }">
			<tr>
				<td>${credit.year }</td>
				<td>${credit.semester }</td>
				<td>${credit.credit }</td>
				<td><a href="${pageContext.request.contextPath}/showCreditDetail?year=${credit.year}&semester=${credit.semester}"> 상세보기 </a></td>
			</tr>
		</c:forEach>
		
		<c:forEach var="credit" items="${credits }">
			<p> <c:out value="${credit }"></c:out>
		</c:forEach>

	</table>
</body>
</html>