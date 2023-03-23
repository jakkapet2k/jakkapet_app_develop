<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
</head>
<body>
	<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap')
	;

* {
	font-family: 'Roboto', sans-serif;
}

label, input {
	margin-top: 15px;
}
</style>
	<div align="center">
		<br> <br> <br> <br>
		<h1>Order</h1>
		<form action="insertReceipt_simple.jsp" method="post">
			<label for="gid">Goods ID: </label> 
			<input type="text" name="gid" id="gid"> 
			<br><br> 
			<label for="goods">Goods : </label> 
			<input type="text" name="goods" id="goods"> 
			<br><br> 
			<label for="quantity">quantity : </label> 
			<input type="text" name="quantity" id="quantity"> 
			<br><br> 
			<label for="date">date : </label> <input type="text" name="date" id="date"> 
			<br><br> 
			<label for="customer">customer : </label> 
			<input type="text" name="customer" id="customer" value="guest"> 
			<br> <br> 
				 <input type="submit">
		</form>
		<br> <br> <br> <a href="index.jsp">Home</a> | <a
			href="Store.jsp">Store</a>
	</div>




</body>
</html>