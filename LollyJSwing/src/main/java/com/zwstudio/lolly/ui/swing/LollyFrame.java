package com.zwstudio.lolly.ui.swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.ui.component.JFXWebView;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;

public class LollyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	LollyController controller;
	
	private JPanel contentPane;
	private JComboBox cmbLang;
	private JComboBox cmbDict;
	private JTextField textWord;
	
	JFXWebView wvDictOffline;
	JFXWebView wvDictOnline;
	JPanel pnlCenter;
	CardLayout layoutCenter;
	
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
		
		textWord = new JTextField();
		textWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnSearch_tfWord_actionPerformed();
			}
		});
		pnlTop.add(textWord, BorderLayout.CENTER);
		textWord.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.btnSearch_tfWord_actionPerformed();
			}
		});
		pnlTop.add(btnSearch, BorderLayout.EAST);
		
		JPanel pnlBottom = new JPanel();
		getContentPane().add(pnlBottom, BorderLayout.SOUTH);
		pnlBottom.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblLanguage = new JLabel("Language:");
		pnlBottom.add(lblLanguage);
		
		cmbLang = new JComboBox();
		lblLanguage.setLabelFor(cmbLang);
		pnlBottom.add(cmbLang);
		
		JLabel lblDictionary = new JLabel("Dictionary:");
		pnlBottom.add(lblDictionary);
		
		cmbDict = new JComboBox();
		lblDictionary.setLabelFor(cmbDict);
		pnlBottom.add(cmbDict);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pnlBottom, getContentPane(), pnlTop, textWord, btnSearch, lblLanguage, cmbLang, lblDictionary, cmbDict}));
	
		cmbLang.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Language) {
                    value = ((Language)value).getLangname();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
		cmbDict.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Dictionary) {
                    value = ((Dictionary)value).getDictname();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
		
		pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new CardLayout(0, 0));
		
		wvDictOffline = new JFXWebView();
		pnlCenter.add(wvDictOffline, "Offline");
		wvDictOnline = new JFXWebView();
		pnlCenter.add(wvDictOnline, "Online");
		layoutCenter = (CardLayout)pnlCenter.getLayout();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				wvDictOnline.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
					@Override
					public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
						if (!newValue.equals(State.SUCCEEDED)) return;
						String html = (String) wvDictOnline.getEngine().executeScript("document.documentElement.outerHTML");
						EventQueue.invokeLater(new Runnable() {
							@Override
							public void run() {
								controller.wvDictOnline_succeeded(html);			
							}
						});
					}
				});
			}
		});

		controller.init(this);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    initDataBindings();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	protected void initDataBindings() {
		BeanProperty<LollyController, List<Language>> lollyControllerBeanProperty = BeanProperty.create("langList");
		JComboBoxBinding<Language, LollyController, JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, controller, lollyControllerBeanProperty, cmbLang);
		jComboBinding.bind();
		//
		BeanProperty<LollyController, List<Dictionary>> lollyControllerBeanProperty_1 = BeanProperty.create("dictList");
		JComboBoxBinding<Dictionary, LollyController, JComboBox> jComboBinding_1 = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ, controller, lollyControllerBeanProperty_1, cmbDict);
		jComboBinding_1.bind();
		//
		BeanProperty<LollyController, Language> lollyControllerBeanProperty_2 = BeanProperty.create("selectedLang");
		BeanProperty<JComboBox, Language> jComboBoxBeanProperty = BeanProperty.create("selectedItem");
		AutoBinding<LollyController, Language, JComboBox, Language> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, controller, lollyControllerBeanProperty_2, cmbLang, jComboBoxBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<LollyController, Dictionary> lollyControllerBeanProperty_3 = BeanProperty.create("selectedDict");
		BeanProperty<JComboBox, Dictionary> jComboBoxBeanProperty_1 = BeanProperty.create("selectedItem");
		AutoBinding<LollyController, Dictionary, JComboBox, Dictionary> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, controller, lollyControllerBeanProperty_3, cmbDict, jComboBoxBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<LollyController, String> lollyControllerBeanProperty_4 = BeanProperty.create("word");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<LollyController, String, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, controller, lollyControllerBeanProperty_4, textWord, jTextFieldBeanProperty);
		autoBinding_2.bind();
	}
}
