package com.oracle.entity;

public class Country {

	private Integer cid;
	private String cname;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Country(String cname) {
		super();
		this.cname = cname;
	}
	
}
