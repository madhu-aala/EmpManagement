<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #f2f2f2;
}

h2 {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 10px;
}

form {
	width: 50%;
	margin: 0 auto;
	text-align: center;
}

input[type="number"] {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	width: 15%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaints Track</title>
</head>
<%
	String message = (String) session.getAttribute("message");
	String type = (String) session.getAttribute("type");
	session.removeAttribute("message");
	session.removeAttribute("type");
%>
<body>
	<div align="center">
		<h2 align="center">TRACK COMPLAINTS</h2>
		<%
			if (message != null) {
		%>
		<%
			if (type.equals("success")) {
		%>
		<h2 align="center" style="color: green;"><%=message%></h2>
		<%
			} else {
		%>
		<h2 align="center" style="color: red;"><%=message%></h2>
		<%
			}
			}
		%>
		<form action="TrackComplaintsAction.do" method="post">
			<input type="number" name="complaintID" maxlength="8" placeholder="Complaint ID"><br> <input type="submit" value="TRACK" style="font-weight: bolder;">
		</form>
	</div>
</body>
</html>