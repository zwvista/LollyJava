package com.zwstudio.lolly.ui.javafx.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.domain.Textbook;
import com.zwstudio.lolly.ui.viewmodel.SettingsViewModel;

import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

@Controller
@SuppressWarnings("serial")
public class SettingsController extends SettingsViewModel implements Initializable {
	
    @FXML
    private ComboBox<Language> cboLang;
    @FXML
    private ComboBox<Textbook> cboTextbook;
    @FXML
    private ComboBox<Dictionary> cboDict;
    @FXML
    private CheckBox chkTo;
    @FXML
    private ComboBox<String> cboUnitFrom;
    @FXML
    private ComboBox<String> cboUnitTo;
    @FXML
    private ComboBox<String> cboPartFrom;
    @FXML
    private ComboBox<String> cboPartTo;
    @FXML
    private Label lblUntsInAllFrom;
    @FXML
    private Label lblUntsInAllTo;

    private ObservableList<Language> langList;
    private ObservableList<Textbook> textbookList = FXCollections.observableArrayList();
    private ObservableList<Dictionary> dictList = FXCollections.observableArrayList();
    
    private JavaBeanObjectProperty<Language> selectedLangProp;
    private JavaBeanObjectProperty<Textbook> selectedTextbookProp;
    private JavaBeanObjectProperty<Dictionary> selectedDictProp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@SuppressWarnings("unchecked")
	public void windowShowing() {
		try {
			selectedLangProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedLang").build();
			selectedTextbookProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedTextbook").build();
			selectedDictProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedDict").build();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

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

		cboTextbook.valueProperty().bindBidirectional(selectedTextbookProp);
		cboTextbook.valueProperty().addListener(new ChangeListener<Textbook>() {
			@Override
			public void changed(
					ObservableValue<? extends Textbook> observable,
					Textbook oldValue, Textbook newValue) {
				cboTextbook_ValueChanged();
			}
		});
		cboTextbook.setConverter(new StringConverter<Textbook>() {
            @Override
            public String toString(Textbook book) {
            	return book == null ? null : book.getTextbookname();
            }

			@Override
			public Textbook fromString(String arg0) {
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
            	return dict == null ? null : dict.getDictname();
            }

			@Override
			public Dictionary fromString(String arg0) {
				return null;
			}
		});

		langList = FXCollections.observableArrayList(langDao.getData());
		
		cboLang.setItems(langList);
		cboTextbook.setItems(textbookList);
		cboDict.setItems(dictList);
		
		setSelectedLang(langList.get(1));
	}
	
	private void cboLang_ValueChanged() {
		if (selectedLang == null) return;
		int langid = selectedLang.getId();
		textbookList.setAll(textbookDao.getDataByLang(langid));
		
		setSelectedTextbook(textbookList.get(0));
		dictList.setAll(dictDao.getDataByLang(langid));
		setSelectedDict(dictList.get(0));
	}
	
	private void cboTextbook_ValueChanged() {
//		if (selectedtextbook == null) return;
//		Book id2 = selectedtextbook.getId();
//		updatebook(id2);
	}
	
	private void cboDict_ValueChanged() {
//		if (selectedtextbook == null) return;
//		Book id2 = selectedtextbook.getId();
//		updatebook(id2);
	}

}
