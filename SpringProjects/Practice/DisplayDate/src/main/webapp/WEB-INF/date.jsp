<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<meta charset="UTF-8">
<title>Date template</title>
</head>
<body>
<h1 class="datese">The date today is <c:out value="${newdate}"></c:out></h1>
</body> 
</html>