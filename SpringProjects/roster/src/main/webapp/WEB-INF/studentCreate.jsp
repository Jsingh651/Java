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
    <title>Create a Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="top">
  <h1>Create a Student</h1>
<h1><a href="/">Home</a></h1>
</div>

<div class="bottom">
<form:form action="/create/new/student" method="post" modelAttribute="student">
<form:label path="firstName">First name</form:label>
<form:input path="firstName" type="text"/>
<form:errors path="firstName"/>

<form:label path="lastName">Last name</form:label>
<form:input path="lastName" type="text"/>
<form:errors path="lastName"/>

<form:select path="dorm">
<c:forEach var="d" items="${dorms}">
<option value="${d.id}"> ${d.name}</option>
</c:forEach>

</form:select>
<button>Submit</button>
</form:form>
</div>

</body>
</html>