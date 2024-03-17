package com.empmanagement.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.empmanagement.utility.DataAccessManager;
import com.empmanagement.utility.StringUtil;

public class DeactivateForm extends org.apache.struts.action.ActionForm{

	
	private int empID;
	private String reason;
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		DataAccessManager dam = new DataAccessManager();
		System.out.println("VALIDATE STARTED IN RESET PASSWORD FORM ");
		
		
		if(empID == 0 || empID < 3760)
		{
			errors.add("empID", new ActionMessage("error.empID.invalid"));
		}
		if(reason.trim().length()<2)
		{
			errors.add("reason", new ActionMessage("error.reason.required"));
		}
		System.out.println("VALIDATE ENDED IN RESET PASSWORD FORM ");
		return errors;
	}
	
	
}
