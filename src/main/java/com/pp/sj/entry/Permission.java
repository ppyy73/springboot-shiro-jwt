package com.pp.sj.entry;
/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:29:23
 * @Description
 *
 */
public class Permission {

	private int id;
	private String pName;
	private int rId;

	public Permission() {
		super();
	}

	public Permission(int id, String pName, int rId) {
		super();
		this.id = id;
		this.pName = pName;
		this.rId = rId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

}
