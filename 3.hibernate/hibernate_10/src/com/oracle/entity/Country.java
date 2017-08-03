package com.oracle.entity;

import java.util.Set;

import com.mchange.v2.encounter.StrongEqualityEncounterCounter;

public class Country {

	private Integer cid;
	private String cname;
	
	private String ccode;
	
	public Country( String cname) {
		this.cname = cname;
	}
	public Country() {
		super();
	}
	//在一的一方,建立一个Set,并将泛型类型定义为多的一方
	private Set<Province> provinceSet;
	
	
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
	public Set<Province> getProvinceSet() {
		return provinceSet;
	}
	public void setProvinceSet(Set<Province> provinceSet) {
		this.provinceSet = provinceSet;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", provinceSet=" + provinceSet + "]";
	}
	
}
