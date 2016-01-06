package services

import models.DictionaryTable
import slick.driver.SQLiteDriver.api._
import play.api.db.DB
import play.api.Play.current

object DictionaryService {
  def db: Database = Database.forDataSource(DB.getDataSource())
  private lazy val items = TableQuery[DictionaryTable]
  def getDataByLang(langid: Int) = db.run(items.filter { _.langid === langid }.result)
  def getNamesByLang(langid: Int) =
    db.run(items.filter { _.langid === langid }.map { x ⇒ x.dictname }.result)
}
