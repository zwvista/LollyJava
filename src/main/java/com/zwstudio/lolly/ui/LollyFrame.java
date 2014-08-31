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
import javax.swing.SwingUtilities;

public class LollyFrame extends JFrame {
	private JTextField textField;
	public LollyFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTop = new JPanel();
		getContentPane().add(pnlTop, BorderLayout.NORTH);
		pnlTop.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		pnlTop.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		pnlTop.add(btnGo, BorderLayout.EAST);
		
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
            	LollyFrame browser = new LollyFrame();
                browser.setVisible(true);
            }
        });
    }
}
