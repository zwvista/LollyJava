package com.zwstudio.lolly.ui.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zwstudio.lolly.util.LollyConfigHibernate;

@Configuration
@ComponentScan
public class LollyApp extends Application {
	private AnnotationConfigApplicationContext context;

	public static void main(String[] args) {
//    	System.setProperty("http.proxyHost", "gw3");
//    	System.setProperty("http.proxyPort", "80");
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
	
	public <T> T load(String url) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
			@Override
			public Object call(Class<?> param) {
				return context.getBean(param);
			}
		});
        return loader.load();
    }

	@Override
	public void start(Stage stage) throws IOException {
		LollyController ctl = context.getBean(LollyController.class);
		Parent page = load("main.fxml");
		Scene scene = new Scene(page);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		stage.setScene(scene);
		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, w -> ctl.windowShowing());
		stage.show();
	}
}
