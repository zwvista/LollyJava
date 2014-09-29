package com.zwstudio.lolly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zwstudio.lolly.domain.Language;

@Repository
public class LanguageDao {

	@Autowired
	private SessionFactory sessionFactory;
    
	public List<Language> getData() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Language> lst = session
			.createSQLQuery("SELECT * FROM LANGUAGES WHERE LANGID > 0")
			.addEntity(Language.class)
			.list();
		session.close();
		return lst;
	}

}
