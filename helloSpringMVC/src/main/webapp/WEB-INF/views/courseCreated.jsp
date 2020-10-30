<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	새로운 강의 : ${course.name } 가 추가되었습니다. 감사합니다.
	<br />

	<p>
		<a href="${pageContext.request.contextPath}/showCurrent"> Show current
			courses </a>
	</p>
</body>
</html>