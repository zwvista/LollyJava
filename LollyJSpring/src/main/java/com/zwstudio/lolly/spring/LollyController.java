package com.zwstudio.lolly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;

@Controller
public class LollyController { 
	@Autowired
	protected LanguageDao langDao;
	@Autowired
	protected DictionaryDao dictDao;
	@Autowired
	protected DictAllDao dictallDao;

	@ModelAttribute("formBean")
	public LollyFormBean createFormBean() {
		LollyFormBean bean = new LollyFormBean();
		bean.setWord("一人");
		bean.setLangList(langDao.getData());
		return bean;
	}
	
	@RequestMapping(value = "/{path}/dictList", method = RequestMethod.POST)   
	public @ResponseBody String list(@RequestParam("country") String country) { 
	    System.out.println("selected country" + country);
	    return country;
	}
	
    @RequestMapping("/lolly")
    public String lolly() {
        return "lolly";
    }

}
