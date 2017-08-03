package com.oracle.entity;

public class Province {

	private Integer pid;
	private String pname;
	
	
	public Province(String pname) {
		super();
		this.pname = pname;
	}
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}
