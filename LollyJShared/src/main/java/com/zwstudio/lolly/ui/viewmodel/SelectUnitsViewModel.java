package com.zwstudio.lolly.ui.viewmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jgoodies.binding.beans.Model;
import com.zwstudio.lolly.domain.Book;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.IBookService;
import com.zwstudio.lolly.services.ILanguageService;

import lombok.Getter;

@SuppressWarnings("serial")
public class SelectUnitsViewModel extends Model {
	
	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired
	protected IBookService bookDao;
	
	@Getter
	public Language selectedLang;
	@Getter
	public Book selectedBook;
	
	public void setSelectedLang(Language selectedLang) {
		firePropertyChange("selectedLang", this.selectedLang, this.selectedLang = selectedLang);
	}

	public void setSelectedBook(Book selectedBook) {
		firePropertyChange("selectedBook", this.selectedBook, this.selectedBook = selectedBook);
	}
	

}
