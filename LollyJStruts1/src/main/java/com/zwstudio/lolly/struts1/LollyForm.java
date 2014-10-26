package com.zwstudio.lolly.struts1;
 
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts.action.ActionForm;

import com.zwstudio.lolly.domain.Language;

public class LollyForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
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

}