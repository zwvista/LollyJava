package com.zwstudio.lolly.ui.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.util.LollyConfigHibernate;

public class LollyMain {
	
	static AnnotationConfigApplicationContext context;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
    	System.setProperty("http.proxyHost", "10.20.160.251");
    	System.setProperty("http.proxyPort", "8080");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setUIFont(new FontUIResource("Dialog", Font.PLAIN, 15));
		context = new AnnotationConfigApplicationContext(LollyConfigHibernate.class, LollyConfigSwing.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LollyFrame frame = new LollyFrame(context.getBean(LollyController.class));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void setUIFont(javax.swing.plaf.FontUIResource f)
	{   
	    Enumeration<Object> keys = UIManager.getDefaults().keys();
	    while(keys.hasMoreElements())
	    {
	        Object key = keys.nextElement();
	        Object value = UIManager.get(key);
	        if(value instanceof FontUIResource) UIManager.put(key, f);
	    }
	}}
