package com.zwstudio.lolly.ui;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Language;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class LollyFrame extends JFrame {
	static List<Language> result;
	private JComboBox cmbLanguage;
	
	public LollyFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		getContentPane().add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new BorderLayout(0, 0));
		
		JTextField textField = new JTextField();
		pnlTop.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		pnlTop.add(btnGo, BorderLayout.EAST);
		
		JPanel pnlBottom = new JPanel();
		getContentPane().add(pnlBottom, BorderLayout.SOUTH);
		pnlBottom.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLanguage = new JLabel("Language");
		pnlBottom.add(lblLanguage);
		
		cmbLanguage = new JComboBox();
		lblLanguage.setLabelFor(cmbLanguage);
		pnlBottom.add(cmbLanguage);
		
		JLabel lblDictionary = new JLabel("Dictionary");
		pnlBottom.add(lblDictionary);
		
		JComboBox cmbDictionary = new JComboBox();
		lblDictionary.setLabelFor(cmbDictionary);
		pnlBottom.add(cmbDictionary);
		initDataBindings();
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
    		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_context.xml");
    		LanguageDao langdao = context.getBean(LanguageDao.class);
    		result = langdao.list();

    		LollyFrame frame = new LollyFrame();
        	frame.setVisible(true);
        });
    }
	protected void initDataBindings() {
		JComboBoxBinding<Language, List<Language>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, result, cmbLanguage);
		jComboBinding.bind();
	}
}
