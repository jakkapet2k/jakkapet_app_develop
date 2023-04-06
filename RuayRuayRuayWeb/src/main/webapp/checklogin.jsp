<%@page import="sql.controllerDAO.DAOController,com.constructor.*,java.util.*"%>

<%
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");

%>

<%
UserLogin login = new UserLogin(user, pass);
boolean status = DAOController.validate(login);
if (status) {
	int id = login.getId();
	//out.print(id);
	session.setAttribute("loginSession", true);
	session.setAttribute("user", user);
	session.setAttribute("CID", id);
	response.sendRedirect("Store.jsp");
} else {
	response.sendRedirect("login.jsp");
	//out.print("Error");
}
%>