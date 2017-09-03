package com.zwstudio.lolly.web.jsf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.domain.Language;

import fj.data.Array;
import lombok.Getter;
import lombok.Setter;

@Controller
@RequestScoped
@Component("formBean")
public class LollyFormBean {

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
	    word = "一人";
	}

	public List<Language> getLangList() {
		return formBo.getLangList();
	}

	public List<String> getDictList() {
		return formBo.getDictList(selectedLangID);
	}
	
	private String getParamValue(Map<String,String> params, String... paramNames) {
//		return Arrays.stream(paramNames).map(name -> params.get(name))
//				.filter(v -> v != null).findFirst().orElse(null);
		return Array.array(paramNames).toStream().map(name -> params.get(name))
				.find(v -> v != null).toNull();
	}
	
	public void searchButtonClicked() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		selectedLangID = Integer.parseInt(getParamValue(params, "form:lang", "form:lang_input", "form:langInner"));
		selectedDictName = getParamValue(params, "form:dict", "form:dict_input", "form:dictInner");
		word = getParamValue(params, "form:word", "input_form:word");
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
