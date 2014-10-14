package com.zwstudio.lolly.spring;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return bean;
	}
	
	@RequestMapping(value = "/options")
    public String options(Model model) {
        model.addAttribute("langList", langDao.getData());
        return "options";
    }
	
    @RequestMapping("/lolly")
    public String lolly() {
        return "lolly";
    }

}
