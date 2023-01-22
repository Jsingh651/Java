<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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
<link rel="stylesheet" href="/css/style.css" />
<title>Top 10</title>
</head>
<body>
<div class="topt">
<h1>Top ten songs</h1>
<h1><a href="/dashboard">Dashboard</a></h1>
</div>

<div class="bottomg yttg">
  <c:forEach var = "s" items="${songs}">
      <h3><c:out value="${s.ratings}"/> - <a href="/showPage/${s.id}"><c:out value="${s.name}"/></a> - <c:out value="${s.artist}"/></h3>
    </c:forEach>
</div>
</body>
</html>