package com.oracle.entity;

import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private int age;
	private Date birthDay;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student(Integer id, String name, int age, Date birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDay = birthDay;
	}
	public Student(String name, int age, Date birthDay) {
		super();
		this.name = name;
		this.age = age;
		this.birthDay = birthDay;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birthDay=" + birthDay + "]";
	}
}
