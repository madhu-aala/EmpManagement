package com.empmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.ForgetPasswordForm;
import com.empmanagement.utility.DataAccessManager;

public class ForgetPasswordAction extends Action{

	
	private final String className = "ForgetPasswordAction";
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";
	private final static String FAILMESSAGE = "PLEASE ADD CORRECT DETAILS AGAIN...";
	private final static String SUCCESSMESSAGE = "PASSWORD RESET SUCCESSFUL...";
 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");
		
		ForgetPasswordForm forgetForm = (ForgetPasswordForm) form;
		HttpSession session = request.getSession();
		final DataAccessManager dam = new DataAccessManager();
		try {
			if(dam.forgetPassword(forgetForm))
			{
				session.setAttribute("message", SUCCESSMESSAGE);
				return mapping.findForward(SUCCESS);
			}
			else
			{
				session.setAttribute("message" , FAILMESSAGE);
				session.setAttribute("type", "error");
				return mapping.findForward(FAILURE);
			}
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> exception : " + FAILURE);
			session.setAttribute("message" , FAILMESSAGE);
			session.setAttribute("type", "error");
			return mapping.findForward(FAILURE);
		}
	}
}
