package controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.zwstudio.lolly.domain.Language;
import com.zwstudio.lolly.spring.data.jpa.DictAllRepository;
import com.zwstudio.lolly.spring.data.jpa.DictionaryRepository;
import com.zwstudio.lolly.spring.data.jpa.LanguageRepository;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.lolly;

@org.springframework.stereotype.Controller
public class Application extends Controller {
	
	@Autowired
	protected LanguageRepository langRepository;
	@Autowired
	protected DictionaryRepository dictRepository;
	@Autowired
	protected DictAllRepository dictallRepository;
	
    public Result index() {
    	for(Language m : langRepository.getData())
    		System.out.println(m.getLangname());
        return ok(index.render("Your new application is ready."));
    }
    public Result lolly() {
    	return ok(lolly.render());
    }

}
