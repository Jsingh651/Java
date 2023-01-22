<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<div class="top">
<a href="/">Dashboard</a>
<a href="/languages/${language.id}/delete">Delete</a>
</div>

<form:form action = "/languages/${language.id}" method="post" modelAttribute="LanguageAttribute">

	<label for="name">Name:</label>
		<form:errors path="name" cssClass="error" />
		<form:input path="name"/>
	
	<label for="creator">Creator:</label>
		<form:errors path="creator" cssClass="error" />
		<form:input path="creator"/>
		
	<label for="version">Version:</label>
		<form:errors path="version" cssClass="error" />
		<form:input path="version"/>
	
	<input class="buttondiv editbtn" type="submit" value="Submit" />
</form:form>

</body>
</html>