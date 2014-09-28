package com.zwstudio.lolly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.Language;

public class DictionaryDao {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
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
