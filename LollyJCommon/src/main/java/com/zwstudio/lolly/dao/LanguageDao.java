package com.zwstudio.lolly.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Language;

@Repository
@Transactional
public class LanguageDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<Language> getData() {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM LANGUAGES WHERE LANGID > 0")
			.addEntity(Language.class)
			.list();
	}
	public Map<String, String> getIdNameMap() {
		return getData().stream()
			.collect(Collectors.toMap(
				(Language r) -> Integer.toString(r.getLangid()),
				Language::getLangname
			));
	}
	public Map<String, String> getNameIdMap() {
		return getData().stream()
			.collect(Collectors.toMap(
				Language::getLangname,
				(Language r) -> Integer.toString(r.getLangid())
			));
	}
}
