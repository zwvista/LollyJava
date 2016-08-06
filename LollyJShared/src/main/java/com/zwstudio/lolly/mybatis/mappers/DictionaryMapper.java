package com.zwstudio.lolly.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;

public interface DictionaryMapper {
	@Select("SELECT LANGIDFROM, DICTNAME FROM VDICTIONARIES WHERE LANGIDFROM = #{langid}")
	public List<DictionaryId> getIdByLang(int langid);
	@Select("SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = #{langid}")
	public List<Dictionary> getDataByLang(int langid);
	// No need to return a list if the query returns only one row
	// @Param annotation for more than one parameters
	@Select("SELECT * FROM VDICTIONARIES WHERE LANGIDFROM = #{langid} AND DICTNAME = #{dictname}")
    public Dictionary getDataByLangDict(@Param("langid") int langid, @Param("dictname") String dictname);
	@Select("SELECT DICTNAME FROM VDICTIONARIES WHERE LANGIDFROM = #{langid}")
	public List<String> getNamesByLang(int langid);
}
