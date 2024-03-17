<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="com.empmanagement.bean.DisplayResponceBean"%>
<%@page import="javax.servlet.http.HttpSession"%>
 <!DOCTYPE html>
<html>
<head>
<title>Employee details</title>
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
body {
  background-color: #f2f2f2;
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
</head>
<%
HttpSession ses = request.getSession(false);
DisplayResponceBean detailBean =(DisplayResponceBean)ses.getAttribute("detailBean");
%>
<body>
	<h2 align="center">EMPLOYEE DETAILS</h2>
	<% if(detailBean.getEmpName() == null){ %>
	<h3 align="center" style="color: red; font-weight: bold;">INVALID EMPLOYEE ID...</h3>
	<% } else { %>
	<table align="center" style=width: 100%">
		<tr>
			<th>NAME</th>
			<th>EMP ID</th>
			<th>CITY</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>DESIGNATION</th>
			<th>DEPARTMENT</th>
			<th>JOINING DATE</th>
			<th>GENDER</th>
			<th>STATUS</th>
		</tr>
		
		
		<tr>
			<td><%= detailBean.getEmpName() %></td>
			<td><%= detailBean.getEmpID()%></td>
			<td><%= detailBean.getEmpCurrentCity()%></td>
			<td><%= detailBean.getEmpEmail()%></td>
			<td><%= detailBean.getEmpMobile()%></td>
			<td><%= detailBean.getEmpDesignation()%></td>
			<td><%= detailBean.getEmpDepartmant()%></td>
			<td><%= detailBean.getEmpJoinDate()%></td>
			<td><%= detailBean.getEmpGender()%></td>
			<td><%= detailBean.getEmpStatus()%></td>
		</tr>
	</table>
	<% } %>
<!-- <div align="center">
	<a href="emplogin.jsp"><input type="button" value="HOME" style="font-weight: bold;"></a>
	<a href="hrdlogin.jsp"><input type="button" value="HOME" style="font-weight: bold;"></a>
	</div> -->
</body>
</html>