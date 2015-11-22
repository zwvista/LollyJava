package com.zwvista.lolly.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.spring.data.jpa.DictAllRepository;
import com.zwstudio.lolly.util.LollyConfigSpringDataJpa;

public class TestSpringDataJpa {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LollyConfigSpringDataJpa.class);

	@Test
	public void test() {
		DictAllRepository repository = context.getBean(DictAllRepository.class);
		DictAll da = repository.getDataByLangDict(1, "Cambridge");
		assertEquals("Url", "http://dictionary.cambridge.org/", da.getUrl());
	}

}
