package com.oracle.test;

public class Test01 {
	public static void main(String[] args) {
		Eatable p=new Person("张三");
		//Person p2=new Person("李四");
		
		//创建这个代理对象,就是为了指定对象服务的
		Eatable proxy=new PersonProxy(p);
		proxy.eat();
		
		
		
		((Person)p).drink();
	}
}
