package com.zwstudio.lolly.services;

import java.util.List;

import com.zwstudio.lolly.domain.DictAll;

public interface IDictAllService {
	public List<DictAll> getDataByLang(int langid);
	public DictAll getDataByLangDict(int langid, String dictname);
}
