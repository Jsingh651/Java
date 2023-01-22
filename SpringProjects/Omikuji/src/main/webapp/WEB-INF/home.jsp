<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/home" method=post>
	<div class="container">
	<label>Pick a number 2 to 25:</label>
	<input type="number" name="years" min="2" max="25">
	<label >Enter the name of any city:</label>
	<input type="text" name="city"/>
	<label>Enter the name of any real person</label>
	<input type="text" name="name"/>
	<label>Enter Hobby</label>
	<input type="text" name="hobby"/>
	<label>Enter any type of living thing</label>
	<input type="text" name="living"/>
	<label>Say Something nice to someone</label>
	<input type="text" name="desc"/>
	<input type="submit" value="Send" />	
	</div>
</form>
</body>
</html>