package com.zwstudio.lolly.ui.swing;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;

import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

public class LollyController {
	@Autowired private LanguageDao langDao;
	@Autowired private DictionaryDao dictDao;
	List<Language> langList;
	ObservableList<Dictionary> dictList = ObservableCollections.observableList(new ArrayList<Dictionary>());

}
