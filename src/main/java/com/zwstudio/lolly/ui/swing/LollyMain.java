package com.zwstudio.lolly.ui.swing;

import javax.swing.SwingUtilities;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zwstudio.lolly.dao.LanguageDao;

public class LollyMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
    		LollyFrame frame = new LollyFrame();
        });
    }

}
