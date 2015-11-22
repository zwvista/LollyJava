package com.zwstudio.lolly.struts2;
 
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.hibernate.dao.DictAllDao;
import com.zwstudio.lolly.hibernate.dao.DictionaryDao;
import com.zwstudio.lolly.hibernate.dao.LanguageDao;

@Controller
public class LollyAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
    
	@Autowired
	private LanguageDao langDao;
	@Autowired
	private DictionaryDao dictDao;
	@Autowired
	private DictAllDao dictallDao;
	
	@Getter @Setter
	public List<Language> langList;
	@Getter @Setter
	public List<String> dictList;
	@Getter @Setter
	public int selectedLangID;
	@Getter @Setter
	public String selectedDictName;
	@Getter @Setter
	public String word;
	@Getter @Setter
	public String url;

	public String execute() {
		langList = langDao.getData();
		word = "一人";
		return SUCCESS;
	}

	public String writeDictList() {
		dictList = dictDao.getNamesByLang(selectedLangID);
		return SUCCESS;
	}

	public String writeDictUrl() {
		url = dictallDao.getDataByLangDict(selectedLangID, selectedDictName).getUrl();
		return SUCCESS;
	}
}