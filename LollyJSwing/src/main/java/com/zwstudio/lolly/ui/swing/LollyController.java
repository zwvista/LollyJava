package com.zwstudio.lolly.ui.swing;

import java.io.IOException;

import org.jdesktop.observablecollections.ObservableCollections;

import com.zwstudio.lolly.ui.viewmodel.SettingsViewModel;

import javafx.application.Platform;

@SuppressWarnings("serial")
public class LollyController extends SettingsViewModel {

	public LollyFrame view;

	public void init(LollyFrame view) {
		this.view = view;
		view.controller = this;
		langList = ObservableCollections.observableList(langList);
		dictList = ObservableCollections.observableList(dictList);
		textbookList = ObservableCollections.observableList(textbookList);
		super.init();
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
