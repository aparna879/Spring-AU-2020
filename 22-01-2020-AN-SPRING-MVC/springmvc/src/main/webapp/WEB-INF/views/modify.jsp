<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
</head>
<body>
<h1>Update Employee Details</h1>
<form action = "modify1" method = "POST">
   Employee Id: <input type = "text" name = "id">
   <br />
   Name: <input type = "text" name = "name" /><br />
   Role: <input type = "text" name = "role" /><br />
   <input type = "submit" value = "Submit"/>
</form>
 <br/><a href="index.jsp">BACK TO HOME</a>  
</body>
</html>