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
			<h1><c:out value="${book.title}"/></h1>
		</div>
		<div class="titlebottom">
			<h2><a href="/logout">Logout</a></h2>
			<h2><a href="/home">+ Back to my shelf!</a></h2>
		</div>
	</div>

	<div class="subtitle">
		<c:if test="${book.user.id == userId}">
			<h2>You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></h2>
		</c:if>
		<c:if test="${book.user.id != userId}">
			<h2><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></h2>
		</c:if>
	<div class="thoughtss">
		<c:if test="${book.user.id == userId}">
			<h3>Here are your thoughts:</h3>
		</c:if>
		<c:if test="${book.user.id != userId}">
			<h3>Here are <c:out value="${book.user.userName}"/>'s thoughts: </h3>
		</c:if>
		<div class="line"></div>
		<div class="theactual">
			<h2><c:out value="${book.thoughts}"/></h2>
		</div>
	</div>
	</div>
	<div id="buttons">
<c:if test="${book.user.id == userId}">
    <a  href="/edit/${book.id}"><button class="butt">Edit</button></a>
    <form id="fomrmf" action="/books/${book.id}" method="post" >
        <input type="hidden" name="_method" value="DELETE"/>
        <button class="buttn">Delete</button>
    </form>
</c:if>
	</div>
	
	
</body>
</html>