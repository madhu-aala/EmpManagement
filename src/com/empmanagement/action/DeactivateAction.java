package com.empmanagement.action;
  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.DeactivateForm;
import com.empmanagement.utility.DataAccessManager;

public class DeactivateAction extends Action{
	
	
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";
	private static final String className="DeactivateAction";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String methodName = "execute";
		HttpSession session = request.getSession();
		System.out.println(className + " --> " + methodName + " --> START");
		System.out.println(className + " --> " + methodName + " --> form : " + form);

		DeactivateForm dForm = (DeactivateForm) form;
		DataAccessManager dam = new DataAccessManager();
		System.out.println(className + " --> " + methodName + " --> form : " + dForm);
		try{
			if(dam.deactiveEmployee(dForm))
			{
				session.setAttribute("message", dForm.getEmpID()+" EMPLOYEE DEACTIVATED SUCCESSFULLY...");
				session.setAttribute("type", "success");
				System.out.println("notAdded");
				return mapping.findForward(SUCCESS);
			}
			else
			{
				session.setAttribute("message", dForm.getEmpID()+" EMPLOYEE NOT DEACTIVATED...");
				session.setAttribute("type", "erroe");
				return mapping.findForward(FAILURE);
			}
		}
		catch(Exception e){
			session.setAttribute("message", dForm.getEmpID()+" EMPLOYEE ALREADY DEACTIVATED...");
			session.setAttribute("type", "erroe");
			System.out.println(className + " --> " + methodName + " --> ERROR "+e.getMessage() );
			e.printStackTrace();
			return mapping.findForward(FAILURE);
		}
	}
}
