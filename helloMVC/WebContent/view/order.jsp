<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=#ece6cc>
	<h1 align='center'>Reading All Request Parameters</h1>
	<br />
	<table border="1">
		<tr>
			<th bgcolor="#ffa500">Parameter Name</th>
			<th bgcolor="#ffa500">Parameter Value(s)</th>
		</tr>
		<tr>
			<td>cardNum</td>
			<td><ul>
					<li>${order.creditCardNumber}</li>
				</ul></td>
		</tr>
		<tr>
			<td>cardType</td>
			<td>${order.creditCard}</td>
		</tr>
		<tr>
			<td>price</td>
			<td>${order.priceEach}</td>
		</tr>
		<tr>
			<td>initial</td>
			<td>${order.middleInitial}</td>
		</tr>
		<tr>
			<td>itemNum</td>
			<td>${order.itemNumber}</td>
		</tr>
		<tr>
			<td>address</td>
			<td>${order.shippingAddress}</td>
		</tr>
		<tr>
			<td>firstName</td>
			<td>${order.firstName}</td>
		</tr>
		<tr>
			<td>description</td>
			<td>${order.description}</td>
		</tr>
		<tr>
			<td>lastName</td>
			<td>${order.lastName}</td>
		</tr>
	</table>
</body>
</html>