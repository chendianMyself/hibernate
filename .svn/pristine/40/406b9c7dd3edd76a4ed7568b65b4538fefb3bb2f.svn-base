package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		
		Province province=(Province) session.get(Province.class, 10);
		
		
		System.out.println(province.getPid());
		System.out.println(province.getPname());
		
		/*
		 * 多对一查询默认使用lazy="true"
		 * 如果需要立即加载,应当将lazy设置为false
		 * 
		 * */
		//System.out.println(province.getCountry().getCname());
		session.close();
		
	}

}
