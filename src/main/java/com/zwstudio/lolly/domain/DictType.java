package com.zwstudio.lolly.domain;

// Generated 2014-9-28 14:08:58 by Hibernate Tools 4.3.1

/**
 * DictType generated by hbm2java
 */
public class DictType implements java.io.Serializable {

	private int dicttypeid;
	private String dicttypename;

	public DictType() {
	}

	public DictType(int dicttypeid, String dicttypename) {
		this.dicttypeid = dicttypeid;
		this.dicttypename = dicttypename;
	}

	public int getDicttypeid() {
		return this.dicttypeid;
	}

	public void setDicttypeid(int dicttypeid) {
		this.dicttypeid = dicttypeid;
	}

	public String getDicttypename() {
		return this.dicttypename;
	}

	public void setDicttypename(String dicttypename) {
		this.dicttypename = dicttypename;
	}

}
