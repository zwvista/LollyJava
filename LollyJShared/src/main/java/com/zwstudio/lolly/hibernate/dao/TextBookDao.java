package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.TextBook;
import com.zwstudio.lolly.services.ITextBookService;

@Repository
@Transactional
public class TextBookDao extends BaseDao implements ITextBookService {
	@SuppressWarnings("unchecked")
	public List<TextBook> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM VTEXTBOOKS WHERE LANGID = :langid")
			.addEntity(TextBook.class)
//			.createQuery("from TextBook where langid = :langid")
			.setParameter("langid", langid)
			.list();
	}
	@SuppressWarnings("unchecked")
	public List<String> getNamesByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT DICTNAME FROM VDICTIONARIES WHERE LANGID = :langid")
//			.createQuery("select id.dictname from Dictionary where langid = :langid")
			.setParameter("langid", langid)
			.list();
	}
}
