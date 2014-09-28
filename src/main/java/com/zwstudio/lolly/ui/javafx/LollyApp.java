package com.zwstudio.lolly.ui.javafx;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Language;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LollyApp extends Application {
	private ClassPathXmlApplicationContext context;
	private LanguageDao langDao;
	private DictionaryDao dictDao;

	private List<Language> langList;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent page = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene scene = new Scene(page);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void initContext() {
		context = new ClassPathXmlApplicationContext("spring_context.xml");
		langDao = context.getBean(LanguageDao.class);
		langList = langDao.getData();
		dictDao = context.getBean(DictionaryDao.class);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
