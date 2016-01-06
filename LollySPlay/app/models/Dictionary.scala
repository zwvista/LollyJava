package models

import slick.driver.SQLiteDriver.api._

case class Dictionary(
  langid: Int,
  dictname: String,
  ord: Int,
  dicttypeid: Int,
  langidto: Int,
  url: String,
  chconv: String,
  automation: String,
  autojump: Int,
  dicttable: String,
  template: String)

class DictionaryTable(tag: Tag) extends Table[Dictionary](tag, "Dictionaries") {
  def langid = column[Int]("langid")
  def dictname = column[String]("dictname")
  def ord = column[Int]("ord")
  def dicttypeid = column[Int]("dicttypeid")
  def langidto = column[Int]("langidto")
  def url = column[String]("url")
  def chconv = column[String]("chconv")
  def automation = column[String]("automation")
  def autojump = column[Int]("autojump")
  def dicttable = column[String]("dicttable")
  def template = column[String]("template")
  def * = (langid, dictname, ord, dicttypeid, langidto, url, chconv, automation, autojump, dicttable, template) <> (Dictionary.tupled, Dictionary.unapply)
}
object DictionaryTable extends TableQuery(new DictionaryTable(_))
