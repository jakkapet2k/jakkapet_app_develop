<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Report</title>
</head>
<body>

	<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap')
	;

* {
	font-family: 'Roboto', sans-serif;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
}
</style>


	<%
	try {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mariadb://202.28.34.205:3306/db64011211038", "64011211038",
			"64011211038");
			statement = connection.createStatement();
			String query = "  SELECT * FROM order_goods;";
			resultSet = statement.executeQuery(query);

		} catch (Exception e) {
			out.println("An error occurred.");
		}
	%>






	<div align="center">
		<h1>Order</h1>
		<table border="0" cellpadding="5">

			<tr>
				<th>Goods ID</th>
				<th>Supplier</th>
				<th>Goods</th>
				<th>Quantity</th>
				<th>Order Date</th>
				<th>Receive Date</th>
			</tr>

			<%
			while (resultSet.next()) {
			%>

			<tr>
				<td><%=resultSet.getString("id_goods")%></td>
				<td><%=resultSet.getString("supplier")%></td>
				<td><%=resultSet.getString("goods")%></td>
				<td><%=resultSet.getString("quantity")%></td>
				<td><%=resultSet.getString("order_date")%></td>
				<td><%=resultSet.getString("receive_date")%></td>
			</tr>

			<%
			}
			connection.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>

		</table>

		<br> <br> <br> <a href="Index.jsp">Home</a> | <a
			href="Store.jsp">Store</a>
	</div>


</body>
</html>