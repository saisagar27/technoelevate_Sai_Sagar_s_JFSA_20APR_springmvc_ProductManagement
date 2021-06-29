<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Navbar.jsp"%>
    <% String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./del" maethod="post">
<table>
<tr>
<td>Product id</td>
<td>=</td>
<td><input name="pid"></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>
<%if(msg!=null){ %><h2><%=msg %></h2><%} %>

</body>
</html>