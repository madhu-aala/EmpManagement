package com.empmanagement.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.ComplaintsForm;
import com.empmanagement.utility.DataAccessManager;

public class ComplaintsAction extends Action{

	private final String className = "ComplaintsAction";
	private static final String FAILURE ="failure";
	private static final String SUCCESS ="success";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception 
	{
		
		String methodName = "execute";
		System.out.println(className+" --> "+methodName+" --> START");
		ComplaintsForm complaints= (ComplaintsForm) form;
		HttpSession session = request.getSession();
		final DataAccessManager dam = new DataAccessManager();
		try {
			
			
			System.out.println(className+" --> "+methodName+" --> ENTER IN TRY");
			long out=0;
			System.out.println(className+" --> "+methodName+" --> GOT EMPID "+complaints.getEmpID());
			if((complaints.getComplaints().trim().length())>1)
			{
				out =dam.insertComplaint(complaints);
			}
			System.out.println(className+" --> "+methodName+" --> INSERTED OR NOT "+out);
			if(out!=0) 
			{
				session.setAttribute("empID", complaints.getEmpID());
				session.setAttribute("message","COMPLAINT ADDED SUCCESSFULLY...AND COMPLAINT ID IS "+out);
				session.setAttribute("type", "success");
				System.out.println("addedSucessfully");
				return mapping.findForward(SUCCESS);
			}
			else 
			{
				session.setAttribute("empID", complaints.getEmpID());
				session.setAttribute("message","COMPLAINT NOT ADDED...");
				session.setAttribute("type", "error");
				System.out.println(FAILURE);
			}
		}
		catch(Exception e)
		{
			System.out.println(className+" --> "+methodName+" --> ERROR "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(className+" --> "+methodName+" --> END");
		session.setAttribute("empID", complaints.getEmpID());
		session.setAttribute("message","COMPLAINT NOT ADDED...");
		session.setAttribute("type", "error");
		return mapping.findForward(FAILURE);
	}
}
