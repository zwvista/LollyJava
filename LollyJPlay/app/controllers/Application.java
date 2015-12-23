package controllers;

import com.google.inject.Inject;
import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.spring.data.jpa.DictAllRepository;
import com.zwstudio.lolly.spring.data.jpa.DictionaryRepository;
import com.zwstudio.lolly.spring.data.jpa.LanguageRepository;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.lolly;

public class Application extends Controller {
	
	@Inject
	protected LanguageRepository langRepository;
	@Inject
	protected DictionaryRepository dictRepository;
	@Inject
	protected DictAllRepository dictallRepository;
	
    public Result index() {
    	for(Language m : langRepository.getData())
    		System.out.println(m.getLangname());
        return ok(index.render("Your new application is ready."));
    }
    public Result lolly() {
    	return ok(lolly.render("Your new application is ready."));
    }

}
