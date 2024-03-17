<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
input[type=password],input[type=number] {
  width: 100%;
  padding: 8px 15px;
  margin: 6px 0;
  box-sizing: border-box;
  border: none;
  border-bottom: 2px solid gray;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="button"] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

label {
  font-weight: bold;
}

h2 {
  text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FORGET PASSWORD</title>
</head>
<%
String message = (String) session.getAttribute("message");
String type = (String) session.getAttribute("type");
session.removeAttribute("message");
session.removeAttribute("type");
%>
<body>
<h1 align="center">FORGET PASSWORD</h1>
<form action="/EmpManagement/ForgetPasswordAction.do" method="post">
	<% if(message != null) { %>
	<% if(type.equals("success")) { %>
	<h2 align="center" style="color: green;"><%= message %></h2>
	<% } else { %>
	<h2 align="center" style="color: red;"><%= message %></h2>
	<% }  } %>
	
	<div align="center" style="color: red;font-weight: bold;"><html:errors/></div>
		<table align="center">
		<tr><td><label for="employeeType">EMPLOYEE TYPE :</label></td><td><select id="loginType" name="loginType">
				<option value="hrd">HR Department</option>
				<option value="emp">Employee</option>
			</select></td></tr>
		<tr><td><label>Employee ID :</label></td><td><input type="number" name="empID" maxlength="10" required></td></tr>
		<tr><td><label>Contact:</label></td><td><input type="number" name="empMobile" maxlength="10" required></td></tr>
		<tr><td><label>Aadhaar Number:</label></td><td><input type="number" id="empAadhaarNumber" name="empAadhaarNumber" maxlength="12" required></td></tr>
		<tr><td><label>New Password:</label></td><td><input type="password" id="empNewPassword" name="empNewPassword" required></td></tr>
		<tr><td><label>Confirm Password:</label></td><td><input type="password" id="empConfirmPassword" name="empConfirmPassword" required></td></tr>
  		<tr><td><input type="submit" value="SUBMIT" style="font-weight: bolder;"></td><td><a href="hrdlogin.jsp"><input type="button" value="BACK" style="font-weight: bold;"></a></td></tr>
</table>
			
</form>
</body>
</html>