package com.zwstudio.lolly.spring.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;

public interface DictionaryRepository extends CrudRepository<Dictionary, DictionaryId> {
//	@Query(value="SELECT * FROM DICTIONARIES WHERE LANGID = ?",nativeQuery=true)
	@Query("from Dictionary where id.langid = ?")
	public List<Dictionary> getDataByLang(int langid);
//	@Query(value="SELECT DICTNAME FROM DICTIONARIES WHERE LANGID = ?",nativeQuery=true)
	@Query("select id.dictname from Dictionary where id.langid = ?")
	public List<String> getNamesByLang(int langid);
}
