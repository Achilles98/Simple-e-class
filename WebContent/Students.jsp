<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Student</title>
</head>
<body>
Hello Student
<form  action="${pageContext.request.contextPath}/LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
<form name ="actions" method = "post" action="${pageContext.request.contextPath}/loginservlet">
	<input id="viewgrades" name ="viewgrades" type= "submit" value= "View Grades">
	<input id="semestergrades" name ="semestergrades" type= "submit" value= "View Semester Grades">
	<input id="avggrade" name ="avggrade" type= "submit" value= "View your Grades' Average">
	

</body>
</html>