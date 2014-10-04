package com.zwstudio.lolly.domain;

// Generated 2014-10-4 23:22:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wordsbook generated by hbm2java
 */
@Entity
@Table(name = "WORDSBOOK")
public class Wordsbook implements java.io.Serializable {

	private int id;
	private int bookid;
	private int unit;
	private int part;
	private int index;
	private String word;
	private String note;

	public Wordsbook() {
	}

	public Wordsbook(int id, int bookid, int unit, int part, int index,
			String word) {
		this.id = id;
		this.bookid = bookid;
		this.unit = unit;
		this.part = part;
		this.index = index;
		this.word = word;
	}

	public Wordsbook(int id, int bookid, int unit, int part, int index,
			String word, String note) {
		this.id = id;
		this.bookid = bookid;
		this.unit = unit;
		this.part = part;
		this.index = index;
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

	@Column(name = "BOOKID", nullable = false)
	public int getBookid() {
		return this.bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	@Column(name = "INDEX", nullable = false)
	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
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
