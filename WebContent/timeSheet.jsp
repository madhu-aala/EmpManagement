<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE html>
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

input[type="text"] {
	width: 60%;
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
<%
	Integer empID = (Integer) session.getAttribute("empID");
	String message = (String) session.getAttribute("message");
	String type = (String) session.getAttribute("type");
	session.removeAttribute("message");
	session.removeAttribute("type");
%>
<script type="text/javascript">
	
</script>
<title>Time Sheet</title>
<body>
	<div align="center">
		<h2>TIMESHEET</h2>
		<div style="color: red;font-weight: bold;"><html:errors/></div>
		<%
			if (message != null) {
		%>
		<%
			if (type.equals("success")) {
		%>
		<h2 align="center" style="color: green;"><%=message%></h2>
		<%
			} else {
		%>
		<h2 align="center" style="color: red;"><%=message%></h2>
		<%
			}
			}
		%>
		<form action="TimeSheetAction.do" method="post">
			<input type="hidden" name="empID" value=<%=empID.intValue()%>>
			<label for="selectdate">SELECT DATE:</label><br> <br>
			<input type="date" id="date" name="timeSheetDate" placeholder="YYYY-MM-DD" required><br> <br>
			<label for="taskname">TASK NAME:</label><br> <input type="text" id="taskname" name="taskName" required><br> <br> 
			<label for="taskdescription">TASK DESCRIPTION:</label><br> <br>
			<div align="center">
				<textarea rows="5" cols="80" id="taskDescription" name="taskDescription" maxlength="200"></textarea><br> <br> 
				<input type="submit" value="SUBMIT" style="font-weight: bolder;">
			</div> 
		</form>
	</div>
</head>
</body>
</html>