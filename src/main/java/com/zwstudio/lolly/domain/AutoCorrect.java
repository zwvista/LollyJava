package com.zwstudio.lolly.domain;

// Generated 2014-10-4 23:22:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AutoCorrect generated by hbm2java
 */
@Entity
@Table(name = "AUTOCORRECT")
public class AutoCorrect implements java.io.Serializable {

	private int id;
	private Language language;
	private int index;
	private String input;
	private String extended;
	private String basic;

	public AutoCorrect() {
	}

	public AutoCorrect(int id, Language language, int index, String input,
			String extended, String basic) {
		this.id = id;
		this.language = language;
		this.index = index;
		this.input = input;
		this.extended = extended;
		this.basic = basic;
	}

	@Id
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LANGID", nullable = false)
	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Column(name = "INDEX", nullable = false)
	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Column(name = "INPUT", nullable = false, length = 2000000000)
	public String getInput() {
		return this.input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Column(name = "EXTENDED", nullable = false, length = 2000000000)
	public String getExtended() {
		return this.extended;
	}

	public void setExtended(String extended) {
		this.extended = extended;
	}

	@Column(name = "BASIC", nullable = false, length = 2000000000)
	public String getBasic() {
		return this.basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

}
