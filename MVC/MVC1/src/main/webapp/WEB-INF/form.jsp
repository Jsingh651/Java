<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Insert</title>
</head>
<body>

<h1><a href="/books">Look at books</a></h1>
<form:form action="/api/books" method="post" modelAttribute="book">
<div>
<form:label path="title">Title</form:label>
	<form:errors path="title" class="text-danger"/>
	<form:input type="text" path="title" />
	
</div>

<div>
<form:label path="description">Description</form:label>
	<form:errors path="description" class="text-danger"/>
	<form:input type="text" path="description" />
</div>

<div>
<form:label path="language">Language</form:label>
<form:errors path="language" class="text-danger"/>
<form:input type="text" path="language" />
</div>
	
<div>
<form:label path="num_of_pages">Number of Pages</form:label>
<form:errors path="num_of_pages" class="text-danger"/>
<form:input type="text" path="num_of_pages" />
<input type="submit"value="Submit"/>
</div>
	
	
	
</form:form>
</body>
</html>