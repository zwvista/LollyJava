package models

@Entity
@Table(name = "DICTALL")
case class DictAll {
  
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
	wait: Int,
	template: String

}