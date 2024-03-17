package com.empmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.bean.DisplayResponceBean;
import com.empmanagement.form.LoginMappingForm;
import com.empmanagement.utility.DataAccessManager;

public class EmpLoginAction extends Action{

	private final String className = "EmpLoginAction";
	private final static String MYPROFILE= "MY PROFILE";
	private final static String EMPLOYEESEARCH = "EMPLOYEE SEARCH";
	private final static String TIMESHEET = "TIMESHEET";
	private final static String COMPLAINTS = "COMPLAINTS";
	private final static String TRACKCOMPLAINTS = "TRACK COMPLAINTS";
	private final static String HOLIDAYS = "HOLIDAYS";
	private final static String RESETPASSWORD = "RESET PASSWORD";
	private final static String LOGOUT = "LOGOUT";
	private final static String MYPROFILEJSP= "MYPROFILE";
	private final static String EMPLOYEESEARCHJSP = "EMPLOYEESEARCH";
	private final static String TIMESHEETJSP = "TIMESHEET";
	private final static String COMPLAINTSJSP = "COMPLAINTS";
	private final static String TRACKCOMPLAINTSJSP = "TRACKCOMPLAINTS";
	private final static String HOLIDAYSJSP = "HOLIDAYS";
	private final static String LOGOUTJSP = "LOGOUT";
	private final static String RESETPASSWORDJSP = "RESETPASSWORD";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");

		LoginMappingForm lmForm = (LoginMappingForm) form;
		DataAccessManager dam = new DataAccessManager();
		DisplayResponceBean displayBean = null;
		try {
			Integer empID=(Integer) lmForm.getEmpID();
			HttpSession session = request.getSession();
			System.out.println("Sesssion===========LoginAction "+session);
//			loginForm.setEmpID(loginForm.getEmpID());
			session.setAttribute("empID",empID);
			if(MYPROFILE.equals(lmForm.getDirection()))
			{
				displayBean = dam.showEmpDetails(empID.intValue());
				session.setAttribute("displayBean",displayBean);
				return mapping.findForward(MYPROFILEJSP);
			}
			else if(EMPLOYEESEARCH.equals(lmForm.getDirection()))
			{
				return mapping.findForward(EMPLOYEESEARCHJSP);
			}
			else if(TIMESHEET.equals(lmForm.getDirection()))
			{
				return mapping.findForward(TIMESHEETJSP);
			}
			else if(COMPLAINTS.equals(lmForm.getDirection()))
			{
				return mapping.findForward(COMPLAINTSJSP);
			}
			else if(HOLIDAYS.equals(lmForm.getDirection()))
			{
				return mapping.findForward(HOLIDAYSJSP);
			}
			else if(LOGOUT.equals(lmForm.getDirection()))
			{
				session.removeAttribute("empID");
				session.invalidate();
				return mapping.findForward(LOGOUTJSP);
			}
			else if(RESETPASSWORD.equals(lmForm.getDirection()))
			{
				return mapping.findForward(RESETPASSWORDJSP);
			}
			else if(TRACKCOMPLAINTS.equals(lmForm.getDirection()))
			{
				return mapping.findForward(TRACKCOMPLAINTSJSP);
			}
			else
			{
				return mapping.findForward(LOGOUTJSP);
			}
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> exception : " + LOGOUTJSP);
			// e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		return mapping.findForward(LOGOUTJSP);
	}
}
