package com.zwstudio.lolly.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.object.SqlQuery;

import com.zwstudio.lolly.domain.Language;

public class LanguageDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
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
