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
	out.print("Sorry, email or password error");
%>
<jsp:include page="index.jsp"></jsp:include>
<%
}
%>