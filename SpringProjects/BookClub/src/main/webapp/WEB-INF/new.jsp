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
    <link rel="stylesheet" href="/css/new.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="titlediv">
		<div class="titletop">
	   		<h1 class="title">Welcome, <c:out value="${user.userName}"/>!</h1>
			<h3>Books from everyone's shelves:</h3>
		</div>
		<div class="titlebottom">
			<h2><a href="/logout">Logout</a></h2>
			<h2><a href="/create/book">+ Add to my shelf!</a></h2>
		</div>
	</div>

<div class="bottomhalf">
<table>
<thead>
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author Name</th>
    <th>Posted By</th>
    <th>Actions</th>
    </tr>
</thead>
<c:forEach var="book" items = "${books}">
<c:if test="${book.borrower.id == null || userId == book.user.id}">
  <tr>
    <td>${book.id}</td>
    <td><a href="/books/${book.id}">${book.title}</a></td>
    <td>${book.author}</td>
    <td>${book.user.userName}</td>
    <td><c:if test="${book.user.id == userId}">
    	<div class="tddd" class="div">
    		<a  href="/edit/${book.id}"><button class="butt fved">Edit</button></a>
    			<form id="fomrmf" action="/books/${book.id}" method="post" >
        			<input type="hidden" name="_method" value="DELETE"/>
       				<button class="buttn fve">Delete</button>
    			</form>
		</c:if>
		<c:if test="${book.user.id != userId}">
			<a href="/add/borrower/${book.id}"><button class="butt">Borrow</button></a>
		</c:if>
	</td>
    		</div>
  </tr>
  </c:if>
</c:forEach>
</table>

<!--  --><!--  --><!--  -->
</div>

<h3 class="titleff">Books you've borrowed:</h3>

<table>
<thead>
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author Name</th>
    <th>Posted By</th>
    <th>Actions</th>
    </tr>
</thead>
<c:forEach var="book" items = "${user.borrowed_books}">
  <tr>
    <td>${book.id}</td>
    <td><a href="/books/${book.id}">${book.title}</a></td>
    <td>${book.author}</td>
    <td>${book.user.userName}</td>
	<td>
	<div class="tddd" class="div">
	<a href="/return/borrower/${book.id}"><button class="butt refv">Return</button></a>
		</div>	
	</td>
  </tr>
 
</c:forEach>
</table>






</body>
</html>