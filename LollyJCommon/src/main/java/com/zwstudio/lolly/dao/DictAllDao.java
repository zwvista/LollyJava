package com.zwstudio.lolly.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.DictAll;

@Repository
public class DictAllDao extends BaseDao {
	@Transactional
    @SuppressWarnings("unchecked")
	public List<DictAll> getData() {
		return getCurrentSession()
			.createSQLQuery("SELECT * FROM DICTALL")
			.addEntity(DictAll.class)
			.list();
	}
}
