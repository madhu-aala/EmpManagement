<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<style>
h1 {
	color: darkgreen;
}

body {
	background-color: #f2f2f2;
}
</style>
<%
	HttpSession ses = request.getSession(false);
	Integer empID = (Integer) ses.getAttribute("empID");
%>
<body>
	<h1 align="center">EMPLOYEE REGISTERED SUCCESSFULLY..</h1>
	<h3 align="center">
		Employee ID is
		<%
		out.print(empID);
	    %>
	</h3>
	<br>
	<br>
	<div align="center">
		<a href="hrdlogin.jsp">BACK TO HOME</a>
	</div>
</body>
</html>