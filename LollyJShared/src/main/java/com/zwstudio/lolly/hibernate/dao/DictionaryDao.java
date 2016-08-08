package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.services.IDictionaryService;

@Repository
@Transactional
public class DictionaryDao extends BaseDao implements IDictionaryService {
	public List<Dictionary> getDataByLang(int langid) {
		return getCurrentSession()
			.createNativeQuery("SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = :langid", Dictionary.class)
//			.createQuery("from Dictionary where id.langidfrom = :langid", Dictionary.class)
			.setParameter("langid", langid)
			.getResultList();
	}
    public Dictionary getDataByLangDict(int langid, String dictname) {
    	return (Dictionary) getCurrentSession()
			.createNativeQuery("SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = :langid AND DICTNAME = :dictname", Dictionary.class)
//			.createQuery("from Dictionary where id.langidfrom = :langid and id.dictname = :dictname", Dictionary.class)
			.setParameter("langid", langid)
			.setParameter("dictname", dictname)
			.getSingleResult();
	}
	public List<String> getNamesByLang(int langid) {
		return getCurrentSession()
			.createNativeQuery("SELECT DICTNAME FROM VDICTIONARIES WHERE LANGIDFROM = :langid", String.class)
//			.createQuery("select id.dictname from Dictionary where id.langidfrom = :langid", Dictionary.class)
			.setParameter("langid", langid)
			.getResultList();
	}
}
