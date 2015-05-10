package com.zwstudio.lolly.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zwstudio.lolly.domain.DictAll;

public interface DictAllMapper {
	@Select("SELECT * FROM DICTALL WHERE LANGID = #{langid}")
	public List<DictAll> getDataByLang(int langid);
	@Select("SELECT * FROM DICTALL WHERE LANGID = #{langid} AND DICTNAME = #{dictname}")
    public List<DictAll> getDataByLangDict(@Param("langid") int langid, @Param("dictname") String dictname);
}
