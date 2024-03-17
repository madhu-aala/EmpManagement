package com.empmanagement.form;

import org.apache.struts.action.ActionForm;

public class LoginMappingForm extends ActionForm {
 
	private String direction;
	private int empID;

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	} 
	
}