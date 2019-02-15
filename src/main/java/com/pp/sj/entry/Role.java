package com.pp.sj.entry;
/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:29:30
 * @Description
 *
 */
public class Role {

	private int id;
	private String rName;
	private int uId;

	public Role() {
		super();
	}

	public Role(int id, String rName, int uId) {
		super();
		this.id = id;
		this.rName = rName;
		this.uId = uId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

}
