package com.empmanagement.form;


public class EmpComplaintResponceForm extends org.apache.struts.action.ActionForm{
	
	private String empComplaintResponce;
	private long complaintID;
	private String empComment;
	public String getEmpComplaintResponce() {
		return empComplaintResponce;
	}
	public void setEmpComplaintResponce(String empComplaintResponce) {
		this.empComplaintResponce = empComplaintResponce;
	}
	public long getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(long complaintID) {
		this.complaintID = complaintID;
	}
	public String getEmpComment() {
		return empComment;
	}
	public void setEmpComment(String empComment) {
		this.empComment = empComment;
	}
	
	
}
