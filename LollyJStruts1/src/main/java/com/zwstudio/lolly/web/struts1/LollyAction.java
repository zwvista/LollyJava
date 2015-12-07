package com.zwstudio.lolly.web.struts1;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

@Controller("/lolly")
public class LollyAction extends LollyBaseAction {

	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
 
		LollyForm lollyForm = (LollyForm) form;
		lollyForm.langList = langDao.getData();
		lollyForm.word = "一人";
 
		return mapping.findForward("success");
	}
}