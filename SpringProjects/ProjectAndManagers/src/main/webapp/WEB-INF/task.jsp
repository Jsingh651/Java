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
			<h1>Project: <c:out value="${project.title}"/></h1>
			<h3>Project Lead: <c:out value="${project.lead.userName}"/></h3>
		</div>
		<div class="titlebottom">
			<h2><a href="/logout">Logout</a></h2>
			<h2><a href="/home">+ Back to Dashboard!</a></h2>
		</div>
	</div>

	<div class="formcomment">
	<div class="mddidwc">
	<form:form action="/create/task" method="post" modelAttribute="task">
	<h3 class="fevefdser">Add a task ticket for this team:</h3>
	<input type ="hidden" name="project_task" value="${project.id}"/>
	<input type="hidden" name="task_creator" value="${userId}"/>
	<form:textarea class="fefvrefvrvr" path="taskDetails"></form:textarea>
	
	<button class="custom-btn btn-14">Submit</button>
	</form:form>
	</div>
	<div class="allcommmentlist">
<c:forEach var="task" items="${tasks}">
	<c:if test="${task.project_task.id.equals(project.id)}" >
	<h2>Added By ${task.task_creator.userName} at <fmt:formatDate value="${task.createdAt}" pattern="h:mma MMM dd" /></h2>
	<h3 class="everfgrer"> Details: ${task.taskDetails} </h3>	
</c:if>
	</c:forEach>
	</div>
	</div>
	
	
</body>
</html>