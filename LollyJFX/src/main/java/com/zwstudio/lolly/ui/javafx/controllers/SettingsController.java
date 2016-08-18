package com.zwstudio.lolly.ui.javafx.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.domain.TextBook;
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
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

@Controller
@SuppressWarnings("serial")
public class SettingsController extends SettingsViewModel implements Initializable {
	
    @FXML
    private ComboBox<Language> cboLang;
    @FXML
    private ComboBox<TextBook> cboTextBook;
    @FXML
    private TextField tfUnitFrom;
    @FXML
    private CheckBox chkTo;
    @FXML
    private TextField tfUnitTo;
    @FXML
    private ComboBox<String> cboPartFrom;
    @FXML
    private ComboBox<String> cboPartTo;
////    @FXML
////    private Label lblUntsInAllFrom;
////    @FXML
////    private Label lblUntsInAllTo;
//
    private ObservableList<Language> langList;
    private ObservableList<TextBook> textbookList = FXCollections.observableArrayList();
    
    private JavaBeanObjectProperty<Language> selectedLangProp;
    private JavaBeanObjectProperty<TextBook> selectedTextBookProp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@SuppressWarnings("unchecked")
	public void windowShowing() {
		try {
			selectedLangProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedLang").build();
			selectedTextBookProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedTextBook").build();
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

		cboTextBook.valueProperty().bindBidirectional(selectedTextBookProp);
		cboTextBook.valueProperty().addListener(new ChangeListener<TextBook>() {
			@Override
			public void changed(
					ObservableValue<? extends TextBook> observable,
					TextBook oldValue, TextBook newValue) {
				cboTextBook_ValueChanged();
			}
		});
		cboTextBook.setConverter(new StringConverter<TextBook>() {
            @Override
            public String toString(TextBook book) {
            	return book == null ? null : book.getTextbookname();
            }

			@Override
			public TextBook fromString(String arg0) {
				return null;
			}
		});

		langList = FXCollections.observableArrayList(langDao.getData());
		
		cboLang.setItems(langList);
		cboTextBook.setItems(textbookList);
		
		setSelectedLang(langList.get(1));
	}
	
	private void cboLang_ValueChanged() {
		if (selectedLang == null) return;
		textbookList.setAll(textbookDao.getDataByLang(selectedLang.getId()));
		setSelectedTextBook(textbookList.get(0));
	}
	
	private void cboTextBook_ValueChanged() {
//		if (selectedtextbook == null) return;
//		Book id2 = selectedtextbook.getId();
//		updatebook(id2);
	}

}
