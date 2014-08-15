package com.zwstudio.lolly.ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LollyFrame extends JFrame {
	private JTextField textField;
	public LollyFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		FlowLayout fl_pnlTop = (FlowLayout) pnlTop.getLayout();
		fl_pnlTop.setAlignment(FlowLayout.LEFT);
		getContentPane().add(pnlTop, BorderLayout.NORTH);
		
		textField = new JTextField();
		pnlTop.add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.setHorizontalAlignment(SwingConstants.LEADING);
		pnlTop.add(btnGo);
		
		JPanel pnlBottom = new JPanel();
		getContentPane().add(pnlBottom, BorderLayout.SOUTH);
		pnlBottom.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLanguage = new JLabel("Language");
		pnlBottom.add(lblLanguage);
		
		JComboBox cmbLanguage = new JComboBox();
		lblLanguage.setLabelFor(cmbLanguage);
		pnlBottom.add(cmbLanguage);
		
		JLabel lblDictionary = new JLabel("Dictionary");
		pnlBottom.add(lblDictionary);
		
		JComboBox cmbDictionary = new JComboBox();
		lblDictionary.setLabelFor(cmbDictionary);
		pnlBottom.add(cmbDictionary);
	}

}
