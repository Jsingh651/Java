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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="topt">
<h3><a href="/dashboard">Dashboard</a></h3>
</div>

<div class="bottomg">
<form:form action="/addSong" method="post" modelAttribute="song">
<div>
<label>Title:</label>
<form:input class="songInput" type="text" path="name" />
<form:errors path="name" class="ewn"/>
</div>
<label >Artist:</label>
<form:input class="songInput" type="text" path="artist" />
<form:errors path="artist" class="ewn"/>
<div>
<label >Ratings:</label>
<form:input class="songInput" type="number" path="ratings" min="0" max="10"/>
<form:errors path="ratings" class="ewn"/>
</div>
<input class="submittbn subb" type="submit" value="Submit" />
</form:form>
</div>

   
</body>
</html>