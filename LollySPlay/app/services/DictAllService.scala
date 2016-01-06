package services

import models.DictAllTable
import slick.driver.SQLiteDriver.api._
import play.api.db.DB
import play.api.Play.current

object DictAllService {
  def db: Database = Database.forDataSource(DB.getDataSource())
  private lazy val items = TableQuery[DictAllTable]
  def getDataByLang(langid: Int) = db.run(items.filter { _.langid === langid }.result)
  def getDataByLangDict(langid: Int, dictname: String) =
    db.run(items.filter { x ⇒ (x.langid === langid) && (x.dictname === dictname) }.result.head)
}
