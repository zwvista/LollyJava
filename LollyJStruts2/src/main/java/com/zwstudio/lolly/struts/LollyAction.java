package com.zwstudio.lolly.struts;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Language;

@Controller
public class LollyAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
    
	@Autowired
	private LanguageDao langDao;
	@Autowired
	private DictionaryDao dictDao;
	@Autowired
	private DictAllDao dictallDao;
	
	private List<Language> langList;
	private List<String> dictList;
	private int selectedLangID;
	private String selectedDictName;
	private String word;
	private String url;

	public String execute() {
		langList = langDao.getData();
		word = "一人";
		return SUCCESS;
	}

	public List<Language> getLangList() {
		return langList;
	}

	public void setLangList(List<Language> langList) {
		this.langList = langList;
	}

	public List<String> getDictList() {
		return dictList;
	}

	public void setDictList(List<String> dictList) {
		this.dictList = dictList;
	}
	
	public int getSelectedLangID() {
		return selectedLangID;
	}

	public void setSelectedLangID(int selectedLangID) {
		this.selectedLangID = selectedLangID;
	}

	public String getSelectedDictName() {
		return selectedDictName;
	}

	public void setSelectedDictName(String selectedDictName) {
		this.selectedDictName = selectedDictName;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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