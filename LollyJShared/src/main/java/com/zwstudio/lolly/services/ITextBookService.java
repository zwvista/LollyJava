package com.zwstudio.lolly.services;

import java.util.List;

import com.zwstudio.lolly.domain.TextBook;

public interface ITextBookService {
	public List<TextBook> getDataByLang(int langid);
	public List<String> getNamesByLang(int langid);
}
