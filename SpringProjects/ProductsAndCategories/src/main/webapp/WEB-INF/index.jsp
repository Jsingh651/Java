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
   <h1>You have made it</h1>
<h2><a href="/create/category">Create a Category</a></h2>
<h2><a href="/create/products">Create a Product</a></h2>


<div class="bottomhalf">
<table>
<thead>
<tr>
    <th>Products</th>
</tr>
</thead>
<c:forEach var="pro" items="${products}">
  <tr> 
  <td><a href="/show/product/${pro.id}">${pro.name}</a></td>
  </tr>
</c:forEach>
</table>
<div class="hello">

<table>
<thead>
<tr>
    <th>Categories</th>
</tr>
</thead>
<c:forEach var="cat" items="${categories}">
  <tr> 
  <td><a href="/show/cateogry/${cat.id}">${cat.name}</a> </td>
  </tr>
</c:forEach>
</table>
</div>


</div>
</body>
</html>
