package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void get(){
		Session session=HibernateUtil.getSession();
		
		Province province = (Province) session.get(Province.class, 1);
		
		System.out.println(province.getPid());
		System.out.println(province.getPname());
		
		session.close();
	}
	
	
	@Test
	public void load(){
		Session session=HibernateUtil.getSession();
		
		Province province = (Province) session.load(Province.class, 1);
		
		System.out.println(province.getPid());
		
		System.out.println("sql....");
		
		System.out.println(province.getPname());
		
		session.close();
	}
	
}
