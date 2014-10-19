package com.zwstudio.lolly.jfs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;

@Service
public class LollyFormBo {

	@Autowired
	private LanguageDao langDao;
	@Autowired
	private DictionaryDao dictDao;
	@Autowired
	private DictAllDao dictallDao;
	
	public Map<String, String> getLangMap() {
		return langDao.getNameIdMap();
	}
	
	public Map<String, String> getDictMap(int langid) {
		return dictDao.getNameIdMap(langid);
	}

}
