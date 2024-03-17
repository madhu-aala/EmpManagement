<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

input[type=number] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
}

input[type="submit"]{
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
<title>Employee search</title>
</head>
<body>
<div align="center">
<div style="color: red;font-weight: bold;"><html:errors/></div>
	<form action="SearchAction.do">
		<h3>EMPLOYEE SEARCH</h3>
		<input type="number" name="empID" placeholder="Input Employee ID" maxlength="4"><br>
		<input type="submit" value="SEARCH" style="font-weight: bolder;">
	</form>
</div>
</body>
</html>