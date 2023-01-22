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
	   		<h1 class="title">Welcome, <c:out value="${user.userName}"/>!</h1>
			<h3 class="hehehehe">All Projects:</h3>
		</div>
		<div class="titlebottom">
			<h2><a href="/logout">Logout</a></h2>
			<h2><a href="/show/project/create">+ Add a Project</a></h2>
		</div>
	</div>

<div class="bottomhalf">
<table>
<thead>
<tr>
    <th>Project</th>
    <th>Team Lead</th>
    <th>Due Date</th>
    <th>Actions</th>
</tr>
</thead>
<c:forEach var="project" items="${unnasignedProjects}">
<c:if test ="${project.lead.id != userId}">
 <tr>
<td><a href="/show/Product/${project.id}">${project.title}</a></td>
<td>${project.lead.userName}</td>
<td><fmt:formatDate value="${project.due_date}" pattern="MMMM dd"/></td>
<td><a href="/join/project/${project.id}">Join Team</a></td>
</tr>
 </c:if>
 </c:forEach>
</table>

<!--  --><!--  --><!--  -->
</div>

<div class="bttnfe">
<h3 class="titleff">Your Projects:</h3>

<table>
<thead>
<tr>
    <th>Project</th>
    <th>Team Lead</th>
    <th>Due Date</th>
    <th>Actions</th>
</tr>
</thead>
<c:forEach var = "project" items="${leadOrMember}">
 <tr>
<td><a href="/show/Product/${project.id}">${project.title}</a></td>
<td>${project.lead.userName}</td>
<td><fmt:formatDate value="${project.due_date}" pattern="MMMM dd"/></td>
<c:if test = "${project.lead.id != userId}">
<td><a href="/leave/project/${project.id}">Leave</a></td>
</c:if>
<c:if test="${project.lead.id == userId}">
<td><a href="/edit/project/${project.id}">Edit</a></td>
</c:if>

</tr>
</c:forEach>
</table>
</div>

</body>
</html>