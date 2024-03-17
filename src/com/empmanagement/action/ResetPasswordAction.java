package com.empmanagement.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.ResetPasswordForm;
import com.empmanagement.utility.DataAccessManager;
import com.empmanagement.utility.StringUtil;

public class ResetPasswordAction extends Action{

	
	private final static String CLASSNAME = "ResetPasswordAction";
	private final static String RESETPASSWORD = "resetpassword";
	private final static String SUCCESS = "login";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String methodName = "execute";
		System.out.println(CLASSNAME + " --> " + methodName + " --> START");
		int result = 0;
		ResetPasswordForm rpForm = (ResetPasswordForm) form;
		HttpSession session = request.getSession();
		final DataAccessManager dam = new DataAccessManager();
		try {
			if(rpForm.getNewPassword().equals(rpForm.getConfirmNewPassword()) && StringUtil.validatePassword(rpForm.getNewPassword()))
			{
				result = dam.resetPassword(rpForm);
				if(result !=0 )
				{
					session.setAttribute("message", "PASSWORD CHANGED SUCCESSFULLY...");
					session.setAttribute("type", "success");
					return mapping.findForward(SUCCESS);
				}
				else
				{
					session.setAttribute("empID", (Integer) rpForm.getEmpID());
					session.setAttribute("message", "OLD PASSWORD DOES NOT MATCHED...");
					session.setAttribute("type", "error");
					return mapping.findForward(RESETPASSWORD);
				}
			}
			else
			{
				if(StringUtil.validatePassword(rpForm.getNewPassword()))
				{
					session.setAttribute("message", "NEW PASSWORD DOES NOT MATCH");
				}
				else
				{
					session.setAttribute("message", "NEW PASSWORD CAN CONTAIN ONLY NUMBERS MIN 6 NUMBERS...");
				}
				System.out.println(CLASSNAME + " --> " + methodName + " --> NEW PASSWORD DOES NOT MATCH");
				session.setAttribute("empID", (Integer) rpForm.getEmpID());
				session.setAttribute("type", "error");
				return mapping.findForward(RESETPASSWORD);
			}
		} catch (Exception e) {
			System.out.println(CLASSNAME + " --> " + methodName + " --> exception : " );
			 e.printStackTrace();
		}
		System.out.println(CLASSNAME + " --> " + methodName + " --> END");
		session.setAttribute("empID", (Integer) rpForm.getEmpID());
		session.setAttribute("message", "PASSWORD RESET FAILED...");
		session.setAttribute("type", "error");
		return mapping.findForward(RESETPASSWORD);
	}
}
