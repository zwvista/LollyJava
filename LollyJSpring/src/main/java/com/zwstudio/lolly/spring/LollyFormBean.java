package com.zwstudio.lolly.spring;

import java.util.List;
import java.util.Map;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

public class LollyFormBean {
	private String word;
	private Language selectLang;
	private Dictionary selectDict;
	private List<Language> langList;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Language getSelectLang() {
		return selectLang;
	}

	public void setSelectLang(Language selectLang) {
		this.selectLang = selectLang;
	}

	public Dictionary getSelectDict() {
		return selectDict;
	}

	public void setSelectDict(Dictionary selectDict) {
		this.selectDict = selectDict;
	}

	public List<Language> getLangList() {
		return langList;
	}

	public void setLangList(List<Language> langList) {
		this.langList = langList;
	}
}
