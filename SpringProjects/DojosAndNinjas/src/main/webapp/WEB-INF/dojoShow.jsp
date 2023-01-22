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
    <title>Dojos register</title>
<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/4.6.0/css/bootstrap.min.css'/>">
<script src="<c:url value='/webjars/jquery/3.6.0/jquery.min.js'/>"></script>
    
</head>
<body>
<div class="dojosjow-navbar">
    <a class="link-hover" href="/">Home</a>
  </div>
  <h1>These are all the ninjas at <c:out value="${dojo.name}"/></h1>
  <table class="table">
    <thead>
      <tr>
        <th scope="col" class="table-dark">First Name</th>
        <th scope="col" class="table-dark">Last Name</th>
        <th scope="col" class="table-dark">Age</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="ninjas" items="${dojo.ninjas}">
      <tr class="table-info">
        <td><c:out value="${ninjas.firstName}"/></td>
        <td><c:out value="${ninjas.lastName}"/></td>
        <td><c:out value="${ninjas.age}"/></td>
      </tr>

		</c:forEach>
    </tbody>
  </table>


</body>
</html>
