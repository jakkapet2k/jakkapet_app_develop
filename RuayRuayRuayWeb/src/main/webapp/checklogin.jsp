<%@page import="sql.controllerDAO.DAOController,com.constructor.*,java.util.*"%>

<%
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");

%>

<%
UserLogin login = new UserLogin(user, pass);
boolean status = DAOController.validate(login);
if (status) {
	//session.setAttribute("session", "TRUE");
	session.setAttribute("loginSession", true);
	session.setAttribute("user", user);
	response.sendRedirect("Store.jsp");
} else {
	response.sendRedirect("login.jsp");

}
%>