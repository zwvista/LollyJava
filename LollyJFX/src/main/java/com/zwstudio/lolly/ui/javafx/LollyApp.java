package com.zwstudio.lolly.ui.javafx;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zwstudio.lolly.ui.javafx.controllers.SettingsController;
import com.zwstudio.lolly.ui.javafx.controllers.WordsOnlineController;
import com.zwstudio.lolly.util.LollyConfigHibernate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

@Configuration
@ComponentScan("com.zwstudio.lolly.ui.javafx.controllers")
public class LollyApp extends Application {
	private static AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
		launch(args);
	}
    
	@Override
	public void init() throws Exception {
		super.init();
		context = new AnnotationConfigApplicationContext(LollyConfigHibernate.class, LollyApp.class);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		context.close();
	}
	
	public static <T> T load(String url) throws IOException {
        FXMLLoader loader = new FXMLLoader(LollyApp.class.getResource(url));
        loader.setControllerFactory(context::getBean);
        return loader.load();
    }

	@Override
	public void start(Stage stage) throws IOException {
		showMain(stage);
	}
	
	public static void showMain(Stage stage) throws IOException {
		Parent page = load("views/Main.fxml");
		Scene scene = new Scene(page);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void showWordsOnline() throws IOException {
    	WordsOnlineController ctl = context.getBean(WordsOnlineController.class);
		Parent page = load("views/WordsOnline.fxml");
		Scene scene = new Scene(page);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, w -> ctl.windowShowing());
		stage.show();
	}
	
	public static void showSettings() throws IOException {
		SettingsController ctl = context.getBean(SettingsController.class);
		Parent page = load("views/Settings.fxml");
		Scene scene = new Scene(page);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, w -> ctl.windowShowing());
		stage.showAndWait();
	}
}
