<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Home page</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="top">
  <h1>Edit Expense</h1>
	<h3><a href="/">Go back</a></h3>
</div>
<div class="editform">
<form:form action="/edit/form/${id}" method="post" modelAttribute="expenseForm">
  <form:label path="expenseName">Expense Name:</form:label>
  <form:input  type="text" id="expenseName" path="expenseName" />
      <form:errors path="expenseName" cssClass="error" />


  <form:label path="vendor">Vendor:</form:label>
  <form:input  type="text" id="vendor" path="vendor" />
  <form:errors path="vendor" cssClass="error" />

  <form:label path="amount">Amount:</form:label>
  <form:input  type="number" id="amount" path="amount" />
  <form:errors path="amount" cssClass="error" />

  <form:label path="descripiton">Description:</form:label>
  <form:textarea  id="description" path="descripiton"></form:textarea>
  <form:errors path="descripiton" cssClass="error" />
  
    <input class="buttondiv editbtn" type="submit" value="Submit" />
  
</form:form>
</div>
</body>
</html>
