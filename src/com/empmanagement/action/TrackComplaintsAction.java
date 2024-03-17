package com.empmanagement.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.empmanagement.form.TrackComplaintsForm;
import com.empmanagement.utility.DataAccessManager;

public class TrackComplaintsAction extends Action{
	
	private final static String SUCCESS = "complaintsdisplay";
	private final static String FAILURE = "trackcompalints";
	private final static String className = "TrackComplaintsAction";
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception 
	{
		String methodName = "execute";
		System.out.println(className+" --> "+methodName+" --> START");
		TrackComplaintsForm track=(TrackComplaintsForm) form;
		final DataAccessManager dam = new DataAccessManager();
		try{
			track = dam.showComplaints(track);
			if(track != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("track", track);
				System.out.println(className+" --> "+methodName+" --> SESSION --> "+session+"  RESULTSE-->"+track);
				return mapping.findForward(SUCCESS);
			}
			else 
			{
				System.out.println(className+" --> "+methodName+" --> RESULTSET IS NULL");
				return mapping.findForward(FAILURE);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(className+" --> "+methodName+" --> END");
		return mapping.findForward(FAILURE);
	}

}
