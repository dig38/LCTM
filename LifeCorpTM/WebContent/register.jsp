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
		<form class="form-horizontal" action="Register" method="post">
			<div class="form-group">
					<label for="email" class="col-sm-2 control-label">Email / Account Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="email" id="email" placeholder="Email / Account Name" value="" required />
					</div>
			</div>
			<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="password" id="password" placeholder="Password" value="" required />
					</div>
			</div>
			<div class="form-group">
				<label for="fname" class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="fname" id="fname" placeholder="First Name" value="" />
				</div>
			</div>
			<div class="form-group">
				<label for="lname" class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="lname" id="lname" placeholder="Last Name" value="" />
				</div>
			</div>
			<div class="form-group">
				<button class="col-sm-offset-8 col-sm-3 btn btn-primary" type="submit">Add Customer</button>
			</div>
		</form>
		<footer id="footer">
			<hr />
			<div>&copy; 2015 LifeCorp&trade;</div>
		</footer>
	</div> <!-- /container -->
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>