package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Textbook;
import com.zwstudio.lolly.services.ITextbookService;

@Repository
@Transactional
public class TextbookDao extends BaseDao implements ITextbookService {
	@SuppressWarnings("unchecked")
	public List<Textbook> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM VTEXTBOOKS WHERE LANGID = :langid")
			.addEntity(Textbook.class)
//			.createQuery("from Textbook where langid = :langid")
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
