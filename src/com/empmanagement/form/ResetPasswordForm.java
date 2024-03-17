package com.empmanagement.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.empmanagement.utility.DataAccessManager;
import com.empmanagement.utility.StringUtil;

public class ResetPasswordForm extends org.apache.struts.action.ActionForm{

	private int empID;
	private String oldPassword;
	private String confirmNewPassword;
	private String newPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		DataAccessManager dam = new DataAccessManager();
		System.out.println("VALIDATE STARTED IN RESET PASSWORD FORM ");
		
		if(!newPassword.equals(confirmNewPassword))
		{
			errors.add("newPassword", new ActionMessage("error.newPassword.required"));
		}
		if(!StringUtil.validatePassword(newPassword) || newPassword.length()<6)
		{
			errors.add("newPassword", new ActionMessage("error.newPasswordFormat.required"));
		}
		if(!dam.checkPassword(empID).equals(oldPassword) )
		{
			errors.add("oldPassword", new ActionMessage("error.oldPassword.required"));
		}
		System.out.println("VALIDATE ENDED IN RESET PASSWORD FORM ");
		return errors;
	}
}
