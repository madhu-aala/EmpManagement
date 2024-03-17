package com.empmanagement.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.empmanagement.utility.DataAccessManager;

public class SearchForm extends org.apache.struts.action.ActionForm{
	private int empID;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		System.out.println("VALIDATE STARTED IN SEARCH FORM ");
		
		
		if(empID == 0 || String.valueOf(empID).length() != 4)
		{
			errors.add("empID", new ActionMessage("error.empID.invalid"));
		}
		System.out.println("VALIDATE ENDED IN SEARCH FORM ");
		return errors;
	}
	
}
