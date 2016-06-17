package com.zwstudio.lolly.ui.viewmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jgoodies.binding.beans.Model;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.IDictAllService;
import com.zwstudio.lolly.services.IDictionaryService;
import com.zwstudio.lolly.services.ILanguageService;

import lombok.Getter;

public class SelectUnitsViewModel extends Model {

	private static final long serialVersionUID = 1L;
	
	@Autowired @Qualifier("languageDao")
	protected ILanguageService langDao;
	@Autowired @Qualifier("dictionaryDao")
	protected IDictionaryService dictDao;
	@Autowired @Qualifier("dictAllDao")
	protected IDictAllService dictallDao;
	
	protected DictAll dict;
	@Getter
	public Language selectedLang;
	@Getter
	public Dictionary selectedDict;
	
	public void setSelectedLang(Language selectedLang) {
		firePropertyChange("selectedLang", this.selectedLang, this.selectedLang = selectedLang);
	}

	public void setSelectedDict(Dictionary selectedDict) {
		firePropertyChange("selectedDict", this.selectedDict, this.selectedDict = selectedDict);
	}

	protected void updateDict(DictionaryId id2) {
		dict = dictallDao.getDataByLangDict(id2.getLangid(), id2.getDictname());
	}
	

}
