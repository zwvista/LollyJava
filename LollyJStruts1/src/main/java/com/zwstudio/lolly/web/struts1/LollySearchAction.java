package com.zwstudio.lolly.web.struts1;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

@Controller("/search")
public class LollySearchAction extends LollyBaseAction {

	@SuppressWarnings("serial")
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
		 
		LollyForm lollyForm = (LollyForm) form;
		String url = dictallDao.getDataByLangDict(lollyForm.selectedLangID, lollyForm.selectedDictName)
			.getUrl().replace("{0}", lollyForm.word);
        return new ActionForward(url){{setRedirect(true);}}; 
	}
}