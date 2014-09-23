package com.zwstudio.lolly.ui.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LollyApp extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent page = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene scene = new Scene(page);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
