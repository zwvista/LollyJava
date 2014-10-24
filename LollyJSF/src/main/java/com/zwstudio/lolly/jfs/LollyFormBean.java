package com.zwstudio.lolly.jfs;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.google.gson.Gson;
import com.zwstudio.lolly.domain.Language;

@Controller
@Scope("Request")
@ManagedBean(name="formBean")
public class LollyFormBean implements Serializable {
	
	@Autowired
	protected LollyFormBo formBo;
	
	private Gson gson = new Gson();

	public LollyFormBo getFormBo() {
		return formBo;
	}

	public void setFormBo(LollyFormBo formBo) {
		this.formBo = formBo;
	}
	
	public String word;
	private int selectedLangID;
	private String selectedDictName;
	private String url;
	
	public LollyFormBean() {
		// If LollyFormBo is a @Component other than a @Service,
		// we would need the following code to initialize it
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		formBo = ctx.getBean(LollyFormBo.class);
		
	    setWord("一人");
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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
	
	public List<Language> getLangList() {
		return formBo.getLangList();
	}

	public List<String> getDictList() {
		return formBo.getDictList(selectedLangID);
	}
	
	public String getUrl() {
		return url;
	}
	
	public void searchButtonClicked() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		selectedLangID = Integer.parseInt(params.get("form:lang"));
		selectedDictName = params.get("form:dict");
		word = params.get("form:word");
		url = formBo.getUrl(selectedLangID, selectedDictName, word);
	}
	
	@PostConstruct
	private void init() {
		System.out.println("init");
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	private void createJsonResponse(Object o) {
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    externalContext.setResponseContentType("application/json");
	    externalContext.setResponseCharacterEncoding("UTF-8");
	    String json = gson.toJson(o);
	    System.out.println(json);
	    try {
			externalContext.getResponseOutputWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    facesContext.responseComplete();
	}

}
