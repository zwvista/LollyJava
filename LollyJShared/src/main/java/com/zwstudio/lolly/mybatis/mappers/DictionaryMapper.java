package com.zwstudio.lolly.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zwstudio.lolly.domain.Dictionary;
import com.zwstudio.lolly.domain.DictionaryId;

public interface DictionaryMapper {
	@Select("SELECT LANGID, DICTNAME FROM DICTIONARIES WHERE LANGID = #{langid}")
	public List<DictionaryId> getIdByLang(int langid);
	@Select("SELECT * FROM DICTIONARIES WHERE LANGID = #{langid}")
	public List<Dictionary> getDataByLang(int langid);
	@Select("SELECT DICTNAME FROM DICTIONARIES WHERE LANGID = #{langid}")
	public List<String> getNamesByLang(int langid);
}
