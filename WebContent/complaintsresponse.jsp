<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="com.empmanagement.form.TrackComplaintsForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #f2f2f2;
}
h4 {
	display:inline;
    font-weight: bold;
    margin-bottom: 10px;
}

form {
    width: 50%;
    margin: 0 auto;
    text-align: center;
}

input[type=number] {
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
h3 {
	color:black;
	display: inline;
}
</style>
<title>COMPLAINTS RESPONSE</title>

</head>
<%
	TrackComplaintsForm track = (TrackComplaintsForm) session.getAttribute("track");
%>
<body>
<div align="left" style="color: red;font-weight: bold;"><html:errors/></div>

	<h1 align="center" style="font-weight: bolder;"> COMPLAINTS RESPONSE </h1>
	<div align="center">
		<form action="ComplaintsResponceAction.do" method="post">
			<h3 align="left" style="padding-left: 100px ">COMPLAINT ID: <%=track.getComplaintID()%></h3>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<h3 align="right" style="padding-right: 100px">EMPLOYEE ID: <%=track.getEmpID()%></h3>
			<br><br><h4 style="font-style: italic;">COMPLAINT</h4><br>
			<h4 align="center"><%=track.getComplaints()%></h4><br>
			<input type="hidden" name="complaintID" value=<%=track.getComplaintID()%>>
			<input type="hidden" name="jspName" value="complaintsresponse"><br>
			<textarea name="complaintAction" rows="4" cols="60" id="complaints" maxlength="500"></textarea>
			<br><br>
			<input type="submit" value="SUBMIT" style="font-weight: bolder;">
		</form>
	</div>
</body>
</html>
