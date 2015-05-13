package com.zwstudio.lolly.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zwstudio.lolly.domain.DictAll;

public interface DictAllMapper {
	@Select("SELECT * FROM DICTALL WHERE LANGID = #{langid}")
	public List<DictAll> getDataByLang(int langid);

	// No need to return a list if the query returns only one row
	// @Param annotation for more than one parameters
	@Select("SELECT * FROM DICTALL WHERE LANGID = #{langid} AND DICTNAME = #{dictname}")
    public DictAll getDataByLangDict(@Param("langid") int langid, @Param("dictname") String dictname);
}
