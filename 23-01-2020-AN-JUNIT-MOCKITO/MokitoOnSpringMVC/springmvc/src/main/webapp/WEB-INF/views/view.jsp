<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VIEW</title>
</head>
<body>
<h1>View Employee Details</h1>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Role</th></tr>  
   <c:forEach items="${emplist}" var="emp">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.role}</td>  
   </tr>  
   </c:forEach>  
</table>  
<br/>   
 <br/><a href="index.jsp">BACK TO HOME</a>  
</body>
</html>