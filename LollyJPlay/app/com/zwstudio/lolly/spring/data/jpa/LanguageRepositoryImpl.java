package com.zwstudio.lolly.spring.data.jpa;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.zwstudio.lolly.domain.Language;

public class LanguageRepositoryImpl implements LanguageRepositoryCustom {
	@Autowired
	LanguageRepository repository;
	
	public Map<String, String> getIdNameMap() {
		return repository.getData().stream()
			.collect(Collectors.toMap(
				(Language r) -> Integer.toString(r.getLangid()),
				Language::getLangname
			));
	}

}
