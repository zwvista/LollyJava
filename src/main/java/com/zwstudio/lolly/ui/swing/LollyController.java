package com.zwstudio.lolly.ui.swing;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.LollyViewModel;

public class LollyController extends LollyViewModel {
	
	public LollyFrame view;
	
	public String word;
	public List<Language> langList;
	public List<Dictionary> dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());;
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

	public void init(LollyFrame view) {
		this.view = view;
		view.controller = this;

		dictAllList = dictallDao.getData();
		langList = langDao.getData();
	}
	
	public void cmbLang_actionPerformed() {
		if (selectedLang == null) return;
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(selectedLang.getLangid()));
	}
	
	public void cmbDict_actionPerformed() {
		if (selectedDict == null) return;
		DictionaryId id2 = selectedDict.getId();
		updateDict(id2);
	}
	
	public void btnSearch_tfWord_actionPerformed() {
    	view.wvDictOffline.setVisible(false);
    	String url = getUrlByWord(word);
    	view.wvDictOnline.loadURL(url);
	}
}
