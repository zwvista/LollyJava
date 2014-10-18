package com.zwstudio.lolly.spring;

import java.util.List;

import com.zwstudio.lolly.domain.Language;

public class LollyFormBean {
	private String word;
	private int selectedLangID;
	private String selectedDictName;
	private List<Language> langList;
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
		return langList;
	}
	public void setLangList(List<Language> langList) {
		this.langList = langList;
	}
}
