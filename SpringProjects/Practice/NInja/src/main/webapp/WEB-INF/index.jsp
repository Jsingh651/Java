<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">


</head>
<body>
<div class="top">
<h1>Your Gold: <span class="gold_box"> <c:out value="${gold}"/> </span></h1>
<a class="topbtn" href="/clear">Reset</a>
</div>

<div class="main_container">
	<div class="sub_container">
		<h3>Farm</h3>
		<h6>earns (10 to 20) gold</h6>
		<form action="/gold" method="post"><input  type="submit" name="farm" value="Find Gold!"/></form>
	</div>
	<div class="sub_container">
		<h3>Cave</h3>
		<h6>earns (10 to 20) gold</h6>
		<form action="/gold" method="post"><input  type="submit" name="Cave" value="Find Gold!"/></form>
	</div>
	<div class="sub_container">
		<h3>House</h3>
		<h6>earns (10 to 20) gold</h6>
		<form action="/gold" method="post"><input  type="submit" name="House" value="Find Gold!"/></form>
	</div>
	<div class="sub_container">
		<h3>Quest</h3>
		<h6>earns/takes (0 to 50) gold</h6>
		<form action="/gold" method="post"><input  type="submit" name="Quest" value="Find Gold!"/></form>
	</div>
	<div class="sub_container">
		<h3>Spa</h3>
		<h6>takes (5 to 20) gold</h6>
		<form action="/gold" method="post"><input  type="submit" name="Spa" value="Find Gold!"/></form>
	</div>
</div>

<h1>Activites:</h1>
	<div class="container">
	<c:forEach var="activity" items="${actions}">
	<c:out escapeXml= "false" value="${activity}"/>
	</c:forEach >
	
</div>



</body>
</html> 