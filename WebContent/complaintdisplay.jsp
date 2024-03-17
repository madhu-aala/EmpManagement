<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="com.empmanagement.form.TrackComplaintsForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMPLAINTS DISPLAY</title>
<style>
body {
	background-color: #f2f2f2;
}

table, th, td {
	border: 1px solid black;
	border-bottom-color: gray;
	azimuth: center;
	background-color: lime;
	:
}

th, td {
	padding: 15px;
}

form {
	width: 50%;
	margin: 0 auto;
	text-align: center;
}

input[type="text"] {
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
<div align="left" style="color: red;font-weight: bold;"><html:errors/></div>
</head>
<%
	TrackComplaintsForm track = (TrackComplaintsForm) session.getAttribute("track");
%>
<h1 align="center">COMPLAINT STATUS</h1>
<body>
	<%
		if (track.getEmpID() == 0) {
	%>
	<h3 align="center" style="color: red; font-weight: bold;">INVALID
		COMPLAINT ID...</h3>
	<%
		} else {
	%>
	<div align="center">
		<table>
			<tr>
				<th style="font-weight: bold;">COMPLAINT ID</th>
				<th style="font-weight: bold;">EMPLOYEE ID</th>
				<th style="font-weight: bold;">COMPLAINTS</th>
				<th style="font-weight: bold;">STATUS</th>
				<th style="font-weight: bold;">COMMENTS</th>
				<th style="font-weight: bold;">EMPLOYEE COMMENT</th>
				<th style="font-weight: bold;">RESOVLED OR NOT</th>
			</tr>
			<tr>
				<td><%= track.getComplaintID() %></td>
				<td><%=track.getEmpID()%></td>
				<td><%=track.getComplaints()%></td>
				<td><%=track.getStatus()%></td>
				<td><%=track.getComments()%></td>
				<td><%=track.getEmpComment()%></td>
				<td><%=track.getEmpComplaintResponce()%></td>
			</tr>
		</table>

	</div>
	<script type="text/javascript">
		function ShowHideDiv() {
			var chkYes = document.getElementById("chkNo");
			var dvPassport = document.getElementById("dvPassport");
			dvPassport.style.display = chkYes.checked ? "block" : "none";
		}
	</script>
	<%
		if (!track.getStatus().equals("pending")) {
	%>
	<% if(track.getEmpComplaintResponce().equals("NO")) {
	%>
	<br>
	<br>
	<br>
	<form action="EmpComplaintResponceAction.do" method="post">
		<div align="center">

			<h3 align="center" style="font-weight: bold;">IS YOUR PROBLEM IS
				SOLVED OR NOT ?</h3>
			<br> <input type="radio" id="chkYes" name="empComplaintResponce"
				onclick="ShowHideDiv()" value="YES" /> <b>YES</b>
			&nbsp;&nbsp;&nbsp; <input type="radio" id="chkNo"
				name="empComplaintResponce" onclick="ShowHideDiv()" value="NO" /> <b>NO</b>
			<br>
			<br> <input type="hidden" name="complaintID"
				value=<%=track.getComplaintID()%>>
			<div id="dvPassport" style="display: none">
				<h3 align="center" style="font-weight: bold;">ENTER YOUR
					COMMENT ON HRD ACTION</h3>
				<input type="text" name="empComment" align="middle" value="resolved">
			</div>
			<br> <input type="submit" value="SUBMIT"
				style="font-weight: bolder;">
		</div>
	</form>
	<% } %>
	<%
		}
	%>
	<%
		}
	%>
</body>
</html>