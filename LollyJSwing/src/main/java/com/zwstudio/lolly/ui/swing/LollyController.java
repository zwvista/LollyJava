package com.zwstudio.lolly.ui.swing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;

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
    	view.layoutCenter.show(view.pnlCenter, "Online");
    	String url = getUrlByWord(word);
    	view.wvDictOnline.loadURL(url);
	}
	
	public void wvDictOnline_succeeded(String html) {
    	if(!dict.getDicttypename().equals("OFFLINE-ONLINE")) return;
    	try {
			html = extractFromHtml(html, word);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	final String text = html;
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
		    	view.wvDictOffline.getEngine().loadContent(text);
		    	view.layoutCenter.show(view.pnlCenter, "Offline");
			}
		});
    }
}
