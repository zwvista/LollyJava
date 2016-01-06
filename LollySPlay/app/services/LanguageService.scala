package services

import models.LanguageTable
import slick.driver.SQLiteDriver.api._
import play.api.db.DB
import play.api.Play.current

object LanguageService {
  def db: Database = Database.forDataSource(DB.getDataSource())
  private lazy val items = TableQuery[LanguageTable]
  def getData = db.run(items.filter { _.langid > 0 }.result)
  def getIdNameMap =
    db.run(items.filter { _.langid > 0 }.map { x => x.langid -> x.langname }.result)
}
