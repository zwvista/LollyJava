package com.zwvista.lolly.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.spring.data.jpa.DictionaryRepository;
import com.zwstudio.lolly.util.LollyConfigSpringDataJpa;

public class TestSpringDataJpa {

	private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LollyConfigSpringDataJpa.class);

	@Test
	public void test() {
		DictionaryRepository repository = context.getBean(DictionaryRepository.class);
		Dictionary da = repository.getDataByLangDict(1, "Cambridge");
		assertEquals("Url", "http://dictionary.cambridge.org/", da.getUrl());
	}

}
