package com.zwstudio.lolly.ui.javafx.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.SettingsViewModel;

import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.util.StringConverter;
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
    @FXML
    private ComboBox<Language> cboLang;
    @FXML
    private ComboBox<Dictionary> cboDict;
    
    private JavaBeanObjectProperty<Language> selectedLangProp;
    private JavaBeanObjectProperty<Dictionary> selectedDictProp;
    private JavaBeanStringProperty wordProp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@SuppressWarnings("unchecked")
	public void windowShowing() {
		try {
			selectedLangProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedLang").build();
			selectedDictProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedDict").build();
			wordProp = JavaBeanStringPropertyBuilder.create().bean(this).name("word").build();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		tfWord.textProperty().bindBidirectional(wordProp);

		cboLang.valueProperty().bindBidirectional(selectedLangProp);
		cboLang.setConverter(new StringConverter<Language>() {
            @Override
            public String toString(Language lang) {
            	return lang == null ? null : lang.getLangname();
            }

			@Override
			public Language fromString(String arg0) {
				return null;
			}
		});

		cboDict.valueProperty().bindBidirectional(selectedDictProp);
		cboDict.setConverter(new StringConverter<Dictionary>() {
            @Override
            public String toString(Dictionary dict) {
            	return dict == null ? null : dict.getDictname();
            }

			@Override
			public Dictionary fromString(String arg0) {
				return null;
			}
		});
		
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
		cboLang.setItems((ObservableList<Language>)langList);
		cboDict.setItems((ObservableList<Dictionary>)dictList);		
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
