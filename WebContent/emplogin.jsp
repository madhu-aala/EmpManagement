<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
 <%@ page import="com.empmanagement.form.LoginForm" %>
 <%@ page errorPage="error.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body { 
    background-color: #f2f2f2;
}

h3 {
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 10px;
}

form {
    width: 50%;
    margin: 0 auto;
    text-align: center;
}

input[type="submit"] {
    width: 40%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    text-shadow: black;
}

input[type="submit"]:hover {
    background-color: #45a049;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
</head>
<%
HttpSession ses = request.getSession(false);
Integer empID=(Integer)ses.getAttribute("empID");
%>

<body>
<h1 align="center" style="font-weight: bolder;"> HOME PAGE </h1>
<form action="EmpLoginAction.do" method="post">
	<input type="hidden" name="empID" value= <%= empID.intValue() %>>
	<input type="submit" name="direction" value="MY PROFILE" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="EMPLOYEE SEARCH" width="50px" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="TIMESHEET" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="COMPLAINTS" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="TRACK COMPLAINTS" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="HOLIDAYS" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="RESET PASSWORD" width="50px" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="LOGOUT" style="font-weight: bolder;">
</form>
</body>
</html>