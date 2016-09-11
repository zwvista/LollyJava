package com.zwstudio.lolly.services;

import java.util.List;

import com.zwstudio.lolly.domain.Textbook;

public interface ITextbookService {
	public List<Textbook> getDataByLang(int langid);
	public List<String> getNamesByLang(int langid);
}
