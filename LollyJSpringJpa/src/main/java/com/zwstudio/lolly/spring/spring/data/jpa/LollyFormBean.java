package com.zwstudio.lolly.spring.spring.data.jpa;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import com.zwstudio.lolly.domain.Language;

@Getter @Setter
public class LollyFormBean {
	public String word;
	public int selectedLangID;
	public String selectedDictName;
	public List<Language> langList;
	public Map<String, String> langMap;
}
