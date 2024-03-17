package com.empmanagement.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.bean.DisplayResponceBean;
import com.empmanagement.form.SearchForm;
import com.empmanagement.utility.DataAccessManager;

public class SearchAction extends Action{
	
	private final static String className = "SearchAction"; 
	private final static String DISPLAY = "empdetails";
	private final static String EMPSEARCH = "empsearch";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception 
	{
		String methodName = "execute";
		System.out.println(className+" --> "+methodName+" --> START");
		SearchForm searchForm=(SearchForm) form;
		DisplayResponceBean detailBean=null;
		final DataAccessManager dam = new DataAccessManager();
		try{
			detailBean=dam.showEmpDetails(searchForm.getEmpID());
			System.out.println(className+" --> "+methodName+" --> "+searchForm.getEmpID());
			if(detailBean==null)
			{
				
				return mapping.findForward(EMPSEARCH);
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("detailBean", detailBean);
				return mapping.findForward(DISPLAY);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(className+" --> "+methodName+" --> END");
		return mapping.findForward(DISPLAY);
	}

}
