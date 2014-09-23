package com.zwstudio.lolly.ui.swing;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Language;

import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.Rectangle;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class LollyFrame extends JFrame {
	private List<Language> langs;
	private JComboBox cmbLanguage;
	
	public LollyFrame() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBounds(new Rectangle(0, 0, 800, 600));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		getContentPane().add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new BorderLayout(0, 0));
		
		JTextField textField = new JTextField();
		pnlTop.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		pnlTop.add(btnSearch, BorderLayout.EAST);
		
		JPanel pnlBottom = new JPanel();
		getContentPane().add(pnlBottom, BorderLayout.SOUTH);
		pnlBottom.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLanguage = new JLabel("Language:");
		pnlBottom.add(lblLanguage);
		
		cmbLanguage = new JComboBox();
		lblLanguage.setLabelFor(cmbLanguage);
		pnlBottom.add(cmbLanguage);
		
		JLabel lblDictionary = new JLabel("Dictionary:");
		pnlBottom.add(lblDictionary);
		
		JComboBox cmbDictionary = new JComboBox();
		lblDictionary.setLabelFor(cmbDictionary);
		pnlBottom.add(cmbDictionary);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pnlBottom, getContentPane(), pnlTop, textField, btnSearch, lblLanguage, cmbLanguage, lblDictionary, cmbDictionary}));

		initContext();
		initDataBindings();
		setVisible(true);
	}

	private void initContext() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_context.xml");
		LanguageDao langDao = context.getBean(LanguageDao.class);
		langs = langDao.list();
	}

	protected void initDataBindings() {
		JComboBoxBinding<Language, List<Language>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, langs, cmbLanguage);
		jComboBinding.bind();
	}
}
