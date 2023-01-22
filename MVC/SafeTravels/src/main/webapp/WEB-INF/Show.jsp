<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Home page</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="top">
  <h1>Expense Details for <c:out value = "${findexpense.expenseName}"/></h1>
	<h3><a href="/">Go back</a></h3>
</div>
 
 <div class="main">
  <div class="label">
 <h1>Expense Name:</h1>
 <h1>Vendor:</h1>
 <h1>Expense Description:</h1>
 <h1>Amount:</h1>
 </div>
 <div class="value">
 <h1><c:out value = "${findexpense.expenseName}"/></h1>
  <h1><c:out value = "${findexpense.vendor}"/></h1>
  <h1><c:out value = "${findexpense.descripiton}"/></h1>
  <h1>$<c:out value = "${findexpense.amount}"/></h1>
  
 </div>
 </div>

</body>
</html>
