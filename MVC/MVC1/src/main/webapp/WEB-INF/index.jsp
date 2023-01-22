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

<h1> <a href="/formpage">Create a book </a> </h1>

<c:forEach var="b" items="${books}">
<p>-------------------------------------------------------</p>

<p>Title: <a href="/books/${b.id}"><c:out value="${b.title}"/></a></p>
<p>Description: <c:out value="${b.description}"/></p>
<p>Language: <c:out value="${b.language}"/></p>
<p>Pages: <c:out value="${b.num_of_pages}"/></p>

</c:forEach>
</body>
</html>