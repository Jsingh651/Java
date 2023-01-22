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
   <h1>You have made it Product Create</h1>
	<form:form action="/create/route/products" method="post" modelAttribute="product">
	
	<div>
	<form:label path="name">Name:</form:label>
	<form:errors path="name"/>
	<form:input path="name" type="text"/>	
	</div>
	
	<div>
	<form:label path="description">Description:</form:label>
	<form:errors path="description"/>
	<form:input path="description" type="text"/>
	</div>
	
	<div>
	<form:label path="price">Price:</form:label>
	<form:errors path="price"/>
	<form:input path="price" type="number"/>
	</div>
	
	<button>Submit</button>
	</form:form>
</body>
</html>
