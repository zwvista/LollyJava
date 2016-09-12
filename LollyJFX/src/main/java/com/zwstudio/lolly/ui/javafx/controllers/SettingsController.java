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

		langList = FXCollections.observableArrayList(langList);
		dictList = FXCollections.observableArrayList(dictList);
		textbookList = FXCollections.observableArrayList(textbookList);
		cboLang.setItems((ObservableList<Language>)langList);
		cboDict.setItems((ObservableList<Dictionary>)dictList);
		cboTextbook.setItems((ObservableList<Textbook>)textbookList);		
		init();
	}
}
