package com.oracle.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory<T> implements MethodInterceptor{

	private Class<T> clazz;
	private Object obj;
	
	public void setPerson(Object obj){
		this.obj=obj;
	}
	
	public void setClass(Class<T> clazz){
		this.clazz=clazz;
	}
	//使用cglib动态代理,要求被代理类,必须不能是final的
	public T enhancerCreator(){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(clazz);//Person.class
		
		enhancer.setCallback(this);
		
		T p=(T)enhancer.create();
		return p;
	}
	
	//proxy是代理对象
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("做饭");
		method.invoke(obj, args);
		System.out.println("洗碗");
		return new String("hello world");
	}
}
