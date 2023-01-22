<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP project</title>
</head>
<body>
<h1>Hello World!</h1>
	<c:forEach var="fruits" items="${fruits}">
	 <c:if test="${!fruits.contains('Banana')}">
    <p><c:out value="${fruits}"/><p>
</c:if>	
	</c:forEach>
</body>
</html>