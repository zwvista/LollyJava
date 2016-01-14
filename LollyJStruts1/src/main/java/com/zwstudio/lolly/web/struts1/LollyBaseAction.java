package com.zwstudio.lolly.web.struts1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.struts.DispatchActionSupport;

import com.google.gson.Gson;
import com.zwstudio.lolly.services.IDictAllService;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

public class LollyBaseAction extends DispatchActionSupport {
    
	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired @Qualifier("dictionaryDao")
	protected IDictionaryService dictDao;
	@Autowired @Qualifier("dictAllDao")
	protected IDictAllService dictallDao;
	
	private Gson gson = new Gson();
	
	protected void createJsonResponse(HttpServletRequest request,
			HttpServletResponse response, Object o) {

		response.setContentType("application/json; charset=utf-8");
	    String json = gson.toJson(o);
	    System.out.println(json);
        try {
    	    PrintWriter writer = response.getWriter();
	        writer.write(json);
	        writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
