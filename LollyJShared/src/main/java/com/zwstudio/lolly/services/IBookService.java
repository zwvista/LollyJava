package com.zwstudio.lolly.services;

import java.util.List;

import com.zwstudio.lolly.domain.Book;

public interface IBookService {
	public List<Book> getDataByLang(int langid);
	public List<String> getNamesByLang(int langid);
}
