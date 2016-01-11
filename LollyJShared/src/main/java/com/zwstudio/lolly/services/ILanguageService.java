package com.zwstudio.lolly.services;

import java.util.List;
import java.util.Map;

import com.zwstudio.lolly.domain.Language;

public interface ILanguageService {
	public List<Language> getData();
	public Map<String, String> getIdNameMap();
}
