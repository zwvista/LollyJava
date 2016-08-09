package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.services.IDictionaryService;

@Repository
@Transactional
public class DictionaryDao extends BaseDao implements IDictionaryService {
	@SuppressWarnings("unchecked")
	public List<Dictionary> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = :langid")
			.addEntity(Dictionary.class)
//			.createQuery("from Dictionary where langidfrom = :langid")
			.setParameter("langid", langid)
			.list();
	}
    public Dictionary getDataByLangDict(int langid, String dictname) {
    	return (Dictionary) getCurrentSession()
			.createSQLQuery("SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = :langid AND DICTNAME = :dictname")
 			.addEntity(Dictionary.class)
//			.createQuery("from Dictionary where langidfrom = :langid and dictname = :dictname")
			.setParameter("langid", langid)
			.setParameter("dictname", dictname)
			.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<String> getNamesByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT DICTNAME FROM VDICTIONARIES WHERE LANGIDFROM = :langid")
//			.createQuery("select id.dictname from Dictionary where langidfrom = :langid")
			.setParameter("langid", langid)
			.list();
	}
}
