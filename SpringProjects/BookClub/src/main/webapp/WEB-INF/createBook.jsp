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
	   		<h1 class="title">Add a Book To your Shelf!</h1>
		</div>
		<div class="titlebottom">
			<h2><a href=/home>Back to the  shelves</a></h2>
		</div>
	</div>
	
<!-- Form -->
<div class="card">
        <div class="content">
            <div class="front">
			<div class="form">
		<form:form action="/createBook/post" method="post" modelAttribute="newBook">
           <form:input type="hidden" path="lead" value="${userId}"/>
           <form:errors class='errors' path="title"/>
           <form:input  path="title" class="fir" type="text" autocomplete="off" placeholder=" Title"/>
			<form:errors class='errors' path="author"/>
           <form:input  path="author" type="text" autocomplete="off" placeholder="Author"/>
           <form:errors class='errors' path="thoughts"/>
           <form:textarea path="thoughts" class="pswlst2" autocomplete="off" placeholder="My thoughts?"/>
           <button class="custom-btn btn-14">Submit</button>
		</form:form>
	</div>
	</div>
	</div>
	</div>
<!-- Form End -->

</body>
</html>