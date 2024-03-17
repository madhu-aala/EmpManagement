package com.empmanagement.action;
  
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.LoginMappingForm;
import com.empmanagement.utility.DataAccessManager;

public class HRDLoginAction extends Action{

	private final String className = "HRDLoginAction";
	private final static String REGISTRATION= "REGISTRATION";
	private final static String UPDATE = "UPDATE";   
	private final static String EMPLOYEESEARCH = "EMPLOYEE SEARCH";
	private final static String COMPLAINTS = "COMPLAINTS";
	private final static String DEACTIVATEEMPLOYEE = "DEACTIVATE EMPLOYEE";
	private final static String LOGOUT = "LOGOUT";
	
	private final static String REGISTRATIONJSP= "REGISTRATION";
	private final static String UPDATEJSP = "UPDATE";
	private final static String EMPLOYEESEARCHJSP = "EMPLOYEE SEARCH";
	private final static String COMPLAINTSJSP = "COMPLAINTS";
	private final static String DEACTIVATEEMPLOYEEJSP = "DEACTIVATE EMPLOYEE";
	private final static String LOGOUTJSP = "LOGOUT";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");
		HttpSession session = request.getSession();
		DataAccessManager dam = new DataAccessManager();
		
		LoginMappingForm lmForm = (LoginMappingForm) form;

		try {
			if(REGISTRATION.equals(lmForm.getDirection()))
			{
				System.out.println("EXCUTION GOES TO REGISTARTION PAGE...");		
				return mapping.findForward(REGISTRATIONJSP);
			}
			else if(EMPLOYEESEARCH.equals(lmForm.getDirection()))
			{
				return mapping.findForward(EMPLOYEESEARCHJSP);
			}
			else if(UPDATE.equals(lmForm.getDirection()))
			{
				return mapping.findForward(UPDATEJSP);
			}
			else if(DEACTIVATEEMPLOYEE.equals(lmForm.getDirection()))
			{
				return mapping.findForward(DEACTIVATEEMPLOYEEJSP);
			}
			else if(COMPLAINTS.equals(lmForm.getDirection()))
			{
				
				ResultSet rs = dam.showComplaintsToHRD();
				session.setAttribute("rs", rs);
				System.out.println(className + " --> " + methodName + " --> LIST ID "+rs);
				return mapping.findForward(COMPLAINTSJSP);
			}
			else if(LOGOUT.equals(lmForm.getDirection()))
			{
				session.removeAttribute("empID");
				session.setAttribute("empID", null);
				return mapping.findForward(LOGOUTJSP);
			}
			else
			{
				session.removeAttribute("empID");
				session.setAttribute("empID", null);
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
