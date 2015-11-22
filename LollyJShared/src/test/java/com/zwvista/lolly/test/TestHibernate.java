package com.zwvista.lolly.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.hibernate.dao.DictAllDao;
import com.zwstudio.lolly.util.LollyConfigHibernate;

public class TestHibernate {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LollyConfigHibernate.class);

	@Test
	public void test() {
		DictAllDao dao = context.getBean(DictAllDao.class);
		DictAll da = dao.getDataByLangDict(1, "Cambridge");
		assertEquals("Url", "http://dictionary.cambridge.org/", da.getUrl());
	}

}
