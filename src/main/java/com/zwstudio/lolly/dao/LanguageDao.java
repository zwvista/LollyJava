package com.zwstudio.lolly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zwstudio.lolly.domain.Language;

public class LanguageDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public List<Language> list() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Language> lst = session
				.createCriteria(Language.class)
				.list();
		session.close();
		return lst;
	}

}
