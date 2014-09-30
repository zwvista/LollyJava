package com.zwstudio.lolly.util;

import javafx.fxml.FXMLLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import com.zwstudio.lolly.ui.javafx.LollyController;


@Configuration
public class LollyConfigJavaFX {
	
	@Bean
    public LollyController mainController() throws IOException {
        return (LollyController)loadController(LollyController.class.getResource("main.fxml"));
    }
 
    protected Object loadController(URL url) throws IOException {
        InputStream fxmlStream = null;
        try {
            fxmlStream = url.openStream();
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return loader.getController();
        }
        finally {
            if (fxmlStream != null)
                fxmlStream.close();
        }
    }

}
