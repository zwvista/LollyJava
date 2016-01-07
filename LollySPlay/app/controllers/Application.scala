package controllers

import scala.concurrent.Await
import scala.concurrent.duration.Duration

import models.{ DictAll, Language, LollyForm }
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.libs.json.Json
import play.api.mvc.{ Action, Controller }
import services.{ DictAllService, DictionaryService, LanguageService }

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  private def lollyForm = {
    val v = Await.result(LanguageService.getIdNameMap, Duration.Inf)
    LollyForm(
      word = "一人",
      langMap = v.map { x ⇒ x._1.toString → x._2 }.toMap)
  }
  private def lollyFormMapping =
    Form[LollyForm](
      mapping("word" → text)(word ⇒ LollyForm(word = word))(o ⇒ Some(o.word))).fill(lollyForm)

  def lolly1 = Action {
    Ok(views.html.lolly1.render(lollyForm))
  }
  def lolly2 = Action {
    Ok(views.html.lolly2.render(lollyFormMapping))
  }
  def lolly3 = Action {
    Ok(views.html.lolly3.render(lollyFormMapping))
  }

  def dictList(selectedLangID: String) = Action {
    val v = Await.result(DictionaryService.getNamesByLang(selectedLangID.toInt), Duration.Inf)
    Ok(Json.toJson(v))
  }

  def dictall(selectedLangID: String, selectedDictName: String) = Action {
    val v = Await.result(DictAllService.getDataByLangDict(selectedLangID.toInt, selectedDictName), Duration.Inf)
    Ok(Json.toJson(v)(Json.format[DictAll]))
  }

}
