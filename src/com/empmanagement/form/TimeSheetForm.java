package com.empmanagement.form;

import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class TimeSheetForm extends org.apache.struts.action.ActionForm{

	private String timeSheetDate;
	private String taskName;
	private String taskDescription;
	private int empID;
	public String getTimeSheetDate() {
		return timeSheetDate;
	}
	public void setTimeSheetDate(String timeSheetDate) {
		this.timeSheetDate = timeSheetDate;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
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
		System.out.println("VALIDATE STARTED IN RESET PASSWORD FORM ");
		
		
		if(empID == 0 || String.valueOf(empID).length() != 4)
		{
			errors.add("empID", new ActionMessage("error.empID.required"));
		}
		if(taskName.trim().length()< 3)
		{
			errors.add("taskName", new ActionMessage("error.taskName.required"));
		}
		if(LocalDate.parse(timeSheetDate).isAfter(LocalDate.now()))
		{
			errors.add("timeSheetDate", new ActionMessage("error.date.greater"));
		}
		if(Period.between( LocalDate.parse(timeSheetDate) , LocalDate.now()).getDays() > 10)
		{
			errors.add("empDOB", new ActionMessage("error.timeSheetDate.period"));
		}
		System.out.println("VALIDATE ENDED IN RESET PASSWORD FORM ");
		return errors;
	}
	
}
