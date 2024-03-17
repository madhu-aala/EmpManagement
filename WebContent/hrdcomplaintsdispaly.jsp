<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.ResultSet"%>

<html>
<head>
<style>
body {
	background-color:aqua; ;
}
table, th, td {
	border: 1px solid black;border-bottom-color: gray;azimuth:center;background-color:lime; :
	
}
th, td {
	padding: 15px;
}
input[type="button"]{
    width: 15%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaints</title>
</head>

<%
ResultSet rs = (ResultSet) session.getAttribute("rs");
%>
<body>
	<h1 align="center" style="font-weight: bolder;"> COMPLAINTS </h1>
	<form action="ComplaintsResponceAction.do" method="post">
	<input type="hidden" name="jspName" value="hrdcomplaintsdisplay" >
	<table align="center">
	<tr>
	<th style="font-weight: bold;">COMPLAINT ID</th>
	<th style="font-weight: bold;">EMPLOYEE ID</th>
	<th style="font-weight: bold;">COMPLAINTS</th>
	<th style="font-weight: bold;">STATUS</th>
	<th style="font-weight: bold;">COMMENTS</th>
	<th style="font-weight: bold;">EMPLOYEE COMMENT</th>
	<th style="font-weight: bold;">RESOVLED OR NOT</th>
	</tr>
	<% while(rs.next()){%>
	<tr>
	<td><input type="submit" name="complaintID" value=<%= rs.getLong(1) %> ></td>
	<td><%= rs.getInt(2) %></td>
	<td><%= rs.getString(3) %></td>
	<td><%= rs.getString(5)%></td>
	<td><%= rs.getString(4) %></td>
	<td><%= rs.getString(6)%></td>
	<td><%= rs.getString(7) %></td>
	</tr>
	<% } %>
	</table>
	<div align="center">
	<a href="hrdlogin.jsp" ><input type="button" value="HOME" style="font-weight: bold;"></a>
	</div>
	</form>	
</body>
</html>