package com.oracle.test;

import java.lang.reflect.Proxy;

public class Test01 {
	public static void main(String[] args) {
		Person person=new Person("张三");
		
		MyProxyHandler mph=new MyProxyHandler(person);
		
		//使用JDK的Proxy动态代理,要求代理类必须实现接口
		
		Drinkable e=(Drinkable)Proxy.newProxyInstance(
				//代理对象的类加载器
				Person.class.getClassLoader(),
				//代理对象的所有接口
				Person.class.getInterfaces(),
				//调用处理程序
				mph);
		
		e.drink();
	}
}
