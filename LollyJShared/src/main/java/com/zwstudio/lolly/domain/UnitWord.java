package com.zwstudio.lolly.domain;
// Generated 2016/08/09 13:08:27 by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UnitWord generated by hbm2java
 */
@Entity
@Table(name = "UNITWORDS")
public class UnitWord implements java.io.Serializable {

	private int id;
	private int textbookid;
	private int unit;
	private int part;
	private int seqnum;
	private String word;
	private String note;

	public UnitWord() {
	}

	public UnitWord(int id, int textbookid, int unit, int part, int seqnum, String word) {
		this.id = id;
		this.textbookid = textbookid;
		this.unit = unit;
		this.part = part;
		this.seqnum = seqnum;
		this.word = word;
	}

	public UnitWord(int id, int textbookid, int unit, int part, int seqnum, String word, String note) {
		this.id = id;
		this.textbookid = textbookid;
		this.unit = unit;
		this.part = part;
		this.seqnum = seqnum;
		this.word = word;
		this.note = note;
	}

	@Id

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TEXTBOOKID", nullable = false)
	public int getTextbookid() {
		return this.textbookid;
	}

	public void setTextbookid(int textbookid) {
		this.textbookid = textbookid;
	}

	@Column(name = "UNIT", nullable = false)
	public int getUnit() {
		return this.unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Column(name = "PART", nullable = false)
	public int getPart() {
		return this.part;
	}

	public void setPart(int part) {
		this.part = part;
	}

	@Column(name = "SEQNUM", nullable = false)
	public int getSeqnum() {
		return this.seqnum;
	}

	public void setSeqnum(int seqnum) {
		this.seqnum = seqnum;
	}

	@Column(name = "WORD", nullable = false, length = 2000000000)
	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Column(name = "NOTE", length = 2000000000)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
