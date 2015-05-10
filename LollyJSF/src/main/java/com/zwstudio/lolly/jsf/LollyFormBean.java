package com.zwstudio.lolly.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Getter;
import lombok.Setter;

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
	
	private static final long serialVersionUID = 1L;

	@Autowired
	protected LollyFormBo formBo;
	
	private Gson gson = new Gson();

	public LollyFormBo getFormBo() {
		return formBo;
	}

	public void setFormBo(LollyFormBo formBo) {
		this.formBo = formBo;
	}

	@Getter @Setter
	public String word;
	@Getter @Setter
	public int selectedLangID;
	@Getter @Setter
	public String selectedDictName;
	@Getter
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
		String v = null;
		for(String name: paramNames) {
			v = params.get(name);
			if(v != null)
				break;
		}
		return v;
	}
	
	public void searchButtonClicked() {
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		selectedLangID = Integer.parseInt(getParamValue(params, "form:lang", "form:lang_input"));
		selectedDictName = getParamValue(params, "form:dict", "form:dict_input");
		word = params.get("form:word");
		url = formBo.getUrl(selectedLangID, selectedDictName, word);
		System.out.println("url=" + url);
	}
	
	@PostConstruct
	private void init() {
		System.out.printf("word=%s,lang=%d,dict=%s\n", word, selectedLangID, selectedDictName);
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@SuppressWarnings("unused")
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
