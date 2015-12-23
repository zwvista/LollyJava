package com.zwstudio.lolly.spring.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zwstudio.lolly.domain.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer>, LanguageRepositoryCustom {
//	@Query(value="SELECT * FROM LANGUAGES WHERE LANGID > 0",nativeQuery=true)
	@Query("from Language where langid > 0")
	public List<Language> getData();
}
