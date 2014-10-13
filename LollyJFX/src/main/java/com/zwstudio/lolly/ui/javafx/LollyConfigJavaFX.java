package com.zwstudio.lolly.ui.javafx;

import javafx.fxml.FXMLLoader;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


@Configuration
public class LollyConfigJavaFX {
	
	@Bean
    public LollyController lollyController() throws IOException {
        return (LollyController)loadController(LollyController.class.getResourceAsStream("main.fxml"));
    }
 
    protected Object loadController(InputStream fxmlStream) throws IOException {
        try {
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
