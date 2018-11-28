<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>J P Morgan Chase</h1>
	<form action="authanticate" method= 'POST'>
	<div>
		<br/>
		<label style="color:Red"> ${msg}</label><br /><br />
		User Name: <input type="text" name="username"><br /><br />
		Password: <input type="password" name="password"><br /><br />
		<input type="submit" value="Login">
		<input type="reset" Value="Reset">
	</div>
	</form>
	</body>
</html>