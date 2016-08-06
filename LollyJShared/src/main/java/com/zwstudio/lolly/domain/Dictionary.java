package com.zwstudio.lolly.domain;
// Generated 2016/08/06 9:15:14 by Hibernate Tools 5.1.0.Beta1

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
@Table(name = "VDICTIONARIES2")
public class Dictionary implements java.io.Serializable {

	private DictionaryId id;
	private Integer langidto;
	private Integer seqnum;
	private String dicttypename;
	private String url;
	private String chconv;
	private String automation;
	private Double autojump;
	private String dicttable;
	private String transformWin;
	private String transformMac;
	private Integer wait;
	private String template;

	public Dictionary() {
	}

	public Dictionary(DictionaryId id) {
		this.id = id;
	}

	public Dictionary(DictionaryId id, Integer langidto, Integer seqnum, String dicttypename, String url, String chconv,
			String automation, Double autojump, String dicttable, String transformWin, String transformMac,
			Integer wait, String template) {
		this.id = id;
		this.langidto = langidto;
		this.seqnum = seqnum;
		this.dicttypename = dicttypename;
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
			@AttributeOverride(name = "langidfrom", column = @Column(name = "LANGIDFROM", nullable = false)),
			@AttributeOverride(name = "dictname", column = @Column(name = "DICTNAME", nullable = false, length = 2000000000)) })
	public DictionaryId getId() {
		return this.id;
	}

	public void setId(DictionaryId id) {
		this.id = id;
	}

	@Column(name = "LANGIDTO")
	public Integer getLangidto() {
		return this.langidto;
	}

	public void setLangidto(Integer langidto) {
		this.langidto = langidto;
	}

	@Column(name = "SEQNUM")
	public Integer getSeqnum() {
		return this.seqnum;
	}

	public void setSeqnum(Integer seqnum) {
		this.seqnum = seqnum;
	}

	@Column(name = "DICTTYPENAME", length = 2000000000)
	public String getDicttypename() {
		return this.dicttypename;
	}

	public void setDicttypename(String dicttypename) {
		this.dicttypename = dicttypename;
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

	@Column(name = "AUTOJUMP", precision = 2000000000, scale = 10)
	public Double getAutojump() {
		return this.autojump;
	}

	public void setAutojump(Double autojump) {
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
