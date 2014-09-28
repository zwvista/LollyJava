package com.zwstudio.lolly.ui.javafx;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LollyController implements Initializable {

    @FXML
    private Button btnSearch;

    @FXML
    private TextField tfWord;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    void langOnAction(ActionEvent event) {
    	
    }

}
