package models

import scala.collection.immutable.Map

case class LollyForm(
  word: String = null,
  selectedLangID: Int = 0,
  selectedDictName: String = null,
  langList: Seq[Language] = null,
  langMap: Map[String, String] = null
)
