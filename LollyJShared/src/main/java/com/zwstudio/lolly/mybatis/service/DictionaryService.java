package com.zwstudio.lolly.mybatis.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.mybatis.mappers.DictionaryMapper;

@Service
@Transactional
public class DictionaryService {
	@Autowired
	DictionaryMapper mapper;

	public List<DictionaryId> getIdByLang(int langid) {
		return mapper.getIdByLang(langid);
	}
	public List<Dictionary> getDataByLang(int langid) {
		return mapper.getDataByLang(langid);
	}
	public List<String> getNamesByLang(int langid) {
		return mapper.getNamesByLang(langid);
	}
	public Map<String, String> getNameIdMap(int langid) {
		return getDataByLang(langid).stream()
			.collect(Collectors.toMap(
				(Dictionary r) -> r.getId().getDictname(),
				(Dictionary r) -> Integer.toString(r.getId().getLangid())
			));
	}
}
