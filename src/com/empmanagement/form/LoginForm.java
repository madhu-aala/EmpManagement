package com.empmanagement.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends org.apache.struts.action.ActionForm
{
	 
	private String loginType;
	private int empID;
	private String password;
	
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID; 
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (empID == 0) 
		{
			errors.add("empID", new ActionMessage("error.empID.required"));

		}
		return errors;
	}

}
