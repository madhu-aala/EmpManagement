package com.empmanagement.form;

import org.apache.struts.action.ActionForm;

public class TrackComplaintsForm extends ActionForm{

	private String jspName;
	private long complaintID;
	private String complaints;
	private int empID;
	private String status;
	private String complaintAction;
	private String comments;
	private String empComplaintResponce;
	private String empComment;
	public long getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(long complaintID) {
		this.complaintID = complaintID;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getJspName() {
		return jspName;
	}
	public void setJspName(String jspName) {
		this.jspName = jspName;
	}
	public String getComplaintAction() {
		return complaintAction;
	}
	public void setComplaintAction(String complaintAction) {
		this.complaintAction = complaintAction;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEmpComplaintResponce() {
		return empComplaintResponce;
	}
	public void setEmpComplaintResponce(String empComplaintResponce) {
		this.empComplaintResponce = empComplaintResponce;
	}
	public String getEmpComment() {
		return empComment;
	}
	public void setEmpComment(String empComment) {
		this.empComment = empComment;
	}
	
	
	
//	public ActionErrors validate(ActionMapping mapping,
//			HttpServletRequest request) {
//		ActionErrors errors = new ActionErrors();
//		DataAccessManager dam = new DataAccessManager();
//		System.out.println("VALIDATE STARTED IN TRACK COMPLAINTS FORM ");
//		
//		if(complaints.length()<2 )
//		{
//			errors.add("complaints", new ActionMessage("error.complaints.length"));
//		}
//		if(String.valueOf(complaintID).length() != 8)
//		{
//			errors.add("complaintID", new ActionMessage("error.complaintID.length"));
//		}
//		if(complaintAction.trim().length() < 3 || empComplaintResponce.trim().length() <3)
//		{
//			errors.add("complaintAction", new ActionMessage("error.complaintAction.length"));
//		}
//		if(comments.trim().length() < 3 || empComment.trim().length() < 3)
//		{
//			errors.add("comments", new ActionMessage("error.comments.length"));
//		}
//		System.out.println("VALIDATE ENDED IN TRACK COMPLAINTS FORM ");
//		return errors;
//	}
	
}
