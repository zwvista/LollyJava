package com.zwstudio.lolly.ui.swing;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LollyConfigSwing {
	
	@Bean
    public LollyController lollyController() throws IOException {
        return new LollyController();
    }

}
