package com.empmanagement.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.RegistrationForm;
import com.empmanagement.utility.DataAccessManager;

public class RegistrationAction extends Action {

	private final String className = "RegistrationAction";
	private final static String HRDLOGIN = "hrdlogin";
	private final static String REGSUCESS = "registrationsuccess";
	private final static String REGISTRATION = "registration";
	private final static String ERRORMESSAGE = "PLEASE ENTER CORRECT INFORMATION....";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");
		HttpSession session = request.getSession();
		RegistrationForm registrationForm = (RegistrationForm) form;
		final DataAccessManager dam = new DataAccessManager();
		try {
			int out = dam.setEmployeeDetails(registrationForm);
			if(out == 99)
			{
				session.setAttribute("message" , "THIS AADHAAR NUMBER IS AVAILABLE....PLEASE ENTER CORRECT ADDHAR NUMBER");
				System.out.println("notAdded");
				return mapping.findForward(REGISTRATION);
			}
			else if(out == 55){   
				session.setAttribute("message" , ERRORMESSAGE);
				System.out.println("notAdded");
				return mapping.findForward(REGISTRATION);
			}
			else if (out != 0 && out!=55) {
				session.setAttribute("empID", (Integer)out);
				System.out.println("addedSucessfully");
				return mapping.findForward(REGSUCESS);
			} else
			{
				System.out.println("notAdded");
				return mapping.findForward(REGISTRATION);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println(className + " --> " + methodName + " --> ERROR");
			return mapping.findForward(HRDLOGIN);
		}
		
	}
}
