<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/styles.css" />
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Items</title>
</head>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
	    <c:forEach var="fruit" items="${fruits}">
    <tr>
      <td><c:out value="${fruit.name}"/></td>
      <td><c:out value="${fruit.price}"/></td>
    </tr>
	</c:forEach>
  </tbody>
</table>
</body>
</html>