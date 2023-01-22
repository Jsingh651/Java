<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>You have visited http://localhost:8080 
	<c:if test="${count == null && count <= 0}">
	0 times.
	</c:if>
	<c:if test = "${count > 0}">
	<c:out value="${count}"/> times.
	</c:if>
	</h3>
	<a href="/">Test another visit?</a>
	<a href="/clear">Clear session</a>
</body>
</html>