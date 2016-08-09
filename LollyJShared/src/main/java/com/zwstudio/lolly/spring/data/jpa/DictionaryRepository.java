package com.zwstudio.lolly.spring.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.services.IDictionaryService;

public interface DictionaryRepository extends CrudRepository<Dictionary, Integer>, IDictionaryService {
	@Query(value="SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = ?",nativeQuery=true)
//	@Query("from Dictionary where langidfrom = ?")
	public List<Dictionary> getDataByLang(int langid);
	// No need to return a list if the query returns only one row
	// @Param annotation for more than one parameters
	@Query(value="SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = :langid AND DICTNAME = :dictname",nativeQuery=true)
//	@Query("from Dictionary where langidfrom = :langid and dictname = :dictname")
    public Dictionary getDataByLangDict(@Param("langid") int langid, @Param("dictname") String dictname);
	@Query(value="SELECT DICTNAME FROM VDICTIONARIES WHERE LANGIDFROM = ?",nativeQuery=true)
//	@Query("select id.dictname from Dictionary where langidfrom = ?")
	public List<String> getNamesByLang(int langid);
}
