package com.empmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.EmpComplaintResponceForm;
import com.empmanagement.utility.DataAccessManager;

public class EmpComplaintResponceAction extends Action {

	private final String className = "EmpComplaintResponceAction";
	private final static String TRACKCOMPLAINTS = "trackcomplaints";
	private final static String ERRORMESSAGE = "YOUR RESPONCE IS NOT INSERTED PLEASSE ENTER ONCE AGAIN...";
	private final static String SUCCESSMESSAGE = "YOUR RESPONCE IS INSERTED...";
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");
		HttpSession session = request.getSession();
		int out = 0;
		System.out.println(className + " --> " + methodName + " --> session "+session);
		EmpComplaintResponceForm empCompResForm = (EmpComplaintResponceForm) form;
		System.out.println(className + " --> " + methodName + " --> empCompResForm "+empCompResForm);
		final DataAccessManager dam = new DataAccessManager();
		try {
			out = dam.insertEmpComplaintResponce(empCompResForm);
			System.out.println(className + " --> " + methodName + " --> IN TRY BLOCK..."+out);
			if(out != 0)
			{
				session.setAttribute("message", SUCCESSMESSAGE);
				session.setAttribute("type", "success");
				System.out.println(className + " --> " + methodName + " --> TO TRACKCOMPLAINTS "+SUCCESSMESSAGE);
				return mapping.findForward(TRACKCOMPLAINTS);
			}
			else
			{
				session.setAttribute("message", ERRORMESSAGE);
				session.setAttribute("type", "failure");
				System.out.println(className + " --> " + methodName + " --> TO TRACKCOMPLAINTS "+ERRORMESSAGE);
				return mapping.findForward(TRACKCOMPLAINTS);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println(className + " --> " + methodName + " --> ERROR");
			session.setAttribute("message", ERRORMESSAGE);
			session.setAttribute("type", "failure");
			System.out.println(className + " --> " + methodName + " --> TO TRACKCOMPLAINTS "+ERRORMESSAGE);
			return mapping.findForward(TRACKCOMPLAINTS);
		}
	}
}
