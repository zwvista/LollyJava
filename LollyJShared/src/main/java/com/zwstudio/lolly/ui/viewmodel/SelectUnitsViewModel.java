package com.zwstudio.lolly.ui.viewmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jgoodies.binding.beans.Model;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.domain.TextBook;
import com.zwstudio.lolly.services.ILanguageService;
import com.zwstudio.lolly.services.ITextBookService;

import lombok.Getter;

@SuppressWarnings("serial")
public class SelectUnitsViewModel extends Model {
	
	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired
	protected ITextBookService textbookDao;
	
	@Getter
	public Language selectedLang;
	@Getter
	public TextBook selectedTextBook;
	
	public void setSelectedLang(Language selectedLang) {
		firePropertyChange("selectedLang", this.selectedLang, this.selectedLang = selectedLang);
	}

	public void setSelectedBook(TextBook selectedBook) {
		firePropertyChange("selectedBook", this.selectedTextBook, this.selectedTextBook = selectedBook);
	}
	

}
