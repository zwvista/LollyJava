package com.zwstudio.lolly.web.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.zwstudio.lolly.domain.Language;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Controller
@Scope("Request")
@ManagedBean(name="formBean")
public class LollyFormBean implements Serializable {

	@Autowired
	protected LollyFormBo formBo;

	@Getter @Setter
	public String word;
	@Getter @Setter
	public int selectedLangID;
	@Getter @Setter
	public String selectedDictName;
	@Getter @Setter
	public String url;
	
	public LollyFormBean() {
		// If LollyFormBo is a @Component other than a @Service,
		// we would need the following code to initialize it
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		formBo = ctx.getBean(LollyFormBo.class);
		
	    word = "一人";
	}

	public List<Language> getLangList() {
		return formBo.getLangList();
	}

	public List<String> getDictList() {
		return formBo.getDictList(selectedLangID);
	}
	
	private String getParamValue(Map<String,String> params, String... paramNames) {
		return Arrays.stream(paramNames).filter(name -> params.get(name) != null)
				.findFirst().orElse(null);
		// return Array.array(paramNames).find(name -> params.get(name) != null).toNull();
	}
	
	public void searchButtonClicked() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		selectedLangID = Integer.parseInt(getParamValue(params, "form:lang", "form:lang_input"));
		selectedDictName = getParamValue(params, "form:dict", "form:dict_input");
		word = params.get("form:word");
		url = formBo.getUrl(selectedLangID, selectedDictName, word);
		System.out.println("url=" + url);
	}
	
	public void redirectSearchButtonClicked() throws IOException {
		searchButtonClicked();
		FacesContext.getCurrentInstance().getExternalContext().redirect(url);
	}
	
	@PostConstruct
	private void init() {
		System.out.printf("word=%s,lang=%d,dict=%s\n", word, selectedLangID, selectedDictName);
	}

}
