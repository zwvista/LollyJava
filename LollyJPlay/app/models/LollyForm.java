package models;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import com.zwstudio.lolly.domain.Language;

import play.data.validation.Constraints.Required;

@Entity
public class LollyForm {
	@Required
	public String word;
	public int selectedLangID;
	public String selectedDictName;
	public List<Language> langList;
	public Map<String, String> langMap;
}
