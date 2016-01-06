package services

import models.DictAllTable
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import com.google.inject.Inject
import slick.driver.JdbcProfile
import scala.concurrent.Future

class DictAllService @Inject() (override protected val dbConfigProvider: DatabaseConfigProvider)
    extends HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._
  private lazy val items = TableQuery[DictAllTable]
  def getDataByLang(langid: Int) = db.run(items.filter { _.langid === langid }.result.headOption);
  def getDataByLangDict(langid: Int, dictname: String) =
    db.run(items.filter { x ⇒ (x.langid === langid) && (x.dictname === dictname) }.result.headOption);
}
