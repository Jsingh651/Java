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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="top">
<div class="topsearch">
<h2><a href="/showAdd">Add Song</a></h2>
<h2 class="songslink"><a href="/topTen">Top Songs</a></h2>
</div>

<div class="formdiv">
<form action="/dashboard" method="post">
<input class="artistsearch" type="text" name="artist" value="" />
<input class="submittbn" type="submit" value="Search artist" />
</form>
</div>
</div>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Ratings</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var = "s" items="${songs}">
    <tr>
      <td><a href="/showPage/${s.id}"><c:out value="${s.name}"/></a></td>
	  <td><c:out value="${s.ratings}"/></td>
	  <td><a href="/delete/${s.id}">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
   
</body>
</html>