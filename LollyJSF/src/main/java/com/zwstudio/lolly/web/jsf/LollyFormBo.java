package com.zwstudio.lolly.web.jsf;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.IDictAllService;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

@Service
public class LollyFormBo {

	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired @Qualifier("dictionaryDao")
	protected IDictionaryService dictDao;
	@Autowired @Qualifier("dictAllDao")
	protected IDictAllService dictallDao;
	
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
