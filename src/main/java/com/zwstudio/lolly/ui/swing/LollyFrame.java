package com.zwstudio.lolly.ui.swing;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.util.LollyConfig;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.Rectangle;
import java.awt.Font;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LollyFrame extends JFrame {
	private AnnotationConfigApplicationContext context;
	private LanguageDao langDao;
	private DictionaryDao dictDao;
	
	private List<Language> langList;
	private ObservableList<Dictionary> dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());
	private JComboBox cmbLanguage;
	private JComboBox cmbDictionary;
	
	public LollyFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				context.close();
				System.exit(0);
			}
		});
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
		cmbLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Language lang = (Language)cmbLanguage.getSelectedItem();
				if (lang == null) return;
				dictList.clear();
				dictList.addAll(dictDao.getDataByLang(lang.getLangid()));
			}
		});
		lblLanguage.setLabelFor(cmbLanguage);
		pnlBottom.add(cmbLanguage);
		
		JLabel lblDictionary = new JLabel("Dictionary:");
		pnlBottom.add(lblDictionary);
		
		cmbDictionary = new JComboBox();
		lblDictionary.setLabelFor(cmbDictionary);
		pnlBottom.add(cmbDictionary);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pnlBottom, getContentPane(), pnlTop, textField, btnSearch, lblLanguage, cmbLanguage, lblDictionary, cmbDictionary}));

		cmbLanguage.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Language) {
                    value = ((Language)value).getLangname();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
		cmbDictionary.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Dictionary) {
                    value = ((Dictionary)value).getId().getDictname();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
		
		initContext();
		initDataBindings();
		setVisible(true);
	}

	private void initContext() {
		context = new AnnotationConfigApplicationContext(LollyConfig.class);
		langDao = context.getBean(LanguageDao.class);
		langList = langDao.getData();
		dictDao = context.getBean(DictionaryDao.class);
	}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
    		LollyFrame frame = new LollyFrame();
        });
    }
	protected void initDataBindings() {
		JComboBoxBinding<Language, List<Language>, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, langList, cmbLanguage);
		jComboBinding.bind();
		//
		JComboBoxBinding<Dictionary, List<Dictionary>, JComboBox> jComboBinding_1 = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, dictList, cmbDictionary);
		jComboBinding_1.bind();
	}
}
