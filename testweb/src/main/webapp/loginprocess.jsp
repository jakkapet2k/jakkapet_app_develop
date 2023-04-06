<%@page import="bean.UserLogin"%>
<%@page import="bean.LoginDao"%>

<%
String user = request.getParameter("user");
	String pass = request.getParameter("pass");

%>



<%
UserLogin login = new UserLogin(user, pass);
boolean status = LoginDao.validate(login);
if (status) {
	out.println("You r successfully logged in");
	session.setAttribute("session", "TRUE");
} else {
	request.getRequestDispatcher("index.jsp").forward(request, response);

}
%>