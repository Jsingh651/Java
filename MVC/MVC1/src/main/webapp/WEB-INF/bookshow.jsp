<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Insert</title>
</head>
<body>
<h1><a href="/books">All Books</a></h1>

<h3>Title: <c:out value="${book.title}"/></h3>
<p>Description: <c:out value="${book.description}"/></p>
<p>Language: <c:out value="${book.language}"/></p>
<p>Pages: <c:out value="${book.num_of_pages}"/></p>

</body>
</html>