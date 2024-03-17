package com.empmanagement.action;
  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.empmanagement.bean.UpdateBean;
import com.empmanagement.form.SearchForm;
import com.empmanagement.utility.DataAccessManager;

public class UpdateSearchEmployeeAction extends Action{

	private final String className = "UpdateSearchEmployeeAction";
	private final static String HRDLOGIN = "hrdlogin";
	private final static String EMPUPDATE = "empUpdate";
	private final static String UPDATEEMPLOYEE = "updateemployee";

	@SuppressWarnings("static-access")
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String methodName = "execute";
		System.out.println(className + " --> " + methodName + " --> START");
		SearchForm search = (SearchForm) form;
		UpdateBean ub = null;
		final DataAccessManager dam = new DataAccessManager();
		try {
			ub = dam.getEmpDetails(search.getEmpID());
 			if (ub == null) {
				System.out.println("UB IS NULL");
				return mapping.findForward(EMPUPDATE);
			} else
			{
				HttpSession session = request.getSession();
				session.setAttribute("ub", ub);
				System.out.println("UB ADDED ON SESSION...");
				return mapping.findForward(UPDATEEMPLOYEE);
			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println(className + " --> " + methodName + " --> ERROR");
			return mapping.findForward(HRDLOGIN);
		}
		
	}

}
