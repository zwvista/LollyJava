package com.zwstudio.lolly.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.mybatis.mappers.DictionaryMapper;
import com.zwstudio.lolly.services.IDictionaryService;

@Service
@Transactional
public class DictionaryService implements IDictionaryService {
	@Autowired
	DictionaryMapper mapper;

	public List<Dictionary> getDataByLang(int langid) {
		List<DictionaryId> ids = mapper.getIdByLang(langid);
		List<Dictionary> dicts = mapper.getDataByLang(langid);
		for(int i = 0; i < ids.size(); i++)
			dicts.get(i).setId(ids.get(i));
		return dicts;
	}
	public List<String> getNamesByLang(int langid) {
		return mapper.getNamesByLang(langid);
	}
}
