package com.zwstudio.lolly.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.Dictionary;

@Repository
public class DictAllDao {

	@Autowired
	private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	public List<DictAll> getData() {
		Session session = sessionFactory.openSession();
		List<DictAll> lst = session
			.createSQLQuery("SELECT * FROM DICTALL")
			.addEntity(DictAll.class)
			.list();
		session.close();
		return lst;
	}
}
