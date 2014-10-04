package com.zwstudio.lolly.util;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zwstudio.lolly.ui.swing.LollyController;

@Configuration
public class LollyConfigSwing {
	
	@Bean
    public LollyController lollyController() throws IOException {
        return new LollyController();
    }

}
