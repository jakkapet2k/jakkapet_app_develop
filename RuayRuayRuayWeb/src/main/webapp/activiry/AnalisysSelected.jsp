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
<title>Insert title here</title>
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
              <a class="nav-link" href="../index.jsp">Store</span></a>
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
        </div>
      </nav>


	<center>
		<br> <br> <br>
		<h2>Analisys</h2>
		<br> <br> <br>
	</center>

	<div class="d-flex justify-content-evenly">

		<div class="p-2 card">
			<h3>Order : 32</H3>
		</div>
		<div class="p-2 card">
			<h3>Products : 13</h3>
		</div>
		<div class="p-2 card">
			<h3>Quantity : 64</h3>
		</div>

		<div class="p-2 card">
			<h3>Total income : 1951658</h3>
		</div>
	</div>
		
		<%String My = request.getParameter("yymm"); 
		MonthYear my =new MonthYear(My);
		
		%>
<div class="container mt-5">
	<form action="AnalisysSelected.jsp">
		<div class="col-sm-5 d-flex ">
			<input type="month" class="form-control mx-3" id="yymm" name="yymm" value="">
			<input type="reset" class="col-sm-2 mx-3 btn btn-outline-dark" >
			<a href="Analisys.jsp" class=" btn btn-outline-dark">Show all</a>
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
					List<SaleReport> list = DAOController.getAnalisysSelected(my);

					for (SaleReport sp : list) {

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