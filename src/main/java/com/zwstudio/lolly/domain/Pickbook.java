package com.zwstudio.lolly.domain;

// Generated 2014-10-4 23:22:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pickbook generated by hbm2java
 */
@Entity
@Table(name = "PICBOOKS")
public class Pickbook implements java.io.Serializable {

	private String bookname;
	private int langid;
	private String filename;
	private int numpages;
	private int curpage;

	public Pickbook() {
	}

	public Pickbook(String bookname, int langid, String filename, int numpages,
			int curpage) {
		this.bookname = bookname;
		this.langid = langid;
		this.filename = filename;
		this.numpages = numpages;
		this.curpage = curpage;
	}

	@Id
	@Column(name = "BOOKNAME", unique = true, nullable = false, length = 2000000000)
	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@Column(name = "LANGID", nullable = false)
	public int getLangid() {
		return this.langid;
	}

	public void setLangid(int langid) {
		this.langid = langid;
	}

	@Column(name = "FILENAME", nullable = false, length = 2000000000)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "NUMPAGES", nullable = false)
	public int getNumpages() {
		return this.numpages;
	}

	public void setNumpages(int numpages) {
		this.numpages = numpages;
	}

	@Column(name = "CURPAGE", nullable = false)
	public int getCurpage() {
		return this.curpage;
	}

	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}

}
