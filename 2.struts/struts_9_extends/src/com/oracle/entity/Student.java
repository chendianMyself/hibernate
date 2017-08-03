package com.oracle.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

	private Integer id;
	private String name;
	private String mobile;
	private int age;
	private String address;
	
	public Student(ResultSet rs){
		try {
			this.id=rs.getInt(1);
			this.name=rs.getString(2);
			this.mobile=rs.getString(3);
			this.age=rs.getInt(4);
			this.address=rs.getString(5);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student(String name, String mobile, int age, String address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
	}
	public Student(Integer id, String name, String mobile, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.age = age;
		this.address = address;
	}
	public Student() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
