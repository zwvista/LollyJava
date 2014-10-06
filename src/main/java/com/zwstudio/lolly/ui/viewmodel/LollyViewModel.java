package com.zwstudio.lolly.ui.viewmodel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

	protected void updateDict(DictionaryId id2) {
		dict = dictAllList.stream()
			.filter(r -> {
				DictAllId id1 = r.getId();
				return id1.getLangid() == id2.getLangid() &&
						id1.getDictname().equals(id2.getDictname());
			})
			.findFirst().get();
	}
	
	protected String getUrlByWord(String word) {
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
