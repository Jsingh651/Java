<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/styles.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
 <h2>Name: <c:out value="${name}"/></h2>
  <h2>Item: <c:out value="${itemName}"/></h2>
   <h2>Price: <c:out value="${price}"/></h2>
    <h2>Description: <c:out value="${description}"/></h2>
     <h2>Vendor: <c:out value="${vendor}"/></h2>
     
</body>
</html>