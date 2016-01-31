package controllers;

import com.zwstudio.lolly.spring.data.jpa.DictAllRepository;
import com.zwstudio.lolly.spring.data.jpa.DictionaryRepository;
import com.zwstudio.lolly.spring.data.jpa.LanguageRepository;
import models.LollyForm;
import org.springframework.beans.factory.annotation.Autowired;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.lolly1;
import views.html.lolly2;
import views.html.lolly3;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@org.springframework.stereotype.Controller
public class Application extends Controller {
	
	@Autowired
	protected LanguageRepository langRepository;
	@Autowired
	protected DictionaryRepository dictRepository;
	@Autowired
	protected DictAllRepository dictallRepository;
	
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    private LollyForm newForm() {
    	return new LollyForm() {{
			word = "一人";
    		langMap = langRepository.getIdNameMap();
    	}};
    }
    public Result lolly1() {
    	return ok(lolly1.render(newForm()));
    }
    public Result lolly2() {
    	return ok(lolly2.render(Form.form(LollyForm.class).fill(newForm())));
    }
    public Result lolly3() {
    	return ok(lolly3.render(Form.form(LollyForm.class).fill(newForm())));
    }
    public Result dictList(String selectedLangID) {
    	System.out.println(selectedLangID);
    	return ok(Json.toJson(dictRepository.getNamesByLang(
    			Integer.parseInt(selectedLangID))));
    }
    public Result dictall(String selectedLangID, String selectedDictName) {
    	Form<LollyForm> f = Form.form(LollyForm.class).bindFromRequest();
    	return f.hasErrors() ?
    		badRequest(f.errorsAsJson()) :
        	ok(Json.toJson(dictallRepository.getDataByLangDict(
        			Integer.parseInt(selectedLangID), selectedDictName)));
    }
	public Result search() {
		Form<LollyForm> f = Form.form(LollyForm.class).bindFromRequest();
		if(f.hasErrors())
			return redirect("error");
		else {
            LollyForm o = f.get();
            String url = null;
            try {
                url = dictallRepository.getDataByLangDict(o.selectedLangID, o.selectedDictName)
                        .getUrl().replace("{0}", URLEncoder.encode(o.word, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return redirect(url);
		}
	}
}
