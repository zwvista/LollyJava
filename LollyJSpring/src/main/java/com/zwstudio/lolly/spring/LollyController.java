package com.zwstudio.lolly.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
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
	
	private Gson gson = new Gson();

	@ModelAttribute("formBean")
	public LollyFormBean createFormBean() {
		LollyFormBean bean = new LollyFormBean();
		bean.setWord("一人");
		bean.setLangList(langDao.getData());
		return bean;
	}
	
	@RequestMapping(value="dictList", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictList(
			@ModelAttribute("formBean") LollyFormBean bean,
			@RequestParam(value="langid", required=true) int langid,
			ModelMap modelMap) {
		return createJsonResponse(dictDao.getDataByLang(langid));
	}
	
	@RequestMapping(value="dictList2", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictList2(
			@ModelAttribute("formBean") LollyFormBean bean,
			@RequestParam(value="langid", required=true) int langid,
			ModelMap modelMap) {
		return createJsonResponse(
			dictDao.getDataByLang(langid).stream()
			.map(r -> r.getId().getDictname())
			.toArray()
		);
	}
	@RequestMapping(value="dictall", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> dictall(
			@ModelAttribute("formBean") LollyFormBean bean,
			@RequestParam(value="langid", required=true) int langid,
			@RequestParam(value="dictname", required=true) String dictname,
			ModelMap modelMap) {
		return createJsonResponse(
			dictallDao.getDataByLangDict(langid, dictname)
		);
	}
	
	private ResponseEntity<String> createJsonResponse(Object o) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json; charset=utf-8");
	    String json = gson.toJson(o);
	    System.out.println(json);
	    return new ResponseEntity<String>(json, headers, HttpStatus.CREATED);
	}
	
    @RequestMapping("/lolly")
    public String lolly() {
        return "lolly";
    }
    @RequestMapping("/lolly2")
    public String lolly2() {
        return "lolly2";
    }

}
