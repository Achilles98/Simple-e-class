<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hi</title>
</head>
<body>
 <form name ="LoginForm" method = "post" action="${pageContext.request.contextPath}/loginservlet">
	    	       <label for="username"> Username: </label> 
	    	       <input id="username" type="text" name="username" ><br>
	    	       <label for="pass"> Password: </label> 
	    	       <input id="pass" type="password" name="pass" ><br><br>
	    	       
	    	       <input id="btn" type= "submit" name = "btn" value= "Log In" >
	    	       
	    	       </form>
	    	       <button onclick="myFunction()">Show Password</button>
<script>
function myFunction() {
	var x = document.getElementById("pass");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
	}
</script>

</body>
</html>