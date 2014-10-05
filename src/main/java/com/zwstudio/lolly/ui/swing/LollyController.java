package com.zwstudio.lolly.ui.swing;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;

import com.zwstudio.lolly.domain.DictAllId;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.LollyViewModel;

public class LollyController extends LollyViewModel {
	
	public String word;
	public List<Language> langList;
	public List<Dictionary> dictList;
	public Language selectedLang;
	public Dictionary selectedDict;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Language getSelectedLang() {
		return selectedLang;
	}

	public void setSelectedLang(Language selectedLang) {
		this.selectedLang = selectedLang;
	}

	public Dictionary getSelectedDict() {
		return selectedDict;
	}

	public void setSelectedDict(Dictionary selectedDict) {
		this.selectedDict = selectedDict;
	}

	public List<Language> getLangList() {
		return langList;
	}

	public List<Dictionary> getDictList() {
		return dictList;
	}

	void init() {
		langList = langDao.getData();
		dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());
		dictAllList = dictallDao.getData();
	}
	
	public void cmbLang_actionPerformed() {
		if (selectedLang == null) return;
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(selectedLang.getLangid()));
	}
	
	public void cmbDict_actionPerformed() {
		if (selectedDict == null) return;
		DictionaryId id2 = selectedDict.getId();
		dict = dictAllList.stream()
			.filter(r -> {
				DictAllId id1 = r.getId();
				return id1.getLangid() == id2.getLangid() &&
						id1.getDictname().equals(id2.getDictname());
			})
			.findFirst().get();
	}
	
	void btnSearch_actionPerformed() {
	}
}
