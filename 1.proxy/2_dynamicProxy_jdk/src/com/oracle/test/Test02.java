package com.oracle.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test02 {
	public static void main(String[] args) {
		Person person=new Person("李四");
		Person person1=new Person("王五");
		
		Eatable e=(Eatable) Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				
				//匿名内部类
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("做饭");
						
						//proxy是代理对象
						//这里需要的obj是代理人的而不是proxy
						Object result=method.invoke(person, args);
						
						System.out.println("洗碗");
						return result;
					}
				});
		
		e.eat();
	}
}
