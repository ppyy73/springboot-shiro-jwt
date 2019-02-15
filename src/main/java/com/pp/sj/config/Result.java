package com.pp.sj.config;

import java.io.Serializable;

/**
 * 
 * @author pp
 * @Date 2019年2月14日下午5:28:40
 * @Description
 *
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	private Object data;

	public Result() {
		super();
	}

	public Result(String msg, Object data) {
		super();
		this.msg = msg;
		this.data = data;
	}

	public Result(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
