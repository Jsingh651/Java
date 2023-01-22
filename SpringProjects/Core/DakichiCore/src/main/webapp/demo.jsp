<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
</head>
<body>
<h1>Hello there</h1>
<% for(int i = 0; i <= 5; i++) { %>
<h1> The number is <%= i%></h1>
<% }%>

</body>
</html>