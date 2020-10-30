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
			<th>수강년도</th>
			<th>학기</th>
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</tr>

		<c:forEach var="course" items="${courses }">
			<tr>
				<td>${course.year }</td>
				<td>${course.semester }</td>
				<td>${course.code }</td>
				<td>${course.name }</td>
				<td>${course.division }</td>
				<td>${course.credit }</td>
			</tr>
		</c:forEach>
		
		<p>
			<a href="${pageContext.request.contextPath}/"> 홈으로 이동 </a>
		</p>
	</table>
</body>
</html>