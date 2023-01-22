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
   <h1>You have made it Product Create the current product is:</h1>
<h1><c:out value="${product.name}"/></h1>
<h1><a href="/">Home</a></h1>

<h2>Categories</h2>
<c:forEach var="spec" items = "${specificCategory}">
<li><h3>${spec.name}</h3></li>
</c:forEach>

<div class="line"></div>
<h2>All categories</h2>
<form action="/add/cat/${product.id}" method="post">
	<select name="categoryId" id="categoryId" class="input">
	    <c:forEach var="category" items="${nonSpecificCategory}">
	    	<option value="${category.id}">${category.name}</option>
	    </c:forEach>
	</select>
<button>Submit</button>
</form>


	
</body>
</html>
