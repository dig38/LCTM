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
					<c:forEach var="product" items="${proList}">
						<tr>
							<td><c:out value="${product.productId}" /></td>
							<td><a href="Orders?pid=<c:out value="${product.productId}" />"><c:out value="${product.productName}" /></a></td>
							<td><c:out value="${product.productUnitprice}" /></td>
						</tr>
					</c:forEach>
					</table>
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