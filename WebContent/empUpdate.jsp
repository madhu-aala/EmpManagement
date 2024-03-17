<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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

input[type="text"],input[type=number] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
}

input[type="submit"],input[type="button"] {
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
<title>Employee Update</title>
</head>
<% String message = (String) session.getAttribute("message");
	String type = (String) session.getAttribute("type");
	session.removeAttribute("message");
	session.removeAttribute("type");
%>
<body>
<div align="center">
<% if(message != null) { %>
	<% if(type.equals("success")) { %>
	<h2 align="center" style="color: green;"><%= message %></h2>
	<% } else { %>
	<h2 align="center" style="color: red;"><%= message %></h2>
<% }  } %>
	<form action="UpdateSearchEmployeeAction.do" method="post">
	<h3>EMPLOYEE ID</h3>
	<div align="center" style="color: red;font-weight: bold;"><html:errors/></div>
	<input type="number" placeholder="Input Employee ID" name="empID" maxlength="4" ><br>
	<input type="submit" value="SUBMIT" style="font-weight: bolder;">
	<a href="hrdlogin.jsp"><input type="button" value="HOME" style="font-weight: bold;"></a>
	</form>
</div>
</body>
</html>