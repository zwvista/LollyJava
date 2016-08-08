package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.TextBook;
import com.zwstudio.lolly.services.ITextBookService;

@Repository
@Transactional
public class TextBookDao extends BaseDao implements ITextBookService {
	public List<TextBook> getDataByLang(int langid) {
		return getCurrentSession()
			.createNativeQuery("SELECT * FROM VTEXTBOOKS WHERE LANGID = :langid", TextBook.class)
//			.createQuery("from Book where id.langid = :langid", TextBook.class)
			.setParameter("langid", langid)
			.getResultList();
	}
	public List<String> getNamesByLang(int langid) {
		return getCurrentSession()
			.createNativeQuery("SELECT DICTNAME FROM VDICTIONARIES WHERE LANGID = :langid", String.class)
//			.createQuery("select id.dictname from Dictionary where id.langid = :langid", TextBook.class)
			.setParameter("langid", langid)
			.getResultList();
	}
}
