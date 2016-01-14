package com.zwstudio.lolly.web.struts1;
 
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.zwstudio.lolly.domain.Language;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter @Setter
public class LollyForm extends ValidatorForm {
	public List<Language> langList;
	public List<String> dictList;
	public int selectedLangID;
	public String selectedDictName;
	public String word;
	public String url;
}