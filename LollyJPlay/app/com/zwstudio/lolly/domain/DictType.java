package com.zwstudio.lolly.domain;

// Generated 2014-10-4 23:22:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DictType generated by hbm2java
 */
@Entity
@Table(name = "DICTTYPES")
public class DictType implements java.io.Serializable {

	private int dicttypeid;
	private String dicttypename;

	public DictType() {
	}

	public DictType(int dicttypeid, String dicttypename) {
		this.dicttypeid = dicttypeid;
		this.dicttypename = dicttypename;
	}

	@Id
	@Column(name = "DICTTYPEID", nullable = false)
	public int getDicttypeid() {
		return this.dicttypeid;
	}

	public void setDicttypeid(int dicttypeid) {
		this.dicttypeid = dicttypeid;
	}

	@Column(name = "DICTTYPENAME", nullable = false, length = 2000000000)
	public String getDicttypename() {
		return this.dicttypename;
	}

	public void setDicttypename(String dicttypename) {
		this.dicttypename = dicttypename;
	}

}
