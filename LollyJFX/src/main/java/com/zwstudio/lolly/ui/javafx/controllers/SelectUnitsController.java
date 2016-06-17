package com.zwstudio.lolly.ui.javafx.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.domain.Book;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.viewmodel.SelectUnitsViewModel;

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
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

@Controller
@SuppressWarnings("serial")
public class SelectUnitsController extends SelectUnitsViewModel implements Initializable {
	
    @FXML
    private ComboBox<Language> cmbLang;
    @FXML
    private ComboBox<Book> cmbbook;
    @FXML
    private TextField tfUnitFrom;
    @FXML
    private CheckBox chkTo;
    @FXML
    private TextField tfUnitTo;
    @FXML
    private ComboBox<?> cboPartFrom;
    @FXML
    private ComboBox<?> cboPartTo;
    @FXML
    private Label lblUntsInAllFrom;
    @FXML
    private Label lblUntsInAllTo;

    private ObservableList<Language> langList;
    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    
    private JavaBeanObjectProperty<Language> selectedLangProp;
    private JavaBeanObjectProperty<Book> selectedbookProp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@SuppressWarnings("unchecked")
	public void windowShowing() {
		try {
			selectedLangProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedLang").build();
			selectedbookProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedbook").build();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		cmbLang.valueProperty().bindBidirectional(selectedLangProp);
		cmbLang.valueProperty().addListener(new ChangeListener<Language>() {
			@Override
			public void changed(ObservableValue<? extends Language> observable,
					Language oldValue, Language newValue) {
				cmbLang_ValueChanged();
			}
		});
		cmbLang.setConverter(new StringConverter<Language>() {
            @Override
            public String toString(Language lang) {
            	return lang == null ? null : lang.getLangname();
            }

			@Override
			public Language fromString(String arg0) {
				return null;
			}
		});

		cmbbook.valueProperty().bindBidirectional(selectedbookProp);
		cmbbook.valueProperty().addListener(new ChangeListener<Book>() {
			@Override
			public void changed(
					ObservableValue<? extends Book> observable,
					Book oldValue, Book newValue) {
				cmbbook_ValueChanged();
			}
		});
		cmbbook.setConverter(new StringConverter<Book>() {
            @Override
            public String toString(Book book) {
            	return book == null ? null : book.getBookname();
            }

			@Override
			public Book fromString(String arg0) {
				return null;
			}
		});

		langList = FXCollections.observableArrayList(langDao.getData());
		
		cmbLang.setItems(langList);
		cmbbook.setItems(bookList);
		
		setSelectedLang(langList.get(1));
	}
	
	private void cmbLang_ValueChanged() {
//		if (selectedLang == null) return;
//		bookList.clear();
//		bookList.addAll(bookDao.getDataByLang(selectedLang.getLangid()));
//		setSelectedbook(bookList.get(0));
	}
	
	private void cmbbook_ValueChanged() {
//		if (selectedbook == null) return;
//		Book id2 = selectedbook.getId();
//		updatebook(id2);
	}

}
