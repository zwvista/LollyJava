package com.zwstudio.lolly.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.DictAll;
import com.zwstudio.lolly.mybatis.mappers.DictAllMapper;
import com.zwstudio.lolly.services.IDictAllService;

@Service
@Transactional
public class DictAllService implements IDictAllService {
	@Autowired
	DictAllMapper mapper;
	
	public List<DictAll> getDataByLang(int langid) {
		return mapper.getDataByLang(langid);
	}
    public DictAll getDataByLangDict(int langid, String dictname) {
    	return mapper.getDataByLangDict(langid, dictname);
	}
}
