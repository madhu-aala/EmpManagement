package com.empmanagement.action;
 
import javax.servlet.http.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.empmanagement.form.EmployeeUpdateForm;
import com.empmanagement.utility.DataAccessManager;

public class UpdateEmployeeAction extends Action{

	private final String className = "UpdateEmployee";
	private final static String HRDLOGIN = "hrdlogin";
	private final static String EMPUPDATE = "empUpdate";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String methodName = "execute";
		HttpSession session = request.getSession();
		System.out.println(className + " --> " + methodName + " --> START");
		EmployeeUpdateForm updateForm = (EmployeeUpdateForm) form;
		final DataAccessManager dam = new DataAccessManager();
		try {
			if (dam.updateEmployeeDetails(updateForm)) {
				session.setAttribute("message", "EMPLOYEE DETAILS UPDATED SUCCESSFULLY...");
				session.setAttribute("type", "success");
				System.out.println("addedSucessfully");
				return mapping.findForward(EMPUPDATE);
			} else
			{
				session.setAttribute("type", "error");
				session.setAttribute("message", "EMPLOYEE DETAILS NOT UPDATED...");
				System.out.println("notAdded");
				return mapping.findForward(EMPUPDATE);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println(className + " --> " + methodName + " --> ERROR");
			return mapping.findForward(HRDLOGIN);
		}
		
	}
}
