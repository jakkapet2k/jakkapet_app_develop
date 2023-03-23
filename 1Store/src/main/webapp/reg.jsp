<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String user =request.getParameter("username");
	String pass =request.getParameter("password");
	try {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mariadb://202.28.34.205:3306/db64011211038", "64011211038",
			"64011211038");
			statement = connection.createStatement();
			String Insert = "  insert into customer(username,password) values('"+user+"','"+pass+"');";
		 	statement.executeUpdate(Insert);

		} catch (Exception e) {
			out.println("An error occurred.");
		}
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	
	  <%
         
         String site = new String("http://localhost:8080/1Store/register.jsp");
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
      %>
</body>
</html>