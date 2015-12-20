package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.lolly;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public Result lolly() {
    	return ok(lolly.render("Your new application is ready."));
    }

}
