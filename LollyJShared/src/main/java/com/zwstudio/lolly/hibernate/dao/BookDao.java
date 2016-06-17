package com.zwstudio.lolly.hibernate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Book;
import com.zwstudio.lolly.services.IBookService;

@Repository
@Transactional
public class BookDao extends BaseDao implements IBookService {
	@SuppressWarnings("unchecked")
	public List<Book> getDataByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM BOOKS WHERE LANGID = :langid")
			.addEntity(Book.class)
//			.createQuery("from Book where id.langid = :langid")
			.setParameter("langid", langid)
			.list();
	}
	@SuppressWarnings("unchecked")
	public List<String> getNamesByLang(int langid) {
		return getCurrentSession()
			.createSQLQuery("SELECT DICTNAME FROM DICTIONARIES WHERE LANGID = :langid")
//			.createQuery("select id.dictname from Dictionary where id.langid = :langid")
			.setParameter("langid", langid)
			.list();
	}
}
