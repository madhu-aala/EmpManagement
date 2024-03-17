package com.empmanagement.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.empmanagement.utility.DataAccessManager;
import com.empmanagement.utility.StringUtil;

public class ForgetPasswordForm extends ActionForm{

	private int empID;
	private long empMobile;
	private String empConfirmPassword;
	private String empNewPassword;
	private long empAadhaarNumber;
	private String loginType;
	
	
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


	public long getEmpMobile() {
		return empMobile;
	}


	public void setEmpMobile(long empMobile) {
		this.empMobile = empMobile;
	}


	public String getEmpConfirmPassword() {
		return empConfirmPassword;
	}


	public void setEmpConfirmPassword(String empConfirmPassword) {
		this.empConfirmPassword = empConfirmPassword;
	}


	public String getEmpNewPassword() {
		return empNewPassword;
	}


	public void setEmpNewPassword(String empNewPassword) {
		this.empNewPassword = empNewPassword;
	}


	public long getEmpAadhaarNumber() {
		return empAadhaarNumber;
	}


	public void setEmpAadhaarNumber(long empAadhaarNumber) {
		this.empAadhaarNumber = empAadhaarNumber;
	}


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		System.out.println("VALIDATE STARTED IN RESET PASSWORD FORM ");
		if(empID == 0 || String.valueOf(empID).length() != 4)
		{
			errors.add("empID", new ActionMessage("error.empID.invalid"));
		}
		if(!empNewPassword.equals(empConfirmPassword))
		{
			errors.add("empNewPassword", new ActionMessage("error.empNewPassword.required"));
		}
		if(!StringUtil.validatePassword(empNewPassword) || empNewPassword.length()<6)
		{
			errors.add("empNewPassword", new ActionMessage("error.empNewPassword.format"));
		}
		if(String.valueOf(empAadhaarNumber).length()!=12){
			System.out.println("AADHAAR NUMBER IS NOT 12");
			errors.add("empAadhaarNumber", new ActionMessage("error.empAadhaarNumber.length"));
		}
		if(String.valueOf(empMobile).length() != 10)
		{
			System.out.println("MOBILE NUMBER IS NOT 10");
			errors.add("empMobile", new ActionMessage("error.empMobile.length"));
		}
		System.out.println("VALIDATE ENDED IN RESET PASSWORD FORM ");
		return errors;
	}
}
