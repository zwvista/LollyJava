package com.zwstudio.lolly.ui.viewmodel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.DictAllId;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;

public class LollyViewModel {
	@Autowired
	protected LanguageDao langDao;
	@Autowired
	protected DictionaryDao dictDao;
	@Autowired
	protected DictAllDao dictallDao;
	
	protected List<DictAll> dictAllList;
	protected DictAll dict;

}
