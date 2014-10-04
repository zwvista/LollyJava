package com.zwstudio.lolly.ui.swing;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

import java.awt.Font;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LollyFrame extends JFrame {

	LollyController controller;
	
	private JPanel contentPane;
	JComboBox cmbLang;
	JComboBox cmbDict;

	/**
	 * Create the frame.
	 */
	public LollyFrame(LollyController controller) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
		
		cmbLang = new JComboBox();
		cmbLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.cmbLang_actionPerformed();
			}
		});
		lblLanguage.setLabelFor(cmbLang);
		pnlBottom.add(cmbLang);
		
		JLabel lblDictionary = new JLabel("Dictionary:");
		pnlBottom.add(lblDictionary);
		
		cmbDict = new JComboBox();
		lblDictionary.setLabelFor(cmbDict);
		pnlBottom.add(cmbDict);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pnlBottom, getContentPane(), pnlTop, textField, btnSearch, lblLanguage, cmbLang, lblDictionary, cmbDict}));
	
		this.controller = controller;
		controller.init(this);
		initDataBindings();
	}

	protected void initDataBindings() {
		JComboBoxBinding<Language, List<Language>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, controller.langList, cmbLang);
		jComboBinding.bind();
		//
		JComboBoxBinding<Dictionary, List<Dictionary>, JComboBox> jComboBinding_1 = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, controller.dictList, cmbDict);
		jComboBinding_1.bind();
	}
}
