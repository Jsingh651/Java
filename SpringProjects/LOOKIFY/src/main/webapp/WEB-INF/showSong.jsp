<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css" />
<title><c:out value="${song.name}"/></title>
</head>
<body>
	
<div class="topt">
	<h1>Song by <c:out value ="${song.artist}"/></h1>
	<h1><a href="/dashboard">Dashboard</a></h1>
</div>

<div class="bottomg yttg">
	<h2>Song Name: <c:out value="${song.name}"/></h2>	
	<h2>Artist Name: <c:out value="${song.artist}"/></h2>	
	<h2>Ratings: <c:out value="${song.ratings}"/></h2>	
	<h4><a href="/delete/${song.id}">Delete</a></h4>	
</div>			
				


								
</body>
</html>