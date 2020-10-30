<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=#ece6cc>
	<h1 align='center'> A Sample Form</h1>
	<br/>
	
	<form action="/helloMVC/orderProcess" method='get'>
		Item Number: <input type="text" name="itemNumber"> <br/>
		Description: <input type="text" name="description"> <br/>
		Price Each: <input type="text" name="priceEach"> <br/><hr>
		First Name: <input type="text" name="firstName"> <br/>
		Last Name: <input type="text" name="lastName"> <br/>
		Middle Initial: <input type="text" name="middleInitial"> <br/>
		Shipping Address: <textarea rows=3 cols=20 name="shippingAddress"></textarea> <br/>
		Credit Card: <br/>
		<input type="radio" name="creditCard" value="visa"> Visa <br/>
		<input type="radio" name="creditCard" value="masterCard"> MasterCard <br/>
		<input type="radio" name="creditCard" value="americanExpress"> American Express <br/>
		<input type="radio" name="creditCard" value="discover"> Discover <br/>
		<input type="radio" name="creditCard" value="javaSmartCard"> Java SmartCard <br/>
		Credit Card Number: <input type="password" name="creditCardNumber"> <br/>
		Repeat Credit Card Number: <input type="password" name="repeatCreditCardNumber"> <br/>
		<input type="submit" value="Submit Order">
		
	</form>
</body>
</html>