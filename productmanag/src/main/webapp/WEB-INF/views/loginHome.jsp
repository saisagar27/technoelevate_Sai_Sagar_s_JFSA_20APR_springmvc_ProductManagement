<%@page import="com.te.productmanag.beans.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Navbar.jsp" %>
    <% String name=(String)request.getAttribute("name"); %>
    <% List<Product> infos=(List)request.getAttribute("infos"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<fieldset>
	<%if(name!=null){ %>
		<h1 style="color: maroon; text-decoration: underline;">
			Welcome <%=name%></h1>
			<%} %>
	</fieldset>

	<%
		if (infos != null) {
	%>
	<fieldset>
		<legend>All Records</legend>
		<table  border="1" style="width:100%">
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Expiry Date</th>
				<th>Manufacturing Date</th>
			</tr>
			<%
				for (Product info : infos) {
			%>
			<tr>
				<td><%=info.getPid()%></td>
				<td><%=info.getPname()%></td>
				<td><%=info.getPrice()%></td>
				<td><%=info.getExpDate()%></td>
				<td><%=info.getMfgDate()%></td>
			</tr>
			<%
				}
			%>
		</table>

	</fieldset>
	<%
		}
	%>
</body>
</html>