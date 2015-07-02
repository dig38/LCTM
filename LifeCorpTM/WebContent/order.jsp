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
	<header id="header">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">LifeCorp TM</a>
				</div>
				
				<div id="navbar" class="navbar-collapse collapse">
					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" placeholder="Email" class="form-control" />
						</div>
						<div class="form-group">
							<input type="password" placeholder="Password" class="form-control" />
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>
					</form>
				</div><!--/.navbar-collapse -->
			</div>
		</nav>
		<br />
		<br />
		<br />
		<br />
	</header>
	
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
		
		<div class="row">
			<form class="form-horizontal" action="Logon" method="post">
				<div class="form-group">
					<label for="quantity" class="col-sm-3 control-label">Quantity</label>
					<div class="input-group spinner col-sm-3">
						<input type="number" class="form-control" id="quantity" placeholder="Quantity" min="0" value="0">
						<div class="btn-group-vertical input-group-btn-vertical ">
							<button class="btn btn-default" type="button">&#8593;</button>
							<button class="btn btn-default" type="button">&#8595;</button>
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