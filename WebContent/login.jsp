<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE html>

<html>
<head>
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

header .header {
	background-color: #fff;
	height: 45px;
}

header a img {
	width: 134px;
	margin-top: 4px;
}

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.login-page .form .login {
	margin-top: -31px;
	margin-bottom: 26px;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background-color: #328f8a;
	background-image: linear-gradient(45deg, #328f8a, #08ac4b);
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

body {
	background-color: #328f8a;
	background-image: linear-gradient(45deg, #328f8a, #08ac4b);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

</style>
<link rel="stylesheet" href="login.css">
<title>Login</title>
</head>
<% String message = (String) session.getAttribute("message");
	session.removeAttribute("message");
	Integer empID = (Integer) session.getAttribute("empID");
%>
<body>
	<div class="login-page">
		<div class="form"> 
			<div class="login">
				<div class="login-header">
					<h3>LOGIN</h3>
					<p>Please enter your credentials to login.</p>
				</div>
			</div>
			<%if(message != null) { %>
			<h3 align="center" style="color: red;"><%= message %></h3>
			<% } %>
			 <div style="color: red;font-weight: bold;"><html:errors/></div>
			<form action="/EmpManagement/LoginAction.do" class="login-form" path="/LoginAction.do" method="post">
				<label for="loginType">Login type :</label>
				<select id="loginType" name="loginType"  >
					<option value="hrd"  >HR Department</option>
					<option value="emp">Employee</option>
				</select>
				<input  type="number" id="uname" placeholder="username" required name="empID" maxlength="4" /> <br>
				<input type="password" id="pass" placeholder="password" required name="password"/><br> <br>
				<button id="btn">login</button><br><br>
				<a href="forgetpassword.jsp" style="color: red; font-weight: bold;">forget password?</a>
			</form>
		</div>
	</div><!--action="/EmpManagement/RegistrationAction.do"-->
	
</body>

</html>