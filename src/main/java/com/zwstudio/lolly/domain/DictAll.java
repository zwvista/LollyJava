package com.zwstudio.lolly.domain;

// Generated 2014-10-4 23:22:52 by Hibernate Tools 4.3.1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DictAll generated by hbm2java
 */
@Entity
@Table(name = "DICTALL")
public class DictAll implements java.io.Serializable {

	private DictAllId id;
	private Integer langidto;
	private String dicttypename;
	private String dictname;
	private String url;
	private String chconv;
	private String automation;
	private Integer autojump;
	private String dicttable;
	private String transformWin;
	private String transformMac;
	private Integer wait;
	private String template;

	public DictAll() {
	}

	public DictAll(DictAllId id) {
		this.id = id;
	}

	public DictAll(DictAllId id, Integer langidto, String dicttypename,
			String dictname, String url, String chconv, String automation,
			Integer autojump, String dicttable, String transformWin,
			String transformMac, Integer wait, String template) {
		this.id = id;
		this.langidto = langidto;
		this.dicttypename = dicttypename;
		this.dictname = dictname;
		this.url = url;
		this.chconv = chconv;
		this.automation = automation;
		this.autojump = autojump;
		this.dicttable = dicttable;
		this.transformWin = transformWin;
		this.transformMac = transformMac;
		this.wait = wait;
		this.template = template;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "langid", column = @Column(name = "LANGID")),
			@AttributeOverride(name = "index", column = @Column(name = "INDEX")) })
	public DictAllId getId() {
		return this.id;
	}

	public void setId(DictAllId id) {
		this.id = id;
	}

	@Column(name = "LANGIDTO")
	public Integer getLangidto() {
		return this.langidto;
	}

	public void setLangidto(Integer langidto) {
		this.langidto = langidto;
	}

	@Column(name = "DICTTYPENAME", length = 2000000000)
	public String getDicttypename() {
		return this.dicttypename;
	}

	public void setDicttypename(String dicttypename) {
		this.dicttypename = dicttypename;
	}

	@Column(name = "DICTNAME", length = 2000000000)
	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
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

	@Column(name = "AUTOJUMP")
	public Integer getAutojump() {
		return this.autojump;
	}

	public void setAutojump(Integer autojump) {
		this.autojump = autojump;
	}

	@Column(name = "DICTTABLE", length = 2000000000)
	public String getDicttable() {
		return this.dicttable;
	}

	public void setDicttable(String dicttable) {
		this.dicttable = dicttable;
	}

	@Column(name = "TRANSFORM_WIN", length = 2000000000)
	public String getTransformWin() {
		return this.transformWin;
	}

	public void setTransformWin(String transformWin) {
		this.transformWin = transformWin;
	}

	@Column(name = "TRANSFORM_MAC", length = 2000000000)
	public String getTransformMac() {
		return this.transformMac;
	}

	public void setTransformMac(String transformMac) {
		this.transformMac = transformMac;
	}

	@Column(name = "WAIT")
	public Integer getWait() {
		return this.wait;
	}

	public void setWait(Integer wait) {
		this.wait = wait;
	}

	@Column(name = "TEMPLATE", length = 2000000000)
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
