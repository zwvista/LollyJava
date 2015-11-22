package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.DictAll;

@Repository
@Transactional
public class DictAllDao extends BaseDao {
    @SuppressWarnings("unchecked")
	public List<DictAll> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM DICTALL WHERE LANGID = :langid")
			.addEntity(DictAll.class)
			.setParameter("langid", langid)
			.list();
	}
    public DictAll getDataByLangDict(int langid, String dictname) {
    	return (DictAll) getCurrentSession()
			.createSQLQuery("SELECT * FROM DICTALL WHERE LANGID = :langid AND DICTNAME = :dictname")
			.addEntity(DictAll.class)
			.setParameter("langid", langid)
			.setParameter("dictname", dictname)
			.uniqueResult();
	}
}