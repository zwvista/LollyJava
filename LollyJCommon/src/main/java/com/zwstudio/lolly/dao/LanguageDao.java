package com.zwstudio.lolly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Language;

@Repository
public class LanguageDao extends BaseDao {
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Language> getData() {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM LANGUAGES WHERE LANGID > 0")
			.addEntity(Language.class)
			.list();
	}
}
