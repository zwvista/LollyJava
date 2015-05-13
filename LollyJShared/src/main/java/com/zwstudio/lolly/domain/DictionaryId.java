package com.zwstudio.lolly.domain;

// Generated 2014-10-4 23:22:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DictionaryId generated by hbm2java
 */
@Embeddable
public class DictionaryId implements java.io.Serializable {

	private int langid;
	private String dictname;

	public DictionaryId() {
	}

	public DictionaryId(int langid, String dictname) {
		this.langid = langid;
		this.dictname = dictname;
	}

	@Column(name = "LANGID", nullable = false)
	public int getLangid() {
		return this.langid;
	}

	public void setLangid(int langid) {
		this.langid = langid;
	}

	@Column(name = "DICTNAME", nullable = false, length = 2000000000)
	public String getDictname() {
		return this.dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DictionaryId))
			return false;
		DictionaryId castOther = (DictionaryId) other;

		return (this.getLangid() == castOther.getLangid())
				&& ((this.getDictname() == castOther.getDictname()) || (this
						.getDictname() != null
						&& castOther.getDictname() != null && this
						.getDictname().equals(castOther.getDictname())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getLangid();
		result = 37 * result
				+ (getDictname() == null ? 0 : this.getDictname().hashCode());
		return result;
	}

}