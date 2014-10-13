package com.zwstudio.lolly.ui.javafx;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.util.LollyConfig;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LollyApp extends Application {
	private AnnotationConfigApplicationContext context;

	@Override
	public void start(Stage stage) throws IOException {
		context = new AnnotationConfigApplicationContext(LollyConfig.class, LollyConfigJavaFX.class);
		LollyController ctl = context.getBean(LollyController.class);
		Parent page = (Parent)ctl.getView();
		Scene scene = new Scene(page);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		stage.setScene(scene);
		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, w -> ctl.windowShowing());
		stage.show();
	}

	public static void main(String[] args) {
//    	System.setProperty("http.proxyHost", "gw3");
//    	System.setProperty("http.proxyPort", "80");
		launch(args);
	}
}
