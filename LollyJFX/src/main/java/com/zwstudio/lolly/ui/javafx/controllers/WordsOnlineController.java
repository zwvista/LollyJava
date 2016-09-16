package com.zwstudio.lolly.ui.javafx.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.ui.viewmodel.SettingsViewModel;

import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import lombok.Getter;

@Controller
public class WordsOnlineController extends SettingsViewModel implements Initializable {

	private static final long serialVersionUID = 1L;
	
	@FXML @Getter
    private Node view;
    @FXML
    private TextField tfWord;
    @FXML
    private WebView wvDictOnline;
    @FXML
    private WebView wvDictOffline;

    private JavaBeanStringProperty wordProp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@SuppressWarnings("unchecked")
	public void windowShowing() {
		try {
			wordProp = JavaBeanStringPropertyBuilder.create().bean(this).name("word").build();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		tfWord.textProperty().bindBidirectional(wordProp);

		wvDictOnline.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
			@Override
			public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
				if (!newValue.equals(State.SUCCEEDED)) return;
				String html = (String) wvDictOnline.getEngine().executeScript("document.documentElement.outerHTML");
				System.out.println(html);
				wvDictOnline_succeeded(html);
			}
		});

		langList = FXCollections.observableArrayList(langList);
		dictList = FXCollections.observableArrayList(dictList);
		textbookList = FXCollections.observableArrayList(textbookList);
		init();
	}
	
    @FXML
    public void btnSearch_tfWord_OnAction(ActionEvent event) {
    	wvDictOffline.setVisible(false);
    	String url = getUrlByWord(getWord());
    	wvDictOnline.getEngine().load(url);
    }
    
    private void wvDictOnline_succeeded(String html) {
    	if(!selectedDict.getDicttypename().equals("OFFLINE-ONLINE")) return;
    	try {
			html = extractFromHtml(html, getWord());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	wvDictOffline.getEngine().loadContent(html);
    	wvDictOnline.setVisible(false);
    	wvDictOffline.setVisible(true);
    }

}
