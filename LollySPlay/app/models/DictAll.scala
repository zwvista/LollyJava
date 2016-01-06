package models

import slick.driver.SQLiteDriver.api._

case class DictAll(
  langid: Option[Int],
  dictname: Option[String],
  ord: Option[Int],
  langidto: Option[Int],
  dicttypename: Option[String],
  url: Option[String],
  chconv: Option[String],
  automation: Option[String],
  autojump: Option[Int],
  dicttable: Option[String],
  transformWin: Option[String],
  transformMac: Option[String],
  waitfield: Option[Int],
  template: Option[String])

class DictAllTable(tag: Tag) extends Table[DictAll](tag, "DictAll") {
  def langid = column[Option[Int]]("langid")
  def dictname = column[Option[String]]("dictname")
  def ord = column[Option[Int]]("ord")
  def langidto = column[Option[Int]]("langidto")
  def dicttypename = column[Option[String]]("dicttypename")
  def url = column[Option[String]]("url")
  def chconv = column[Option[String]]("chconv")
  def automation = column[Option[String]]("automation")
  def autojump = column[Option[Int]]("autojump")
  def dicttable = column[Option[String]]("dicttable")
  def transformWin = column[Option[String]]("transformWin")
  def transformMac = column[Option[String]]("transformMac")
  def waitcolumn = column[Option[Int]]("wait")
  def template = column[Option[String]]("template")
  override def * = (langid, dictname, ord, langidto, dicttypename, url, chconv, automation, autojump, dicttable, transformWin, transformMac, waitcolumn, template) <> (DictAll.tupled, DictAll.unapply)
}
