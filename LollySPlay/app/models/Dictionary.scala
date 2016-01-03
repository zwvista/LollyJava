package models

@Entity
@Table(name = "DICTIONARIES")
case class Dictionary {
  
	langid: int,
	dictname: String,
	ord: int,
	dicttypeid: int,
	langidto: int,
	url: String,
	chconv: String,
	automation: String,
	autojump: int,
	dicttable: String,
	template: String

}