package com.zwstudio.lolly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zwstudio.lolly.domain.Dictionary;

@Repository
public class DictionaryDao {

	@Autowired
	private SessionFactory sessionFactory;
    
	public List<Dictionary> getDataByLang(int langid) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Dictionary> lst = session
			.createSQLQuery("SELECT * FROM DICTIONARIES WHERE LANGID = :langid")
			.addEntity(Dictionary.class)
			.setParameter("langid", langid)
			.list();
		session.close();
		return lst;
	}

}
