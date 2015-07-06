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
			<p>Place an Order here with LifeCorp!</p>
			<p><a class="btn btn-primary btn-lg" href="ProductList" role="button">New Order &raquo;</a></p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>New Customers Here: </h2>
				<p>Register Here! </p>
				<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
			</div>
			<div class="col-md-6">
				<h2>Returning Customers: </h2>
				<p>Click here to view your order history. </p>
				<p><a class="btn btn-default" href="orderhistory.jsp" role="button">Order History&raquo;</a></p>
			</div>
		</div>
		<footer id="footer">
			<hr />
			<div>&copy; 2015 LifeCorp&trade;</div>
		</footer>
	</div> <!-- /container -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>