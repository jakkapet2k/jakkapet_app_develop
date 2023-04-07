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
<title>Analisys</title>
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
              <a class="nav-link" href=../Store.jsp>Store</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="OrderReport.jsp">OrderReport</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="SalesReport.jsp">SalesReport</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="BalanceReport.jsp">BalanceReport</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Analisys.jsp">Analisys</a>
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


	<center>
		<br> <br> <br>
		<h2>Analisys</h2>
		<br> <br> <br>
	</center>

		<%String My = ""; 
		MonthYear my =new MonthYear(My);
		
		%>

<div class="container mt-5">
	<form action="AnalisysSelected.jsp">
		<div class="col-sm-5 d-flex ">
			<input type="month" class="form-control mx-3" id="yymm" name="yymm">
			<input type="submit" class=" btn btn-outline-dark" >
		</div>
	
		
	</form>
	<table class="table mt-5">
		<thead>
			<tr>
				<th scope="col">No:</th>
				<th scope="col">Order Date</th>
				<th scope="col">Goods</th>
				<th scope="col">Quantity</th>
				<th scope="col">Unit price</th>
				<th scope="col">Total price</th>
			</tr>
		</thead>

		<tbody>
			<tr>

				<%

					List<Analisys> list = DAOController.getAnalisysSelected(my);

					for (Analisys sp : list) {

					%>
					<td><%=sp.getfor()%></td>
					<td><%=sp.getordate()%></td>
					<td><%=sp.getusername()%></td>
					<td><%=sp.getName()%></td>
					<td><%=sp.getqty()%></td>
					<td><%=sp.gettp()%></td>
				</tr>
				<%
				}
				%>
		</tbody>
	</table>
</div>
	<br>
	<br>
	<br>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
		crossorigin="anonymous"></script>
</body>
</html>