package com.zwstudio.lolly.ui.javafx.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.WordsOnlineViewModel;

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
public class WordsOnlineController extends WordsOnlineViewModel implements Initializable {

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
    
    private ObservableList<Language> langList;
    private ObservableList<Dictionary> dictList = FXCollections.observableArrayList();
    
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
		cboLang.valueProperty().addListener(new ChangeListener<Language>() {
			@Override
			public void changed(ObservableValue<? extends Language> observable,
					Language oldValue, Language newValue) {
				cboLang_ValueChanged();
			}
		});
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
		cboDict.valueProperty().addListener(new ChangeListener<Dictionary>() {
			@Override
			public void changed(
					ObservableValue<? extends Dictionary> observable,
					Dictionary oldValue, Dictionary newValue) {
				cboDict_ValueChanged();
			}
		});
		cboDict.setConverter(new StringConverter<Dictionary>() {
            @Override
            public String toString(Dictionary dict) {
            	return dict == null ? null : dict.getId().getDictname();
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

		langList = FXCollections.observableArrayList(langDao.getData());
		
		cboLang.setItems(langList);
		cboDict.setItems(dictList);
		
		setSelectedLang(langList.get(1));
		setWord("一人");
	}
	
	private void cboLang_ValueChanged() {
		if (selectedLang == null) return;
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(selectedLang.getLangid()));
		setSelectedDict(dictList.get(0));
	}
	
	private void cboDict_ValueChanged() {
		if (selectedDict == null) return;
		DictionaryId id2 = selectedDict.getId();
		updateDict(id2);
	}
	
    @FXML
    public void btnSearch_tfWord_OnAction(ActionEvent event) {
    	wvDictOffline.setVisible(false);
    	String url = getUrlByWord(word);
    	wvDictOnline.getEngine().load(url);
    }
    
    private void wvDictOnline_succeeded(String html) {
    	if(!dict.getDicttypename().equals("OFFLINE-ONLINE")) return;
    	try {
			html = extractFromHtml(html, word);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	wvDictOffline.getEngine().loadContent(html);
    	wvDictOnline.setVisible(false);
    	wvDictOffline.setVisible(true);
    }

}
