package com.zwstudio.lolly.web.springmvc;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import com.zwstudio.lolly.domain.Language;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LollyFormBean {
	@NotBlank
	public String word;
	public int selectedLangID;
	public String selectedDictName;
	public List<Language> langList;
	public Map<String, String> langMap;
}
