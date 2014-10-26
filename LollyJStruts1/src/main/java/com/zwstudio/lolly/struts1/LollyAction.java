package com.zwstudio.lolly.struts1;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.struts.ActionSupport;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;

@Controller("/lolly")
public class LollyAction extends ActionSupport {
    
	@Autowired
	private LanguageDao langDao;
	@Autowired
	private DictionaryDao dictDao;
	@Autowired
	private DictAllDao dictallDao;

	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
 
		LollyForm lollyForm = (LollyForm) form;
		lollyForm.langList = langDao.getData();
		lollyForm.word = "一人";
 
		return mapping.findForward("success");
	}
 
}