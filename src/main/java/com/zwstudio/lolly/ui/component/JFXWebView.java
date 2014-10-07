package com.zwstudio.lolly.ui.component;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class JFXWebView extends JFXPanel {
	
	private static final long serialVersionUID = 1L;
	private WebEngine engine;
	
	public JFXWebView() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				WebView view = new WebView();
				engine = view.getEngine();
		        setScene(new Scene(view));
			}
		});
	}
	
    public void loadURL(String url) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	engine.load(url);
            }
        });
    }}
