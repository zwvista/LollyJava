package controllers

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import models.{ DictAll, LollyForm }
import play.api.libs.json.Json
import play.api.mvc.{ Action, Controller }
import services.{ DictAllService, DictionaryService, LanguageService }
import javax.inject.Inject
import play.api.data.Form

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  private def newForm = new LollyForm {
    word = "一人"
    langMap = Await.result(LanguageService.getIdNameMap, Duration.Inf).toMap
  }
  def lolly1 = Action {
    Ok(views.html.lolly1.render(newForm))
  }
  //  def lolly2 = Action {
  //    Ok(views.html.lolly2.render(Form.form(Class[LollyForm]).fill(newForm)))
  //  }
  //  def lolly3 = Action {
  //    Ok(views.html.lolly3.render(Form.form(Class[LollyForm]).fill(newForm)))
  //  }

  def dictList(selectedLangID: String) = Action {
    val v = Await.result(DictionaryService.getNamesByLang(selectedLangID.toInt), Duration.Inf).get
    Ok(Json.toJson(v))
  }

  def dictall(selectedLangID: String, selectedDictName: String) = Action {
    val v = Await.result(DictAllService.getDataByLangDict(selectedLangID.toInt, selectedDictName), Duration.Inf).get
    Ok(Json.toJson(v)(Json.format[DictAll]))
  }

}
