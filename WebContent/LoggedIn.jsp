<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body> 

welcome ${username}
<form  action="${pageContext.request.contextPath}/LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
<form name ="actions" method = "post" action="${pageContext.request.contextPath}/loginservlet">
<input id="btn1" name ="btn1" type= "submit" value= "Courses" action="${pageContext.request.contextPath}/loginservlet">
<input id="VPC" name = "btn2" type= "submit" value= "View Prof/Course" >
<input id="EPC" name = "btn3" type= "submit" value= "Edit Prof/Course" >


</html>