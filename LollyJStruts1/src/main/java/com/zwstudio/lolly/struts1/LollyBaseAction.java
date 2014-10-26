package com.zwstudio.lolly.struts1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.struts.DispatchActionSupport;

import com.google.gson.Gson;
import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;

public class LollyBaseAction extends DispatchActionSupport {
    
	@Autowired
	protected LanguageDao langDao;
	@Autowired
	protected DictionaryDao dictDao;
	@Autowired
	protected DictAllDao dictallDao;
	
	private Gson gson = new Gson();
	
	protected void createJsonResponse(HttpServletRequest request,
			HttpServletResponse response, Object o) {

		response.setContentType("application/json; charset=utf-8");
	    String json = gson.toJson(o);
	    System.out.println(json);
        try {
    	    PrintWriter writer = response.getWriter();
			writer = response.getWriter();
	        writer.write(json);
	        writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
