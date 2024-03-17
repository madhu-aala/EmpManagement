<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h3 {
  color: #5c5c5c;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
}

a {
  color: #006699;
  text-decoration: none;
}

a:hover {
  color: #ff6600;
  text-decoration: underline;
}

body {
  background-color: #f2f2f2;
}
input[type="submit"] {
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
<%
Integer empID = (Integer) session.getAttribute("empID");
%>

<% if( empID == 0 ) {%>
<script type="text/javascript">
alert("PLEASE LOGIN IN PROPERLY...");
</script> 
<% } else {%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HRD Login</title>
</head>
<body>
<h1 align="center" style="font-weight: bolder;"> HOME PAGE </h1>
<div align="center">
<form action="HRDLoginAction.do" method="post">
	<input type="submit" name="direction" value="REGISTRATION" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="UPDATE" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="EMPLOYEE SEARCH" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="COMPLAINTS" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="DEACTIVATE EMPLOYEE" style="font-weight: bolder;"><br>
	<input type="submit" name="direction" value="LOGOUT" style="font-weight: bolder;">
</form>
</div>
<% } %>
</body>
</html>