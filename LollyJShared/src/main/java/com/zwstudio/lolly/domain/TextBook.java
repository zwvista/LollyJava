package com.zwstudio.lolly.domain;
// Generated 2016/08/09 13:08:27 by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TextBook generated by hbm2java
 */
@Entity
@Table(name = "VTEXTBOOKS")
public class TextBook implements java.io.Serializable {

	private int id;
	private Integer langid;
	private String textbookname;
	private Integer units;
	private String parts;
	private String usunitfrom;
	private String uspartfrom;
	private String usunitto;
	private String uspartto;

	public TextBook() {
	}

	public TextBook(int id) {
		this.id = id;
	}

	public TextBook(int id, Integer langid, String textbookname, Integer units, String parts, String usunitfrom,
			String uspartfrom, String usunitto, String uspartto) {
		this.id = id;
		this.langid = langid;
		this.textbookname = textbookname;
		this.units = units;
		this.parts = parts;
		this.usunitfrom = usunitfrom;
		this.uspartfrom = uspartfrom;
		this.usunitto = usunitto;
		this.uspartto = uspartto;
	}

	@Id

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "LANGID")
	public Integer getLangid() {
		return this.langid;
	}

	public void setLangid(Integer langid) {
		this.langid = langid;
	}

	@Column(name = "TEXTBOOKNAME", length = 2000000000)
	public String getTextbookname() {
		return this.textbookname;
	}

	public void setTextbookname(String textbookname) {
		this.textbookname = textbookname;
	}

	@Column(name = "UNITS")
	public Integer getUnits() {
		return this.units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	@Column(name = "PARTS", length = 2000000000)
	public String getParts() {
		return this.parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	@Column(name = "USUNITFROM", length = 2000000000)
	public String getUsunitfrom() {
		return this.usunitfrom;
	}

	public void setUsunitfrom(String usunitfrom) {
		this.usunitfrom = usunitfrom;
	}

	@Column(name = "USPARTFROM", length = 2000000000)
	public String getUspartfrom() {
		return this.uspartfrom;
	}

	public void setUspartfrom(String uspartfrom) {
		this.uspartfrom = uspartfrom;
	}

	@Column(name = "USUNITTO", length = 2000000000)
	public String getUsunitto() {
		return this.usunitto;
	}

	public void setUsunitto(String usunitto) {
		this.usunitto = usunitto;
	}

	@Column(name = "USPARTTO", length = 2000000000)
	public String getUspartto() {
		return this.uspartto;
	}

	public void setUspartto(String uspartto) {
		this.uspartto = uspartto;
	}

}
