<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
 <%@ page import="com.empmanagement.bean.UpdateBean" %>
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

input[type="button"] {
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMPLOYEE UPDATE </title>
</head>
<%
HttpSession ses = request.getSession(false);
UpdateBean ub =(UpdateBean)ses.getAttribute("ub");
%>
<body>
<div style="color: red;font-weight: bold;"><html:errors/></div>
<form action="UpdateEmployeeAction.do" method="post" path="/UpdateEmployeeAction">
<% if(ub.getEmpID() == 0) {%>
<script type="text/javascript">
alert("INVALID EMPLOYEE ID...");
</script> 

<div align="center">
	<button onclick="goBack()" style="font-weight: bold;">BACK</button>
	</div>
	<script>
	function goBack(){
		window.history.back();
	}
	</script>
<% } else {%>
<h3 align="center" style="color: green; font: bold;"><%= ub.getEmpID() %></h3>
<table align="center">
	<h2 align="center">EMPLOYEE UPDATE FORM</h2>
	<tr><td><label>Full Name:</label></td><td><input type="text" name="empName" value=<%= ub.getEmpName() %> required></td></tr>
    <tr><td><label>Email ID:</label></td><td><input type="email" name="empEmail" value=<%= ub.getEmpEmail() %>  maxlength="40" required></td></tr>
	<tr><td><label>Contact:</label></td><td><input type="number" name="empMobile" value=<%= ub.getEmpMobile() %> maxlength="10" min="1000000000" required></td></tr>
	<tr><td><label>Date of Birth:</label></td><td><input type="date" name="empDOB" value=<%= ub.getEmpDOB() %> placeholder="YYYY-MM-DD" required></td></tr>
	<tr><td><label >Gender:</label></td><td>
	<input type="radio" name="empGender" value="male" <% if(ub.getEmpGender().equals("male")) { %> checked="checked" <% } %> required> Male
	<input type="radio" name="empGender" value="female" <% if(ub.getEmpGender().equals("female")) { %> checked="checked" <% } %> required> Female
	<input type="radio" name="empGender" value="others" <% if(ub.getEmpGender().equals("others")) { %> checked="checked" <% } %>  required> Others</td></tr>
	<tr><td><label>Aadhaar Number:</label></td><td><input type="number" name="empAadhaarNumber" value=<%= ub.getEmpAadhaarNumber() %> maxlength="12" required></td></tr>
	<tr><td><label>Blood Group:</label></td><td><select id="empBloodGroup" name="empBloodGroup" >
					<option <% if(ub.getEmpBloodGroup().equals("A+")){ %>selected="selected" <% } %> value="A+">A+</option>
					<option <% if(ub.getEmpBloodGroup().equals("B+")){ %>selected="selected" <% } %> value="B+">B+</option>
					<option <% if(ub.getEmpBloodGroup().equals("O+")){ %>selected="selected" <% } %> value="O+">O+</option>
					<option <% if(ub.getEmpBloodGroup().equals("AB+")){ %>selected="selected" <% } %> value="AB+">AB+</option>
					<option <% if(ub.getEmpBloodGroup().equals("A-")){ %>selected="selected" <% } %> value="A-">A-</option>
					<option <% if(ub.getEmpBloodGroup().equals("B-")){ %>selected="selected" <% } %> value="B-">B-</option>
					<option <% if(ub.getEmpBloodGroup().equals("O-")){ %>selected="selected" <% } %> value="O-">O-</option>
					<option <% if(ub.getEmpBloodGroup().equals("AB-")){ %>selected="selected" <% } %> value="AB-">AB-</option>
				</select></td></tr>
	<tr><td><label>Permanent Address:</label></td><td><input type="text" placeholder="Line 1" name="empPermAddressLine1" value=<%= ub.getEmpPermAddressLine1() %> required></td></tr>
	<tr><td><label> </label></td><td><input type="text" placeholder="Line 2" name="empPermAddressLine2" value=<%= ub.getEmpPermAddressLine2() %> required></td></tr>
	<tr><td><label>City:</label></td><td><input type="text" placeholder="City" name="empPermCity" value=<%= ub.getEmpPermCity() %> required></td></tr>
	<tr><td><label>Zip Code: </label></td><td><input type="number" placeholder="Zip Code" name="empPermPincode" value=<%= ub.getEmpPermPincode() %> maxlength="6" min="100000" required></td></tr>
	<tr><td><label>Current Address:</label></td><td><input type="text" placeholder="Line 1" name="empCurrentAddressLine1" value=<%= ub.getEmpCurrentAddressLine1() %> required></td></tr>
	<tr><td><label> </label></td><td><input type="text" placeholder="Line 2" name="empCurrentAddressLine2" value=<%= ub.getEmpCurrentAddressLine2() %> required></td></tr>
	<tr><td><label>City:</label></td><td><input type="text" placeholder="City" name="empCurrentCity" value=<%= ub.getEmpCurrentCity() %> required></td></tr>
	<tr><td><label>Zip Code: </label></td><td><input type="number" placeholder="Zip Code" name="empCurrentPincode" value=<%= ub.getEmpCurrentPincode() %> maxlength="6" min="100000" required></td></tr>
	<tr><td><label>Bank Name:</label></td><td><input type="text" name="empBankName" value=<%= ub.getEmpBankName() %> maxlength="29" required></td></tr>
	<tr><td><label>Bank Account Number:</label></td><td><input type="number" name="empBankAccountNumber" value=<%= ub.getEmpBankAccountNumber() %> maxlength="14" required></td></tr>
  	<tr><td><label>IFSC Code:</label></td><td><input type="text" name="empIFSCCode" value=<%= ub.getEmpIFSCCode() %> required></td></tr>
  	<tr><td><label>Department:</label></td><td><input type="text" name="empDepartment" value=<%= ub.getEmpDepartment() %> required></td></tr>
  	<tr><td><label>Designation:</label></td><td><input type="text" name="empDesignation" value=<%= ub.getEmpDesignation() %> required></td></tr>
  	<tr><td><label>Level:</label></td><td><select id="empLevel" name="empLevel">
					<option style="size: landscape;" <% if(ub.getEmpLevel().equals("EL")){ %>selected="selected" <% } %> value="EL">EL</option>
					<option <% if(ub.getEmpLevel().equals("L1")){ %>selected="selected" <% } %> value="L1">L1</option>
					<option <% if(ub.getEmpLevel().equals("L2")){ %>selected="selected" <% } %> value="L2">L2</option>
					<option <% if(ub.getEmpLevel().equals("L3")){ %>selected="selected" <% } %> value="L3">L3</option>
					<option <% if(ub.getEmpLevel().equals("L4")){ %>selected="selected" <% } %> value="L4">L4</option>
					<option <% if(ub.getEmpLevel().equals("L5")){ %>selected="selected" <% } %> value="L5">L5</option>
				</select></td></tr>
  	<tr><td><label>Manager:</label></td><td><input type="text" name="empManager" value=<%= ub.getEmpManager() %> required></td></tr>
  	<tr><td><label>Join date:</label></td><td><input type="date" name="empJoinDate" value=<%= ub.getEmpJoinDate() %> placeholder="YYYY-MM-DD" required></td></tr>
  	<tr><td><label>Employee Is From HRD Or Not ?</label></td><td>
	<input type="radio" name="empType" value="yes" <% if(ub.getEmpType().equals("yes")) { %> checked="checked" <% } %> required> Yes
	<input type="radio" name="empType" value="no" <% if(ub.getEmpType().equals("no")) { %> checked="checked" <% } %> required> No
	<tr><td><label></label></td><td><input type="hidden" name="empID" value=<%= ub.getEmpID() %> required></td></tr>
  	<tr><td><input type="submit" value="UPDATE" style="font-weight: bolder;"></td></tr>
</table>
<% } %>
</form>
</body>
</html>