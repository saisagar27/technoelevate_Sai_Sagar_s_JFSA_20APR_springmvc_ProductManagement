<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <% String err=(String)request.getAttribute("err"); %>
  <% String errMsg=(String)request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<fieldset>
<legend>Login Page</legend>
<form action="./login" method="post">

<% if(err!=null) { %>
<h1><%= err %></h1>
<%} %>

<% if(errMsg!=null) { %>
<h1><%= errMsg %></h1>
<%} %>

	<table>
	<tr>
	<td>Admin Id</td>
	<td>:</td>
	<td><input type="number" name="id"/></td>
	</tr>
	
	<tr>
	<td>Admin Password</td>
	<td>:</td>
	<td><input type="password" name="pwd"/></td>
	</tr>
	
	<tr>
	<td><input type="submit" value="submit"></td>
	</tr>
	
</table>
</form>
</fieldset>

</body>
</html>