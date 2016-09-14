package com.zwstudio.lolly.ui.javafx.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;

import com.zwstudio.lolly.ui.javafx.LollyApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

@Controller
public class MainController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleWordsOnline() {
    	try {
			LollyApp.showWordsOnline();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void handleSelectUnits() {
    	try {
			LollyApp.showSettings();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
