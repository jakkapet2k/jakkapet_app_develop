
<%@page
	import="sql.controllerDAO.DAOController,com.constructor.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
	<link rel="stylesheet" href="style.css">
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Triple Ruay</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="Store.jsp">Store</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="activity/Analisys.jsp">Analisys</a>
            </li>
            
          </ul>
        </div>
        <div class=" mb-3 row">
        <%String username = (String) session.getAttribute("user");%>
          <h5 class="col-sm-5 col-form-label text-white ">Products Name : </h5>
          <div class="col-sm-5">
            <input type="text"  class="form-control-plaintext text-white" id="user" name="user" value="<%=username%>">
          </div>
          </div>
        </div>
      </nav>



	<center>
		<br> <br> <br> 
		<h2>Store</h2>
		<br> <br> <br>
	</center>


	<div class="container">



		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Catagory 1</th>
					<th scope="col">Catagory 2</th>
					<th scope="col">Catagory 3</th>
					<th scope="col">Product</th>
					<th scope="col">Unit price</th>
					<th scope="col">Stock</th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<tr>

					<%
					List<Goods> list = DAOController.getGoods();
					for (Goods g : list) {
					%>
					<td><%=g.getfor()%></td>
					<td><%=g.getlv1()%></td>
					<td><%=g.getlv2()%></td>
					<td><%=g.getlv3()%></td>
					<td><%=g.getName()%></td>
					<td><%=g.getPrice()%></td>
					<td><%=g.getStocks()%></td>
					<td><a href="purchase.jsp?id=<%= g.getid()%>&Name=<%= g.getName()%>&Unit_Price=<%= g.getPrice()%>"><button class="btn btn-outline-dark">Purchase</button></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<br> <br> <br>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
		crossorigin="anonymous"></script>
</body>
</html>