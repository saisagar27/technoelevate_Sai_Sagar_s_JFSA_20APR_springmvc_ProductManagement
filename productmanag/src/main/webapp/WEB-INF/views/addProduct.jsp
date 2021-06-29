<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Navbar.jsp" %>
    <% String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./add" method="post">
	<table>
	<tr>
	<td>Product Id</td>
	<td>=</td>
	<td><input type="number" name="pid"></td>
	</tr>
	<tr>
	<td>Product Name</td>
	<td>=</td>
	<td><input type="text" name="pname"></td>
	</tr>
	<tr>
	<td>Product MFG Date</td>
	<td>=</td>
	<td><input type="date" name="mfgDate"></td>
	</tr>
	<td>Product Exp Date</td>
	<td>=</td>
	<td><input type="date" name="expDate"></td>
	</tr>
	</tr>
	<td>Product Price</td>
	<td>=</td>
	<td><input type="number" name="price"></td>
	</tr>
	
	<tr>
	<td><input type="submit" value"submit"/></td>
	</tr>
	</table>
	</form>
	
	<%if( msg!=null && !msg.isEmpty()) {%>
	<h2><%=msg %></h2>
	<%} %>

</body>
</html>