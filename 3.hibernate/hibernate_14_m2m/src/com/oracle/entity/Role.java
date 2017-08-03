package com.oracle.entity;

import java.util.Set;

public class Role {

	private Integer rid;
	private String rname;
	private String rcode;
	
	private Set<User> userSet;
	
	public Role(String rname, String rcode) {
		super();
		this.rname = rname;
		this.rcode = rcode;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRcode() {
		return rcode;
	}
	public void setRcode(String rcode) {
		this.rcode = rcode;
	}
	
	public Set<User> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", rcode=" + rcode + "]";
	}
	
}
