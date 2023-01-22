<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styles.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>You have made it Category the current category is:</h1>
<h1><c:out value="${category.name}"/></h1>
<h1><a href="/">Home</a></h1>

<h2>Products</h2>
<c:forEach var="spec" items = "${specificProduct}">
<li><h3>${spec.name}</h3></li>
</c:forEach>

<div class="line"></div>
<h2>All products</h2>
<form action="/add/cat/${category.id}" method="post">
	<select name="categoryId" id="productId" class="input">
	    <c:forEach var="product" items="${nonSpecificProduct}">
	    	<option value="${product.id}">${product.name}</option>
	    </c:forEach>
	</select>
<button>Submit</button>
</form>


	
</body>
</html>
