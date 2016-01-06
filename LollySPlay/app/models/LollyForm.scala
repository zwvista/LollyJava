package models

import scala.collection.immutable.Map

class LollyForm {
  var word: String = _
  var selectedLangID: Int = _
  var selectedDictName: String = _
  var langList: Seq[Language] = _
  var langMap: Map[String, String] = _
}
