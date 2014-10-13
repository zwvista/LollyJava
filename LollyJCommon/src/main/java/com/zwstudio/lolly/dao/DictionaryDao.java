package com.zwstudio.lolly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;

@Repository
public class DictionaryDao extends BaseDao {
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Dictionary> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM DICTIONARIES WHERE LANGID = :langid")
			.addEntity(Dictionary.class)
			.setParameter("langid", langid)
			.list();
	}
}
