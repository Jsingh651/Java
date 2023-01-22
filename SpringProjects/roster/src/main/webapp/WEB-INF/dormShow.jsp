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
    <title><c:out value="${dorm.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="top">
  <h1>Welcome to <c:out value="${dorm.name}"/></h1>
<h1><a href="/">Home</a></h1>
</div>

<form action="/add/new/${dorm.id}" method="post">
<input type="hidden" name="_method" value="put" />
<select name="studentId">
<c:forEach var="e" items="${students}">
<option value="${e.id}">${e.firstName} ${e.lastName} (${e.dorm.name})</option>
</c:forEach>
</select>
<button>Submit</button>
</form>



<c:forEach var="student" items="${students}">
<c:if test = "${student.dorm.id == dorm.id}">
<h1>${student.firstName}  ${student.lastName} (${student.dorm.name})</h1>
</c:if>
</c:forEach>




</body>
</html>