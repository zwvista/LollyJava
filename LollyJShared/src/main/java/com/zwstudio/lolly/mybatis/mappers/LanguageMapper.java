package com.zwstudio.lolly.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zwstudio.lolly.domain.Language;

public interface LanguageMapper {
	@Select("SELECT * FROM VLANGUAGES WHERE ID > 0")
	public List<Language> getData();
}
