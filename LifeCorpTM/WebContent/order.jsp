<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.ServletContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<html>
<head>
	
	<title>LifeCorp</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" type="text/css" href="css/spinner.css" >
</head>
<body>
	<c:import url="/WEB-INF/inserts/header.jsp" />
	
	<div class="jumbotron">
		<div class="container">
			<h1>LifeCorp</h1>
			<p>Welcome to LifeCorp. This is LifeCorp. Anything is possible, at LifeCorp. The only limit is yourself.</p>
			<br />
			<br />
			<p><a class="btn btn-primary btn-lg" href="index.jsp" role="button">Home &raquo;</a></p>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Product List: </h2>
					<table class="table table-striped">
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Unite Price</th>
					</tr>
					<tr>
							<td><c:out value="${pro.productId}" /></td>
							<td><c:out value="${pro.productName}" /></td>
							<td><c:out value="${pro.productUnitprice}" /></td>
					</tr>
					</table>			
			</div><!-- .col-md-12 -->
		</div><!-- .row -->
		
		<h3>Please, select how many units of <c:out value="${pro.productName}" /> you would like to purchase.</h3>
		
		<div class="row">
			<form class="form-horizontal" action="ProcessOrder" method="post">
				<div class="form-group">
					<label for="quantity" class="col-sm-3 control-label">Quantity</label>
					<div class="input-group spinner col-sm-3">
						<input type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity" min="0" value="0">
						<div class="btn-group-vertical input-group-btn-vertical ">
							<button class="btn btn-default" type="button">+</button>
							<button class="btn btn-default" type="button">-</button>
						</div>
					</div>			
				</div>		
				<div class="form-group">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-primary form-control" id="submit">Submit</button>
					</div>
			</div>
			</form>
		</div><!-- .row -->
				
		<footer id="footer">
			<hr />
			<div>&copy; 2015 LifeCorp&trade;</div>
		</footer><!-- #footer -->
    </div> <!-- .container -->
    
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="js/spinner.js"></script>

</body>
</html>