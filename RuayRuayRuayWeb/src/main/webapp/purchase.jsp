
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="sql.controllerDAO.DAOController,com.constructor.*,java.util.*"%>
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
<title>Purchase</title>
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
						href="Store.jsp">Store</span></a></li>
					<li class="nav-item"><a class="nav-link" href="activity/Analisys.jsp">Analisys</a>
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


	<div class="container mt-5 ">
		<H2>Purchase Order</H2>
		<div>
			<form action="thankyou.jsp" method="post">
				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">ID :</h5>
					<div class="col-sm-2">
						<input type="test" class="form-control-plaintext" id="idGood"
							name="idGood" value=" <%=request.getParameter("id")%>">
					</div>
				</div>


				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">Products Name :</h5>
					<div class="col-sm-2">
						<input type="test" class="form-control-plaintext" id="nameGood"
							name="nameGood" value="<%=request.getParameter("Name")%>">
					</div>
				</div>

				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">Price :</h5>
					<div class="col-sm-2">
						<input type="test" class="form-control-plaintext" id="priceGood"
							name="priceGood" value="<%=request.getParameter("Unit_Price")%> ">
					</div>
				</div>

				<!-- <h5>Quantitys  &nbsp; </h5> -->
				<div class=" mb-3 row">
					<h5 class="col-sm-2 col-form-label ">Quantitys :</h5>
					<div class="col-sm-2">
						<input type="numbers" class="form-control" id="qty" name="qty"
							required>
						<td><a href="thankyou.jsp"><button
									class=" mt-5  btn btn-outline-dark">Check Out</button></a></td>
					</div>
				</div>
			</form>

		</div>
	</div>
	</div>
</body>
</html>
