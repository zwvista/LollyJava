package com.zwstudio.lolly.jooq.service;

import static com.zwstudio.lolly.jooq.Tables.VDICTIONARIES;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.services.IDictionaryService;

@Service
@Transactional
public class DictionaryService2 implements IDictionaryService {
	
    @Autowired
    DSLContext create;

	@Override
	public List<Dictionary> getDataByLang(int langid) {
		return create.selectFrom(VDICTIONARIES)
				.where(VDICTIONARIES.LANGIDFROM.eq(langid))
				.fetchInto(Dictionary.class);
	}

	@Override
	public Dictionary getDataByLangDict(int langid, String dictname) {
		return create.selectFrom(VDICTIONARIES)
				.where(VDICTIONARIES.LANGIDFROM.eq(langid))
				.and(VDICTIONARIES.DICTNAME.eq(dictname))
				.fetchOneInto(Dictionary.class);
	}

	@Override
	public List<String> getNamesByLang(int langid) {
		return create.selectFrom(VDICTIONARIES)
				.where(VDICTIONARIES.LANGIDFROM.eq(langid))
				.fetch(VDICTIONARIES.DICTNAME);
	}

}
