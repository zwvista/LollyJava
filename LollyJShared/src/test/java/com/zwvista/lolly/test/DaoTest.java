package com.zwvista.lolly.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.dao.DictAllDao;
import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.util.LollyConfig;

public class DaoTest {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LollyConfig.class);

	@Test
	public void test() {
		DictAllDao dictalldao = context.getBean(DictAllDao.class);
		DictAll da = dictalldao.getDataByLangDict(1, "Cambridge");
		assertEquals("Url", "http://dictionary.cambridge.org/", da.getUrl());
	}

}
