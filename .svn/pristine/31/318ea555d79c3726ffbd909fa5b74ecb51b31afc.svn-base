package com.oracle.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyHandler implements InvocationHandler {

	private Person person;
	public MyProxyHandler(Person person) {
		super();
		this.person = person;
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("做饭");
		
		Object result=method.invoke(person, args);
		
		System.out.println("洗碗");
		return result;
	}

}
