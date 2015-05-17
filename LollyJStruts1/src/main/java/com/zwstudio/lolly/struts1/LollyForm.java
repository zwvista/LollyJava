package com.zwstudio.lolly.struts1;
 
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.struts.action.ActionForm;

import com.zwstudio.lolly.domain.Language;

@Getter @Setter
public class LollyForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	public List<Language> langList;
	public List<String> dictList;
	public int selectedLangID;
	public String selectedDictName;
	public String word;
	public String url;
}