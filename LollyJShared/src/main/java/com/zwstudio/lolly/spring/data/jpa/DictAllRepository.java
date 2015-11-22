package com.zwstudio.lolly.spring.data.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.domain.DictAllId;

public interface DictAllRepository extends CrudRepository<DictAll, DictAllId> {
	@Query("SELECT * FROM DICTALL WHERE LANGID = ?")
	public List<DictAll> getDataByLang(int langid);

	// No need to return a list if the query returns only one row
	// @Param annotation for more than one parameters
	@Query("SELECT * FROM DICTALL WHERE LANGID = :langid AND DICTNAME = :dictname")
    public DictAll getDataByLangDict(@Param("langid") int langid, @Param("dictname") String dictname);
}
