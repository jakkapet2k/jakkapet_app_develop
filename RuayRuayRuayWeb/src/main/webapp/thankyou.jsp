<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="sql.controllerDAO.DAOController,com.constructor.*,java.util.*,java.time.*,java.time.format.DateTimeFormatter"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Triple Ruay</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp">Store</span></a></li>
					<li class="nav-item"><a class="nav-link" href="Analisys">Analisys</a>
					</li>

				</ul>
			</div>
			<div class=" mb-3 row">
				<%
				String username = (String) session.getAttribute("user");
		         
				%>
				<h5 class="col-sm-5 col-form-label text-white ">Products Name :
				</h5>
				<div class="col-sm-5">
					<input type="text" class="form-control-plaintext text-white"
						id="user" name="user" value="<%=username%>">
				</div>
			</div>
		</div>
	</nav>


	<div class="container mt-5 text-center py-5">
		<H2>Thank You !!</H2>
		<h5>
			Order products :
			<%=request.getParameter("nameGood")%>
		</h5>
		<h5>
			Quantity :
			<%=request.getParameter("qty")%></h1>
			<a href="index.jsp"><button class="btn btn-outline-dark mt-5">
					Back to Store</button></a>
	</div>
	</div>
	</div>




	<%
			int cid = (int) session.getAttribute("CID");
			String gid = request.getParameter("idGood");
			String qty = request.getParameter("qty");
			Purchase Add = new Purchase(cid,gid,qty);
			DAOController.AddSalesAndUpdateStock(Add);
	%>
</body>
</html>
