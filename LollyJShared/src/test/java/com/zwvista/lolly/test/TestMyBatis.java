package com.zwvista.lolly.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.mybatis.service.DictionaryService;
import com.zwstudio.lolly.util.LollyConfigMyBatis;

public class TestMyBatis {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LollyConfigMyBatis.class);

	@Test
	public void test() {
		DictionaryService service = context.getBean(DictionaryService.class);
		Dictionary da = service.getDataByLangDict(1, "Cambridge");
		assertEquals("Url", "http://dictionary.cambridge.org/", da.getUrl());
	}

}
