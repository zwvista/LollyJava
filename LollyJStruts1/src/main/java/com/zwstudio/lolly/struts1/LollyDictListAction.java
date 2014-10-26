package com.zwstudio.lolly.struts1;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

@Controller("/dictList")
public class LollyDictListAction extends LollyBaseAction {

	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
 
		LollyForm lollyForm = (LollyForm) form;
		createJsonResponse(request, response,
				dictDao.getNamesByLang(lollyForm.selectedLangID)
		);
 
		return null;
	}
	
}