package com.zwstudio.lolly.dao;

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
    @SuppressWarnings("unchecked")
    public DictAll getDataByLangDict(int langid, String dictname) {
    	List<DictAll> lst = getCurrentSession()
			.createSQLQuery("SELECT * FROM DICTALL WHERE LANGID = :langid AND DICTNAME = :dictname")
			.addEntity(DictAll.class)
			.setParameter("langid", langid)
			.setParameter("dictname", dictname)
			.list();
    	return lst.size() == 0 ? null : lst.get(0);
	}
}
