package com.zwstudio.lolly.services;

import java.util.List;

import com.zwstudio.lolly.domain.Dictionary;

public interface IDictionaryService {
	public List<Dictionary> getDataByLang(int langid);
	public List<String> getNamesByLang(int langid);
}
