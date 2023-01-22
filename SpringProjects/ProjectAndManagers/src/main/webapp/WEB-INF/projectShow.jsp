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
    <link rel="stylesheet" href="/css/new.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="titlediv">
		<div class="titletop">
			<h1>Project Details</h1>
	<h2 class="frefrrf"><a href="/see/task/${project.id}">See task</a></h2>
		</div>
		<div class="titlebottom">
			<h2><a href="/logout">Logout</a></h2>
			<h2><a href="/home">+ Back to Dashboard!</a></h2>
		</div>
	</div>

	<div class="gigaChad">
	<div class="megaChad">
	<h1>Project</h1>
	<h1><c:out value="${project.title}"/></h1>
	</div>
	<div class="megaChad">
	<h1>Description</h1>
	<h1 class="hellode"><c:out value="${project.description}"/></h1>
	</div>
	<div class="megaChad">
	<h1>Due Date</h1>
	<h1><fmt:formatDate value="${project.due_date}" pattern="MMMM dd"/></h1>
	</div>
	</div>

<div class="ddwce">

	<c:if test="${userId == project.lead.id}">
	<a class="deletebtn" href="/delete/${project.id}">Delete</a>
	</c:if>
</div>
	
</body>
</html>