package com.zwstudio.lolly.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

@Repository
@Transactional
public class DictionaryDao extends BaseDao {
	@SuppressWarnings("unchecked")
	public List<Dictionary> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM DICTIONARIES WHERE LANGID = :langid")
			.addEntity(Dictionary.class)
			.setParameter("langid", langid)
			.list();
	}
	@SuppressWarnings("unchecked")
	public List<String> getNamesByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT DICTNAME FROM DICTIONARIES WHERE LANGID = :langid")
			.setParameter("langid", langid)
			.list();
	}
	public Map<String, String> getNameIdMap(int langid) {
		return getDataByLang(langid).stream()
			.collect(Collectors.toMap(
				(Dictionary r) -> r.getId().getDictname(),
				(Dictionary r) -> Integer.toString(r.getId().getLangid())
			));
	}
}
