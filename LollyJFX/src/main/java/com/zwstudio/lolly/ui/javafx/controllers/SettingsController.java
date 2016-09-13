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
import javafx.util.Pair;
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
    private ComboBox<Integer> cboUnitFrom;
    @FXML
    private ComboBox<Integer> cboUnitTo;
    @FXML
    private ComboBox<Pair<Integer, String>> cboPartFrom;
    @FXML
    private ComboBox<Pair<Integer, String>> cboPartTo;
    @FXML
    private Label lblUnitsInAllFrom;
    @FXML
    private Label lblUnitsInAllTo;

    private JavaBeanObjectProperty<Language> selectedLangProp;
    private JavaBeanObjectProperty<Textbook> selectedTextbookProp;
    private JavaBeanObjectProperty<Dictionary> selectedDictProp;
    private JavaBeanObjectProperty<Integer> selectedUnitFromProp;
    private JavaBeanObjectProperty<Integer> selectedUnitToProp;
    private JavaBeanObjectProperty<Pair<Integer, String>> selectedPartFromProp;
    private JavaBeanObjectProperty<Pair<Integer, String>> selectedPartToProp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@SuppressWarnings("unchecked")
	public void windowShowing() {
		try {
			selectedLangProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedLang").build();
			selectedTextbookProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedTextbook").build();
			selectedDictProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedDict").build();
			selectedUnitFromProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedUnitFrom").build();
			selectedUnitToProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedUnitTo").build();
			selectedPartFromProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedPartFrom").build();
			selectedPartToProp = JavaBeanObjectPropertyBuilder.create().bean(this).name("selectedPartTo").build();
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
            public String toString(Textbook textbook) {
            	return textbook == null ? null : textbook.getTextbookname();
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

		StringConverter<Integer> intConverter2 = new StringConverter<Integer>() {
            @Override
            public String toString(Integer unit) {
            	return unit == null ? null : unit.toString();
            }

			@Override
			public Integer fromString(String unit) {
				return Integer.valueOf(unit);
			}
		};
		cboUnitFrom.valueProperty().bindBidirectional(selectedUnitFromProp);
		cboUnitFrom.setConverter(intConverter2);
		cboUnitTo.valueProperty().bindBidirectional(selectedUnitToProp);
		cboUnitTo.setConverter(intConverter2);
		
		StringConverter<Textbook> textbookConverter = new StringConverter<Textbook>() {
			@Override
			public String toString(Textbook textbook) {
				return textbook == null ? null : String.format("(%d in all)", textbook.getUnits());
			}

			@Override
			public Textbook fromString(String string) {
				return null;
			}
		};
		lblUnitsInAllFrom.textProperty().bindBidirectional(selectedTextbookProp, textbookConverter);
		lblUnitsInAllTo.textProperty().bindBidirectional(selectedTextbookProp, textbookConverter);

		StringConverter<Pair<Integer, String>> intConverter = new StringConverter<Pair<Integer, String>>() {
            @Override
            public String toString(Pair<Integer, String> part) {
            	return part == null ? null : part.getValue();
            }

			@Override
			public Pair<Integer, String> fromString(String part) {
				return null;
			}
		};
		cboPartFrom.valueProperty().bindBidirectional(selectedPartFromProp);
		cboPartFrom.setConverter(intConverter);
		cboPartTo.valueProperty().bindBidirectional(selectedPartToProp);
		cboPartTo.setConverter(intConverter);

		langList = FXCollections.observableArrayList(langList);
		dictList = FXCollections.observableArrayList(dictList);
		textbookList = FXCollections.observableArrayList(textbookList);
		unitList = FXCollections.observableArrayList(unitList);
		partList = FXCollections.observableArrayList(partList);
		
		cboLang.setItems((ObservableList<Language>)langList);
		cboDict.setItems((ObservableList<Dictionary>)dictList);
		cboTextbook.setItems((ObservableList<Textbook>)textbookList);
		cboUnitFrom.setItems((ObservableList<Integer>)unitList);
		cboUnitTo.setItems((ObservableList<Integer>)unitList);
		cboPartFrom.setItems((ObservableList<Pair<Integer, String>>)partList);
		cboPartTo.setItems((ObservableList<Pair<Integer, String>>)partList);
		
		init();
	}
}
