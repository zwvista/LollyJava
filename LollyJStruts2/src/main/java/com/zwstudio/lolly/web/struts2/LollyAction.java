package com.zwstudio.lolly.web.struts2;
 
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Controller
@Namespace("/")
@ResultPath("/")
@ParentPackage("default")
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(
	requiredStrings =
        {@RequiredStringValidator(fieldName = "word", type = ValidatorType.FIELD, message = "You must enter a value for word.")}
)
public class LollyAction extends ActionSupport {
    
	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired @Qualifier("dictionaryDao")
	protected IDictionaryService dictDao;
	
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
		)
	})
	@SkipValidation
	public String execute() {
		langList = langDao.getData();
		word = "一人";
		return SUCCESS;
	}

	@Action(
		value="dictList",
		results=@Result(type="json")
	)
	@SkipValidation
	public String writeDictList() {
		dictList = dictDao.getNamesByLang(selectedLangID);
		return SUCCESS;
	}

	@Action(
		value="dictUrl",
		results=@Result(type="json")
	)
	public String writeDictUrl() {
		url = dictDao.getDataByLangDict(selectedLangID, selectedDictName).getUrl();
		return SUCCESS;
	}

	@Action(
		value="search",
		results={@Result(name=SUCCESS, location="${url}", type="redirect"),
				@Result(name=INPUT, location="error", type="chain")}
	)
	public String search() {
		url = dictDao.getDataByLangDict(selectedLangID, selectedDictName).getUrl();
		try {
			url = url.replace("{0}", URLEncoder.encode(word, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(
		value="error",
		results=@Result(name=ERROR, location="error.jsp")
	)
	@SkipValidation
	public String error() {
		return ERROR;
	}
}