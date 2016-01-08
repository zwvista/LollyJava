package com.zwstudio.lolly.web.struts2;
 
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.hibernate.dao.DictAllDao;
import com.zwstudio.lolly.hibernate.dao.DictionaryDao;
import com.zwstudio.lolly.hibernate.dao.LanguageDao;

import lombok.Getter;
import lombok.Setter;

@Controller
@Namespace("/")
@ResultPath("/")
@ParentPackage("default")
@InterceptorRef("defaultStack")
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

	@Actions({
		@Action(
			value="lolly1",
			results=@Result(location="lolly1.jsp")
		),
		@Action(
			value="lolly12",
			results=@Result(location="lolly12.jsp")
		),
		@Action(
			value="lolly13",
			results=@Result(location="lolly13.jsp")
		),
		@Action(
			value="lolly2",
			results=@Result(location="lolly2.jsp", type="velocity")
		),
		@Action(
			value="lolly3",
			results=@Result(location="lolly3.jsp", type="freemarker")
		),
	})
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