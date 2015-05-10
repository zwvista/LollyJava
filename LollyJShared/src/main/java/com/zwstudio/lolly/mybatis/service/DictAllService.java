package com.zwstudio.lolly.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.mybatis.mappers.DictAllMapper;

@Service
@Transactional
public class DictAllService {
	@Autowired
	DictAllMapper mapper;
	
	public List<DictAll> getDataByLang(int langid) {
		return mapper.getDataByLang(langid);
	}
    public DictAll getDataByLangDict(int langid, String dictname) {
    	List<DictAll> lst = mapper.getDataByLangDict(langid, dictname);
    	return lst.size() == 0 ? null : lst.get(0);
	}
}
