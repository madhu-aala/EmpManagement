<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
 <!DOCTYPE html>
<html>
<head>
<style>
table {
  width: 40%;
  margin: auto;
  border-collapse: collapse;
}
body {
  background-color: #f2f2f2;
}
td {
  padding: 8px;
}

input[type=text], input[type=email], input[type=date],input[type=number] {
  width: 100%;
  padding: 8px 15px;
  margin: 6px 0;
  box-sizing: border-box;
  border: none;
  border-bottom: 2px solid gray;
}

input[type=radio]{
  width: 77%;
  box-sizing: border-box;
  border: none;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

label {
  font-weight: bold;
}

h2 {
  text-align: center;
}

</style>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<%
String message = (String) session.getAttribute("message");
session.removeAttribute("message");
%>
<body>
 
 <div style="color: red;font-weight: bold;"><html:errors/></div>
<h2 align="center">EMPLOYEE REGISTRATION</h2>
<% if(message !=null){ %>
<h3 align="center" style="color: red;"><%= message %></h3>
<% } %>
<form action="RegistrationAction.do" method="post" >
<table align="center">
	<tr><td><label>Full Name:</label></td><td><input type="text" name="empName" required></td></tr>
    <tr><td><label>Email ID:</label></td><td><input type="email" name="empEmail" maxlength="40" required></td></tr>
	<tr><td><label>Contact:</label></td><td><input type="number" name="empMobile" maxlength="10" required></td></tr>
	<tr><td><label>Date of Birth:</label></td><td><input type="date" name="empDOB" placeholder="YYYY-MM-DD" required></td></tr>
	<tr><td><label>Gender:</label></td><td>
	Male &nbsp;&nbsp;<input type="radio" name="empGender" value="male" required>
	Female<input type="radio" name="empGender" value="female" required>
	Others&nbsp;<input type="radio" name="empGender" value="others" required> </td></tr>
	<tr><td><label>Aadhaar Number:</label></td><td><input type="number" id="empAadhaarNumber" name="empAadhaarNumber" maxlength="12" required></td></tr>
	<tr><td><label>Blood Group:</label></td><td><select id="empBloodGroup" name="empBloodGroup">
					<option value="A+">A+</option>
					<option value="B+">B+</option>
					<option value="O+">O+</option>
					<option value="AB+">AB+</option>
					<option value="A-">A-</option>
					<option value="B-">B-</option>
					<option value="O-">O-</option>
					<option value="AB-">AB-</option>
				</select></td></tr>
	<tr><td><label>Permanent Address:</label></td><td><input type="text" placeholder="Line 1" name="empPermAddressLine1" required></td></tr>
	<tr><td><label> </label></td><td><input type="text" placeholder="Line 2" name="empPermAddressLine2" required></td></tr>
	<tr><td><label>City:</label></td><td><input type="text" placeholder="City" name="empPermCity" required></td></tr>
	<tr><td><label>Zip Code: </label></td><td><input type="number" placeholder="Zip Code" name="empPermPincode" maxlength="6" required></td></tr>
	<tr><td><label>Current Address:</label></td><td><input type="text" placeholder="Line 1" name="empCurrentAddressLine1" required></td></tr>
	<tr><td><label> </label></td><td><input type="text" placeholder="Line 2" name="empCurrentAddressLine2" required></td></tr>
	<tr><td><label>City:</label></td><td><input type="text" placeholder="City" name="empCurrentCity" required></td></tr>
	<tr><td><label>Zip Code: </label></td><td><input type="number" placeholder="Zip Code" name="empCurrentPincode" maxlength="6" required></td></tr>
	<tr><td><label>Bank Name:</label></td><td><input type="text" name="empBankName" maxlength="29" required></td></tr>
	<tr><td><label>Bank Account Number:</label></td><td><input type="number" name="empBankAccountNumber" maxlength="14" required></td></tr>
  	<tr><td><label>IFSC Code:</label></td><td><input type="text" name="empIFSCCode" required></td></tr>
  	<tr><td><label>Department:</label></td><td><input type="text" name="empDepartment" required></td></tr>
  	<tr><td><label>Designation:</label></td><td><input type="text" name="empDesignation" required></td></tr>
  	<tr><td><label>Level:</label></td><td><select id="empLevel" name="empLevel">
					<option value="EL">EL</option>
					<option value="L1">L1</option>
					<option value="L2">L2</option>
					<option value="L3">L3</option>
					<option value="L4">L4</option>
					<option value="L5">L5</option>
				</select></td></tr>
  	<tr><td><label>Manager:</label></td><td><input type="text" name="empManager" required></td></tr>
  	<tr><td><label>Join date:</label></td><td><input type="date" name="empJoinDate" placeholder="YYYY-MM-DD" required></td></tr>
  	<tr><td><label>Employee Is From HRD Or Not ?</label></td><td>
	Yes&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="empType" value="yes" required> 
	No&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="empType" value="no" required> 
  	<tr><td><input type="submit" value="SUBMIT" style="font-weight: bolder;"></td><td><button onclick="goBack()" style="font-weight: bold;">BACK</button></td></tr>
</table>
<script>
	function goBack(){
		window.history.back();
	}
	</script>
</form>
</body>
</html>