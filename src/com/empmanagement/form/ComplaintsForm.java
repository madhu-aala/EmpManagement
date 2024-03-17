package com.empmanagement.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.empmanagement.utility.DataAccessManager;

public class ComplaintsForm extends org.apache.struts.action.ActionForm
{

	private String complaints;
	private int empID;

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
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
		
		
		if(empID == 0 || empID < 3760)
		{
			errors.add("empID", new ActionMessage("error.empID.invalid"));
		}
		if(complaints.trim().length()<2)
		{
			errors.add("complaints", new ActionMessage("error.complaints.required"));
		}
		System.out.println("VALIDATE ENDED IN RESET PASSWORD FORM ");
		return errors;
	}
}
