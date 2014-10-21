package com.zwstudio.lolly.jfs;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.google.gson.Gson;

@Controller
@Scope("Application")
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
	
	public LollyFormBean() {
		// If LollyFormBo is a @Component other than a @Service,
		// we would need the following code to initialize it
		WebApplicationContext ctx =  FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		formBo = ctx.getBean(LollyFormBo.class);
		
	    setWord("一人");
	}
	
	public Map<String, String> getLangMap() {
		return formBo.getLangMap();
	}

	public Map<String, String> getDictMap(AjaxBehaviorEvent event) {
		return formBo.getDictMap(selectedLangID);
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
	
	public void selectedLangChanged(final AjaxBehaviorEvent event) {
		createJsonResponse(
			formBo.getNamesByLang(getSelectedLangID())
		);
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
