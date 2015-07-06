<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.ServletContext" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${flag != true}">
	<% getServletContext().getRequestDispatcher("/OrderHistory").forward(request, response); %>
</c:if>

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
			<p><c:out value="${cus.customerFname}" /> <c:out value="${cus.customerLname}" />'s Order History</p>
		</div>
	</div>
	<div class="container">
		<table class="table table-striped">
			<tr>
			<th>Order ID</th>
			<th>Product Name</th>
			<th>Product Unit Price</th>
			<th>Quantity</th>
			<th>Total</th>
			</tr>
			<c:forEach var="order" items="${cus.orders}">
				<tr>
					<td><c:out value="${order.orderId}" /></td>
					<td><c:out value="${order.product.productName}" /></td>
					<td><c:out value="${order.product.productUnitprice}" /></td>
					<td><c:out value="${order.orderQuantity}" /></td>
					<td><c:out value="${order.orderTotal}" /></td>
				</tr>
			</c:forEach>
		</table>
	
		
	</div> <!-- /container -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>