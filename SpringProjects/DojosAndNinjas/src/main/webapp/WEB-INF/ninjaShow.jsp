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
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="navbar-ninjas">
        <h1><a class="link-hover" href="/">Home</a></h1>
    </div>
    <form:form class="form-action" action="/create/ninja" method="post" modelAttribute="ninja">
        <h3  class="newbtnfe">Location</h3>
				
		<form:select class="options-tag" path="dojo">
                <c:forEach var ="d" items = "${dojos}">
                	<option value = "${d.id}">${d.name}</option>
                </c:forEach>
		</form:select>
		
        <h2 class="input-1f"></h2>
        <form:label class="label-tag" path = "firstName"> First Name </form:label>
        <form:input class="input-tag" type="text" path="firstName"/>
        
        <form:label class="label-tag" path = "lastName"> Last Name </form:label>
        <form:input class="input-tag" type="text" path="lastName"/>
        
        <form:label class="label-tag" path = "age"> Age </form:label>
        <form:input class="input-tag" type="number" path="age"/>
        <input class=" submitbtn sumbitbtn1" type="submit" name="Submit">
    </form:form>


</body>
</html>
