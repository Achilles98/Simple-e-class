<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
<form  action="${pageContext.request.contextPath}/LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
<form name ="actions" method = "post" action="${pageContext.request.contextPath}/loginservlet">
	<input id="btn5" name ="btn5" type= "submit" value= "Graded Courses">
	<input id="btn6" name ="btn6" type= "submit" value= "Set Grades">
	


</body>
</html>