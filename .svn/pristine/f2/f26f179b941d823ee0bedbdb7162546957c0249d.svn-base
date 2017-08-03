package com.oracle.test;

public class Test01 {
	/*
	 * 因为基于JDK的动态代理要求被代理对象必须实现接口
	 * 
	 * 如果没有接口则无法使用动态代理
	 * 
	 * 所以引入cglib,实现无接口的动态代理
	 * */
	public static void main(String[] args) {
		Person person=new Person("张三");
		
		ProxyFactory<Person> pf=new ProxyFactory<Person>();
		pf.setClass(Person.class);
		
		pf.setPerson(person);
		Person p=pf.enhancerCreator();
		
		p.eat();
		person.drink();
	}
}
