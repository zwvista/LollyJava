package models

@Entity
@Table(name = "LANGUAGES")
case class Language {
  
	langid: int,
	langname: String,
	chnname: String,
	voice: String,
	curbookid: Int,
	engname: String

}