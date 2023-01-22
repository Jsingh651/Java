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
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1 class="title">Welcome</h1>
    <div class="main-container">
        <div class="form">
            <h1>Register</h1>
            <form:form action="/register" method="post" modelAttribute="newUser">
				<form:errors path="userName"/>
            
                <form:input path="userName" class="fir" type="text" autocomplete="off" placeholder=" User Name"/>
				
				<form:errors path="email"/>
                <form:input path="email" type="text" autocomplete="off" placeholder="Email"/>

				<form:errors path="password"/>
                <form:input path="password" class="pswlst" type="password" autocomplete="off" placeholder="Password "/>

				<form:errors path="confirm"/>
                <form:input path="confirm" class="pswlst2" type="password" autocomplete="off"
                    placeholder="Password "/>

                <input class="pswlbl3" type="submit" value="SUBMIT">
            </form:form>
        </div>
        <div class="error-dav">
        </div>

        <div class="login-box">
            <h1>Login</h1>
            <form:form action="/login" method="post" class="formlogin" modelAttribute="newLogin">
                <div class="user-box">
                
                	<form:errors path = "email"/>
                    <form:input type="email" path="email" required="" placeholder="Email"/>
                </div>
                <div class="user-box">
                	<form:errors path = "password"/>
                    <form:input type="password" path="password" value="" required="" placeholder="Password"/>
                </div>
                <input class="pswlbl3 pswlbl2" type="submit" value="SUBMIT"/>
                <div class="d">
                </div>
            </form:form>

        </div>
    </div>
</body>
</html>