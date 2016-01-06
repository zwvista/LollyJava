package models

import slick.driver.SQLiteDriver.api._

case class DictAll(
  langid: Int,
  dictname: String,
  ord: Int,
  langidto: Int,
  dicttypename: String,
  url: String,
  chconv: String,
  automation: String,
  autojump: Int,
  dicttable: String,
  transformWin: String,
  transformMac: String,
  waitfield: Int,
  template: String)

class DictAllTable(tag: Tag) extends Table[DictAll](tag, "DictAll") {
  def langid = column[Int]("langid")
  def dictname = column[String]("dictname")
  def ord = column[Int]("ord")
  def langidto = column[Int]("langidto")
  def dicttypename = column[String]("dicttypename")
  def url = column[String]("url")
  def chconv = column[String]("chconv")
  def automation = column[String]("automation")
  def autojump = column[Int]("autojump")
  def dicttable = column[String]("dicttable")
  def transformWin = column[String]("transformWin")
  def transformMac = column[String]("transformMac")
  def waitcolumn = column[Int]("wait")
  def template = column[String]("template")
  override def * = (langid, dictname, ord, langidto, dicttypename, url, chconv, automation, autojump, dicttable, transformWin, transformMac, waitcolumn, template) <> (DictAll.tupled, DictAll.unapply)
}
