package com.zwstudio.lolly.ui.swing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.SettingsViewModel;

import javafx.application.Platform;
import lombok.Getter;

public class LollyController extends SettingsViewModel {
	
	private static final long serialVersionUID = 1L;

	public LollyFrame view;

	@Getter
	public List<Language> langList;
	@Getter
	public List<Dictionary> dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());;

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
		dictList.addAll(dictDao.getDataByLang(selectedLang.getId()));
		setSelectedDict(dictList.get(0));
	}
	
	public void cmbDict_actionPerformed() {
//		if (selectedDict == null) return;
//		DictionaryId id2 = selectedDict.getId();
//		updateDict(id2);
	}
	
	public void btnSearch_tfWord_actionPerformed() {
    	view.layoutCenter.show(view.pnlCenter, "Online");
    	String url = getUrlByWord(getWord());
    	view.wvDictOnline.loadURL(url);
	}
	
	public void wvDictOnline_succeeded(String html) {
    	if(!selectedDict.getDicttypename().equals("OFFLINE-ONLINE")) return;
    	try {
			html = extractFromHtml(html, getWord());
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
