package models

import slick.driver.SQLiteDriver.api._

case class Language(
  langid: Int,
  langname: String,
  chnname: String,
  voice: String,
  curbookid: Int,
  engname: String)

class LanguageTable(tag: Tag) extends Table[Language](tag, "Languages") {
  def langid = column[Int]("langid")
  def langname = column[String]("langname")
  def chnname = column[String]("chnname")
  def voice = column[String]("voice")
  def curbookid = column[Int]("curbookid")
  def engname = column[String]("engname")
  override def * = (langid, langname, chnname, voice, curbookid, engname) <> (Language.tupled, Language.unapply)
}
