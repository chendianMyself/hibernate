package com.oracle.entity;

public class Province {

	private Integer pid;
	private String pname;
	
	//多对一关联
	//在多的一方,定义关联关系,与一的一方连接
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Province(String pname) {
		super();
		this.pname = pname;
	}
}
