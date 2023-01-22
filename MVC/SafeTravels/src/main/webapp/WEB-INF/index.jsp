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
<link rel="stylesheet" href="/path/to/bootstrap.css" />
</head>
<body>
  <h1>Save Travels</h1>
  <div class="main_cont">
    <div class="left_cont">
    
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Expense Name</th>
            <th scope="col">Vendor</th>
            <th scope="col">Amount</th>
			<th scope="col">Actions</th>
            
          </tr>
        </thead>
        <tbody>
        <c:forEach var="e" items="${expenses}">
          <tr>
            <td class="leftcol"><a href="/show/${e.id}"><c:out value="${e.expenseName}"/></a></td>
            <td class="midcol"><c:out value="${e.vendor}"/></td>
            <td class="rightcol">$<c:out value="${e.amount}"/></td>
			<td class="rightcol ri"><a href="/delete/${e.id}">Delete</a> | <a href="/edit/${e.id}">Edit</a></td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="right_cont">
<form:form action="/create/form" method="post" modelAttribute="expenseForm">
  <form:label path="expenseName" for="expenseName">Expense Name:</form:label>
  <form:errors path="expenseName" cssClass="error"/>
  <form:input  type="text" id="expenseName" path="expenseName" />


  <form:label path="vendor" for="vendor">Vendor:</form:label>
  <form:errors path="vendor" cssClass="error" />
  <form:input  type="text" id="vendor" path="vendor" />

  <form:label path="amount" for="amount">Amount:</form:label>
  <form:input  type="number" id="amount" path="amount" />
  <form:errors path="amount" cssClass="error" />

  <form:label path="descripiton" for="descripiton">Description:</form:label>
  <form:textarea  id="description" path="descripiton"></form:textarea>
  <form:errors path="descripiton" cssClass="error" />
  
    <input class="buttondiv editbtn" type="submit" value="Submit" />
  
</form:form>



    </div>
  </div>
  <script src="/path/to/bootstrap.js"></script>
  
</body>
</html>
