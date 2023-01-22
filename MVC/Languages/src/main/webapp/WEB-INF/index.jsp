<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Home Page</title>
</head>
<body>

<div class="main_cont">
<div class="left_cont">
 <table class="table">
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
			<th scope="col">Actions</th>
            
          </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${languages}">
          <tr>
            <td class="leftcol"><a href="/languages/${e.id}"><c:out value="${e.name}"/></a></td>
            <td class="midcol"><c:out value="${e.creator}"/></td>
            <td class="rightcol"><c:out value="${e.version}"/></td>
			<td class="rightcol ri"><a href="/languages/${e.id}/delete">Delete</a> | <a href="/languages/${e.id}/edit">Edit</a></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
</div>

<div class="right_cont">
<form:form action = "/languages" method="post" modelAttribute="LanguageAttribute">

	<label for="name">Name:</label>
		<form:errors path="name" cssClass="error" />
		<form:input path="name"/>
	
	<label for="creator">Creator:</label>
		<form:errors path="creator" cssClass="error" />
		<form:input path="creator"/>
		
	<label for="version">Version:</label>
		<form:errors path="version" cssClass="error" />
		<form:input path="version"/>
	
	<input class="buttondiv editbtn" type="submit" value="Submit" />
</form:form>

</div>
</div>

</body>
</html>