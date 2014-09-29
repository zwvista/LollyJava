package com.zwstudio.lolly.domain;

// Generated 2014-9-29 23:34:43 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Dictionary generated by hbm2java
 */
@Entity
@Table(name = "DICTIONARIES")
public class Dictionary implements java.io.Serializable {

	private DictionaryId id;
	private int index;
	private int dicttypeid;
	private int langidto;
	private String url;
	private String chconv;
	private String automation;
	private int autojump;
	private String dicttable;
	private String template;

	public Dictionary() {
	}

	public Dictionary(DictionaryId id, int index, int dicttypeid, int langidto,
			int autojump) {
		this.id = id;
		this.index = index;
		this.dicttypeid = dicttypeid;
		this.langidto = langidto;
		this.autojump = autojump;
	}

	public Dictionary(DictionaryId id, int index, int dicttypeid, int langidto,
			String url, String chconv, String automation, int autojump,
			String dicttable, String template) {
		this.id = id;
		this.index = index;
		this.dicttypeid = dicttypeid;
		this.langidto = langidto;
		this.url = url;
		this.chconv = chconv;
		this.automation = automation;
		this.autojump = autojump;
		this.dicttable = dicttable;
		this.template = template;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "langid", column = @Column(name = "LANGID", nullable = false)),
			@AttributeOverride(name = "dictname", column = @Column(name = "DICTNAME", nullable = false, length = 2000000000)) })
	public DictionaryId getId() {
		return this.id;
	}

	public void setId(DictionaryId id) {
		this.id = id;
	}

	@Column(name = "INDEX", nullable = false)
	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Column(name = "DICTTYPEID", nullable = false)
	public int getDicttypeid() {
		return this.dicttypeid;
	}

	public void setDicttypeid(int dicttypeid) {
		this.dicttypeid = dicttypeid;
	}

	@Column(name = "LANGIDTO", nullable = false)
	public int getLangidto() {
		return this.langidto;
	}

	public void setLangidto(int langidto) {
		this.langidto = langidto;
	}

	@Column(name = "URL", length = 2000000000)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "CHCONV", length = 2000000000)
	public String getChconv() {
		return this.chconv;
	}

	public void setChconv(String chconv) {
		this.chconv = chconv;
	}

	@Column(name = "AUTOMATION", length = 2000000000)
	public String getAutomation() {
		return this.automation;
	}

	public void setAutomation(String automation) {
		this.automation = automation;
	}

	@Column(name = "AUTOJUMP", nullable = false)
	public int getAutojump() {
		return this.autojump;
	}

	public void setAutojump(int autojump) {
		this.autojump = autojump;
	}

	@Column(name = "DICTTABLE", length = 2000000000)
	public String getDicttable() {
		return this.dicttable;
	}

	public void setDicttable(String dicttable) {
		this.dicttable = dicttable;
	}

	@Column(name = "TEMPLATE", length = 2000000000)
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
