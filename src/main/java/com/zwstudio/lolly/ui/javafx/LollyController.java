package com.zwstudio.lolly.ui.javafx;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LollyController implements Initializable {
    @FXML
    private Node view;

    @FXML
    private TextField tfWord;

    @FXML
    private ComboBox<Language> cmbLang;

    @FXML
    private ComboBox<Dictionary> cmbDict;
    
	@Autowired private LanguageDao langDao;
	@Autowired private DictionaryDao dictDao;
	
	private ObservableList<Language> langList;
	private ObservableList<Dictionary> dictList = FXCollections.observableArrayList(new ArrayList<Dictionary>());

    public Node getView() {
        return view;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void windowShowing() {
		langList = FXCollections.observableArrayList(langDao.getData());
		cmbLang.setItems(langList);
	}
	
    @FXML
    public void langOnAction(ActionEvent event) {
    	
    }

}
