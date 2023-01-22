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
    <link rel="stylesheet" href="/css/login.css"> <!-- change to match your file/naming structure -->
    <script src="/javascript/new.js" defer></script>

    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
   

 <div class="total">
        <div class="show">
            <div class="rioght">Sign Up</div>
            <div class="leftt">Log In </div>
        </div>
        <button id="toggle-button"></button>
    </div>

    <div class="card">
        <div class="content">
            <div class="front">
                <div class="form">
                    <h4>Sign Up</h4>
                    <form:form action="/register" method="post" modelAttribute="newUser">
                        <form:errors class='errors' path="userName"/>
                        <form:input  path="userName" class="fir" type="text" autocomplete="off" placeholder=" User Name"/>
						<form:errors class='errors' path="email"/>
                        <form:input  path="email" type="text" autocomplete="off" placeholder="Email"/>
                        <form:errors class='errors' path="password"/>
                        <form:input  path="password" class="pswlst" type="password" autocomplete="off" placeholder="Password "/>
                        <form:errors class='errors' path="confirm"/>
                        <form:input path="confirm" class="pswlst2" type="password" autocomplete="off" placeholder="Password "/>
                        <button class="custom-btn btn-14">Submit</button>
                    </form:form>
                </div>
            </div>
            <div class="back">
                <h4>Log In</h4>
                <form:form action="/login" method="post" modelAttribute="newLogin">
						<form:errors class='errors' path="email"/>
                        <form:input type="email" path="email" required="" placeholder="Email"/>
						<form:errors class='errors' path="password"/>
                        <form:input type="password" path="password" value="" required="" placeholder="Password"/>
                        <button class="custom-btn btn-14">Submit</button>
                    </form:form>
            </div>
        </div>
    </div>

</body>
</html>