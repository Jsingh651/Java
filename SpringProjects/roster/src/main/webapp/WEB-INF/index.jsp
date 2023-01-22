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
    <title>Dorms</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Dorms</h1>
<h1><a href="/create/dorm">Create a Dorm</a></h1>
<h1><a href="/studentShow">Create a Student</a></h1>


<table>
<thead>
<th>Dorm</th>
<th>----------</th>
<th>Action</th>
</thead>
<tbody>
<c:forEach var="d" items="${dorms}">
<td><c:out value="${d.name}"/></td>
<td><a href='/dorm/${d.id}'>See all Students</a></td>
</c:forEach>
</tbody>

</table>
</body>
</html>