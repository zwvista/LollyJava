package com.zwstudio.lolly.hibernate.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.ILanguageService;

@Repository
@Transactional
public class LanguageDao extends BaseDao implements ILanguageService {
	public List<Language> getData() {
		return getCurrentSession()
			.createNativeQuery("SELECT * FROM VLANGUAGES WHERE LANGID > 0", Language.class)
//			.createQuery("from Language where langid > 0")
			.getResultList();
	}
	public Map<String, String> getIdNameMap() {
		return getData().stream()
			.collect(Collectors.toMap(
				(Language r) -> Integer.toString(r.getLangid()),
				Language::getLangname
			));
	}
}
