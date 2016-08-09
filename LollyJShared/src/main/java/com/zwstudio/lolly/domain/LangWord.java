package com.zwstudio.lolly.domain;
// Generated 2016/08/09 13:08:27 by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LangWord generated by hbm2java
 */
@Entity
@Table(name = "LANGWORDS")
public class LangWord implements java.io.Serializable {

	private int id;
	private int langid;
	private String word;
	private int level;

	public LangWord() {
	}

	public LangWord(int id, int langid, String word, int level) {
		this.id = id;
		this.langid = langid;
		this.word = word;
		this.level = level;
	}

	@Id

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "LANGID", nullable = false)
	public int getLangid() {
		return this.langid;
	}

	public void setLangid(int langid) {
		this.langid = langid;
	}

	@Column(name = "WORD", nullable = false, length = 2000000000)
	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Column(name = "LEVEL", nullable = false)
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}