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

public class ComplaintsResponceAction extends Action{


	private final static String className = "ComplaintsResponceAction"; 
	private final static String COMPLAINTSRESPONSE = "complaintsresponse";
	private final static String HRDCOMPLAINTS = "hrdcomplaintsdisplay";
	private final static String FAILURE = "failure";
	private final static String HRDLOGIN = "hrdlogin";


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception 
	{
		String methodName = "execute";
		System.out.println(className+" --> "+methodName+" --> START");
		TrackComplaintsForm track=(TrackComplaintsForm) form;
		System.out.println(className+" --> "+methodName+" --> TrackComplaintsForm "+track);
		System.out.println(track.getJspName());
		final DataAccessManager dam = new DataAccessManager();
		try{
			if(track.getJspName().equals(COMPLAINTSRESPONSE))
			{
				System.out.println(className+" --> "+methodName+" --> track.getJspName() "+track.getJspName());
				if(dam.insertComplaintsResponse(track))
				{
					System.out.println(className+" --> "+methodName+" --> COMPLAINTSRESPONSE "+HRDLOGIN);
					return mapping.findForward(HRDLOGIN);
				}
				else
				{
					System.out.println(className+" --> "+methodName+" --> COMPLAINTSRESPONSE "+HRDLOGIN);
					return mapping.findForward(COMPLAINTSRESPONSE);

				}
			}
			else if(track.getJspName().equals(HRDCOMPLAINTS))
			{
				System.out.println(className+" --> "+methodName+" --> track.getJspName() "+track.getJspName());
				track=dam.showComplaints(track);
				HttpSession session = request.getSession();
				session.setAttribute("track", track);
				System.out.println(className+" --> "+methodName+" --> TRACK --->"+track);
				return mapping.findForward(COMPLAINTSRESPONSE);
			}
			else
			{
				System.out.println(className+" --> "+methodName+" --> ERROR");
				return mapping.findForward(FAILURE);
			}
		}
		catch(Exception e){
			System.out.println(className+" --> "+methodName+" --> EXCEPTION "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println(className+" --> "+methodName+" --> END");
		return mapping.findForward(FAILURE);
	}
}
