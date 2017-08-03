package com.oracle.test;

public class PersonProxy implements Eatable{

	Eatable p;
	
	
	public PersonProxy(Eatable p) {
		super();
		this.p = p;
	}


	public void eat(){
		System.out.println("做饭");
		p.eat();
		System.out.println("洗碗");
	}
}
