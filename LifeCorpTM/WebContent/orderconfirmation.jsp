<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.ServletContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<html>
<head>
	<title>LifeCorp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" />
</head>
<body>
	<c:import url="/WEB-INF/inserts/header.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1>LifeCorp</h1>
			<p>Welcome to LifeCorp. This is LifeCorp. Anything is possible, at LifeCorp. The only limit is yourself.</p>			
			<p>Order Processed</p>
		</div>
	</div>
	<div class="container">
		<p>Please, save this information as a record for receipt of purchase.</p>
		<table class="table table-striped">
			<tr>
			<th>Order ID</th>
			<th>Product Name</th>
			<th>Product Unit Price</th>
			<th>Quantity</th>
			<th>Total</th>
			<th></th>
			</tr>
			<tr>
				<td><c:out value="${ord.orderId}" /></td>
				<td><c:out value="${pro.productName}" /></td>
				<td><c:out value="${pro.productUnitprice}" /></td>
				<td><c:out value="${ord.orderQuantity}" /></td>
				<td><c:out value="${ord.orderTotal}" /></td>
			</tr>
		</table>
		<strong>
			<p>
				Thank you! <c:out value="${cus.customerFname}" />
			</p>
		</strong>
		
		<a class="btn btn-primary col-sm-2 " href="productlist.jsp">New Order?</a>
		
		<div class="col-sm-1"></div>
		
		<a class="btn btn-default col-sm-1 " href="index.jsp">Home</a>
		
	</div> <!-- /container -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>