<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Show Page</title>
</head>
<body>

<div class="top">
<a href="/">Dashboard</a>
<a href="/languages/${findLanguage.id}/delete">Delete</a>
</div>

<div class="main-ff">
<h1>Name:   <c:out value="${findLanguage.name}"/></h1>
<h1>Creator:<c:out value="${findLanguage.creator}"/></h1>
<h1>Version:<c:out value="${findLanguage.version}"/></h1>
<h1><a href="/languages/${findLanguage.id}/edit">Edit</a></h1>


</div>
</body>
</html>