<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath }/doCreateCourse"
		modelAttribute="course">
		<table class="formtable">
			<tr>
				<td class="label">교과코드 :</td>
				<td><sf:input class="control" type="text" path="code" /> <br />
					<sf:errors path="code" class="error" /></td>
			</tr>
			<tr>
				<td class="label">교과목명 :</td>
				<td><sf:input class="control" type="text" path="name" /> <br />
					<sf:errors path="name" class="error" /></td>
			</tr>
			<tr>
				<td class="label">구분 :</td>
				<td><sf:input class="control" type="text" path="division" /> <br />
					<sf:errors path="division" class="error" /></td>
			</tr>
			<tr>
				<td class="label">학점 :</td>
				<td><sf:input class="control" type="text" path="credit"
						value="3" /> <br /> <sf:errors path="credit" class="error" /></td>
			</tr>

			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="수강 신청" /></td>
			</tr>

		</table>
	</sf:form>
	<p>
		<a href="${pageContext.request.contextPath}/"> 홈으로 이동 </a>
	</p>
</body>
</html>