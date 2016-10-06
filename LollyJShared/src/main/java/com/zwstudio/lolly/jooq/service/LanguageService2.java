package com.zwstudio.lolly.jooq.service;

import static com.zwstudio.lolly.jooq.Tables.VLANGUAGES;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.services.ILanguageService;;

@Service
@Transactional
public class LanguageService2 implements ILanguageService {
	
    @Autowired
    DSLContext create;

	@Override
	public List<Language> getData() {
		return create.selectFrom(VLANGUAGES).fetchInto(Language.class);
	}

	@Override
	public Map<String, String> getIdNameMap() {
		return create.selectFrom(VLANGUAGES).fetchInto(Language.class).stream()
				.collect(Collectors.toMap(
					(Language r) -> Integer.toString(r.getId()),
					Language::getLangname
				));
	}

}
