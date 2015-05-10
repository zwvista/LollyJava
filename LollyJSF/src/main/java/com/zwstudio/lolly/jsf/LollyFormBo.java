package com.zwstudio.lolly.jsf;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.dao.DictionaryDao;
import com.zwstudio.lolly.dao.LanguageDao;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Language;

@Service
public class LollyFormBo {

	@Autowired
	private LanguageDao langDao;
	@Autowired
	private DictionaryDao dictDao;
	@Autowired
	private DictAllDao dictallDao;
	
	public List<Language> getLangList() {
		return langDao.getData();
	}
	
	public List<String> getDictList(int langid) {
		return dictDao.getNamesByLang(langid);
	}
	
	public String getUrl(int langid, String dictname, String word) {
		DictAll dict = dictallDao.getDataByLangDict(langid, dictname);
		String url = dict.getUrl().replace("{0}", "%s");
		try {
			url = String.format(url, URLEncoder.encode(word, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(url);
		return url;
	}

}
