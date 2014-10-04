package com.zwstudio.lolly.ui.swing;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;

import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

public class LollyController {
	@Autowired
	private LanguageDao langDao;
	@Autowired
	private DictionaryDao dictDao;
	
	LollyFrame view;
	
	List<Language> langList;
	ObservableList<Dictionary> dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());

	void init(LollyFrame view) {
		this.view = view;
		
		langList = langDao.getData();
		
		view.cmbLang.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Language) {
                    value = ((Language)value).getLangname();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
		view.cmbDict.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Dictionary) {
                    value = ((Dictionary)value).getId().getDictname();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        });
	}
	
	void cmbLang_actionPerformed() {
		Language lang = (Language)view.cmbLang.getSelectedItem();
		if (lang == null) return;
		dictList.clear();
		dictList.addAll(dictDao.getDataByLang(lang.getLangid()));
	}
}
