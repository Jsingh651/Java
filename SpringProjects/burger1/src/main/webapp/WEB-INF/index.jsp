<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>Burger</title>
</head>
<body>
<div class="main_cont">
<div class="top">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Burger name</th>
      <th scope="col">Restaurant name</th>
      <th scope="col">Rating (out of 5)</th>
	  <th scope="col">Actions</th>
      
    </tr>
  </thead>
  <tbody>
      <c:forEach var="b" items="${burgers}">
    <tr>
      <td><c:out value ="${b.burger_title}"/></td>
      <td><c:out value ="${b.restaurunt_title}"/></td>
      <td><c:out value ="${b.ratings}"/></td>
      <td><a href="/api/burger/${b.id}">Edit</a></td>
      
    </tr>
</c:forEach>
  </tbody>
</table>
</div>
<div class="bottomform">

<form:form action="/burger/form" method="post" modelAttribute="burger">
    <label>Burger Name</label>
    <form:input type="text" path="burger_title" />
    <form:errors path="burger_title" cssClass="error" />
    <br />
    <label>Restaurant Name</label>
    <form:input type="text" path="restaurunt_title"/>
    <form:errors path="restaurunt_title" cssClass="error" />
    <br />
    <label>Rating</label>
    <form:input type="number" path="ratings" max = "5" min = "0" />
    <form:errors path="ratings" cssClass="error" />
    <br />
    <label>Description</label>
    <form:textarea path="description" cols="30" rows="10"></form:textarea>
    <form:errors path="description" cssClass="error" />
    <br />
    <input class="buttondiv" type="submit" value="Submit"/>
</form:form>




</div>





</div>
</body>
</html>