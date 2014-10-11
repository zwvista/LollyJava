package com.zwstudio.lolly.ui.swing;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.LollyViewModel;

public class LollyController extends LollyViewModel {
	
	public LollyFrame view;
	
	public List<Language> langList;
	public List<Dictionary> dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());;

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
		setSelectedLang(langList.get(1));
		setWord("一人");
	}
	
	public void cmbLang_actionPerformed() {
		if (selectedLang == null) return;
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(selectedLang.getLangid()));
		setSelectedDict(dictList.get(0));
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