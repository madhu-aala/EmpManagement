package com.empmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.empmanagement.form.TimeSheetForm;
import com.empmanagement.utility.DataAccessManager;
 
public class TimeSheetAction extends Action{
	
	private static final String className = "TimeSheetAction";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception 
	{
		
		String methodName = "execute";
		HttpSession session = request.getSession(false);
		System.out.println(className+" --> "+methodName+" --> START");
		TimeSheetForm timeSheet= (TimeSheetForm) form;
		final DataAccessManager dam = new DataAccessManager();
		try {
			
			
			System.out.println(className+" --> "+methodName+" --> ENTER IN TRY");
			
			System.out.println("TimeSheetAction -------->"+session);
			String employeeID=(String) session.getAttribute("EmpID");
			if(employeeID==null)
			{
				System.out.println("INTEGER OBJ IS NULL");
			}
			System.out.println(employeeID);
//			int empID = Integer.parseInt(employeeID);
			System.out.println(className+" --> "+methodName+" --> GOT EMPID "+timeSheet.getEmpID());
			int out=dam.insertTimeSheet(timeSheet);
			System.out.println(className+" --> "+methodName+" --> INSERTED OR NOT "+out);
			if(out!=0) 
			{
				session.setAttribute("empID", (Integer)timeSheet.getEmpID() );
				session.setAttribute("message", "TIMESHEET ADDED SUCCESSFULLY...");
				session.setAttribute("type", "success");
				System.out.println("addedSucessfully");
				return mapping.findForward("success");
			}
			else 
			{
				session.setAttribute("message", "TIMESHEET ADDED SUCCESSFULLY...");
				session.setAttribute("type", "error");
				System.out.println("notAdded");
				return mapping.findForward("success");
			}
		}
		catch(Exception e)
		{
			System.out.println(className+" --> "+methodName+" --> ERROR "+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(className+" --> "+methodName+" --> END");
		session.setAttribute("message", "TIMESHEET ADDED SUCCESSFULLY...");
		session.setAttribute("type", "success");
		System.out.println("notAdded");
		return mapping.findForward("error");
	}
}
