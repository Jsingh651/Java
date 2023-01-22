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
    <title>Dojos register</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
       <div class="topnav">
    <h1 class="title">The Dojo Hall</h1>
    <a class="ninjaroute" href="/ninja">Create Ninja</a>
</div>
<div class="maincont">
        <div class="left">
            <form:form action="/create/dojo" method="post" modelAttribute="dojo">
                <h1 class="title top">Dojo generator</h1>
                <div class="sub">
                <h1 class="subtitle">Enter a Dojo Name below </h1>
                <form:input class="input-dojo" type="text" path="name" placeholder="Dojo generator"/>
                <input class="submitbtn" type="submit" value="Click me!!">
            </div>

            </form:form>
            
            
            
        </div>
        <div class="right">
            <h1 class="title top">The Dojo List</h1>
            <h3 class="title top sub-title">Pick a Dojo!!</h3>
            <div class="dojo-container">
            <c:forEach var="d" items = "${dojos}">
            <h1 class="newls"><a href="/showDojo/${d.id}"><c:out value = "${d.name}"/></a></h1>
            </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
