<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="com.empmanagement.bean.DisplayResponceBean"%>
<!DOCTYPE html>
<html>
<head>
<title>My Profile</title>
<style>
body {
	background-color:#f2f2f2 ;
}
table, th, td {
	border: 1px solid black;border-bottom-color: gray;azimuth:center;background-color:lime; :
	
}
th, td {
	padding: 15px;
}
button{
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
Integer empID = (Integer) ses.getAttribute("empID");
DisplayResponceBean displayBean=(DisplayResponceBean)ses.getAttribute("displayBean");
%>
<body>
	<h2 align="center">MY PROFILE</h2>
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
		</tr>


		<tr>
			<td><%= displayBean.getEmpName() %></td>
			<td><%= displayBean.getEmpID()%></td>
			<td><%= displayBean.getEmpCurrentCity()%></td>
			<td><%= displayBean.getEmpEmail()%></td>
			<td><%= displayBean.getEmpMobile()%></td>
			<td><%= displayBean.getEmpDesignation()%></td>
			<td><%= displayBean.getEmpDepartmant()%></td>
			<td><%= displayBean.getEmpJoinDate()%></td>
			<td><%= displayBean.getEmpGender()%></td>
		</tr>
	</table><br><br><br>
	<div align="center">
	<button onclick="goBack()" style="font-weight: bold;">BACK</button>
	</div>
	<script>
	function goBack(){
		window.history.back();
	}
	</script>
</body>
</html>
