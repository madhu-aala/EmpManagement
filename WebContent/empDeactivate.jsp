<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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

input[type="text"], input[type=number] {
	width: 40%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
}

input[type="submit"],input[type="button"] {
	width: 20%;
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
<title>Employee Deactivate</title>
</head>
<% String message = (String) session.getAttribute("message");
	String type = (String) session.getAttribute("type");
	session.removeAttribute("message");
	session.removeAttribute("type");
	Integer empID = (Integer) session.getAttribute("empID");
%>
<body>
	<div align="center">
		<form action="DeactivateAction.do" method="post">
		<div style="color: red;font-weight: bold;"><html:errors/></div>
			<h2>EMPLOYEE DEACTIVATION</h2>
			<% if(message != null) { %>
			<% if(type.equals("success")) { %>
			<h2 align="center" style="color: green;"><%= message %></h2>
			<% } else { %>
			<h2 align="center" style="color: red;"><%= message %></h2>
			<% }  } %>
			<input type="number" placeholder="Enter Employee ID" name="empID" maxlength="4">
			<h3>REASON FOR DEACTIVATION</h3>
			<textarea rows="5" cols="60" id="deactivate" maxlength="200" name="reason"></textarea> <br> <br> 
			<input type="submit" value="DEACTIVATE" style="font-weight: bolder;">
			<a href="hrdlogin.jsp"><input type="button" value="HOME" style="font-weight: bold;"></a>
		</form>
	</div>
</body>
</html>