package com.zwstudio.lolly.mybatis.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.mybatis.mappers.LanguageMapper;
import com.zwstudio.lolly.services.ILanguageService;

@Service
@Transactional
public class LanguageService implements ILanguageService {
	@Autowired
	LanguageMapper mapper;

	public List<Language> getData() {
		return mapper.getData();
	}
	public Map<String, String> getIdNameMap() {
		return getData().stream()
			.collect(Collectors.toMap(
				(Language r) -> Integer.toString(r.getLangid()),
				Language::getLangname
			));
	}
}
