package com.empmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.*;

import com.empmanagement.form.LoginForm;
import com.empmanagement.utility.DataAccessManager;

public class LoginAction extends Action {

	private final String className = "LoginAction";
	private final static String HRDLOGIN = "hrdlogin";
	private final static String EMPLOGIN = "emplogin";
	private final static String FAILURE = "failure";
	private final static String HRD = "hrd";
	private final static String EMP = "emp";
 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");
		System.out.println(className + " --> " + methodName + " --> form : " + form);

		LoginForm loginForm = (LoginForm) form;
		
		Integer empID=loginForm.getEmpID();
//		if(loginForm.getEmpID()==3764)
//		{
//			return mapping.findForward("error");
//		}
		System.out.println("Employee ID --> "+empID);
		HttpSession session = request.getSession();
		System.out.println(className + " --> " + methodName + " --> loginForm : " + loginForm);
		System.out.println(className + " --> " + methodName + " --> loginType : " + loginForm.getLoginType());
		final DataAccessManager dam = new DataAccessManager();
		try {
			if (HRD.equals(loginForm.getLoginType())) {
				if (dam.checkLogin(loginForm)) {
					session.setAttribute("empID", empID);
					System.out.println(className + " --> " + methodName + " --> HRD sucess");
					dam.insertTracking(loginForm.getEmpID());
					return mapping.findForward(HRDLOGIN);
				} else {
					session.setAttribute("message", "EMPLOYEE ID OR PASSWORD NOT MATCHED...");
					return mapping.findForward(FAILURE);
				}
			} else if (EMP.equals(loginForm.getLoginType())) {
				if (dam.checkLogin(loginForm)) {
					System.out.println("Sesssion===========LoginAction "+session);
					session.setAttribute("empID",empID);
					
					System.out.println(className + " --> " + methodName + " --> EMP sucess"+empID);
					dam.insertTracking(loginForm.getEmpID());
					System.out.println();
					return mapping.findForward(EMPLOGIN);
				} else {
					session.setAttribute("message", "EMPLOYEE ID OR PASSWORD NOT MATCHED...");
					return mapping.findForward(FAILURE);
				}
			} else {
				System.out.println(className + " --> " + methodName + " --> response : " + FAILURE);
				session.setAttribute("message", "EMPLOYEE ID OR PASSWORD NOT MATCHED...");
				return mapping.findForward(FAILURE);
			}
		} catch (Exception e) {
			System.out.println(className + " --> " + methodName + " --> exception : " + FAILURE);
			// e.printStackTrace();
		}
		System.out.println(className + " --> " + methodName + " --> END");
		session.setAttribute("message", "EMPLOYEE ID OR PASSWORD NOT MATCHED...");
		return mapping.findForward(FAILURE);
	}
}
