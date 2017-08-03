package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		/*
		 * 使用一对多是应当慎重使用
		 * 如果一定要使用一对多,应当在关闭session之前将多的一方显示的调用,否则因为懒加载问题,多这一方数据不会自动查询
		 * 
		 * 可以通过为orm映射文件中的set标签配置lazy="false"属性来关闭懒加载
		 * 关闭懒加载后,所有对主数据的查询操作,将自动查询子数据
		 * 子数据的大量查询可能会降低服务器的运行效率
		 * 
		 * */
		
		Country country=(Country) session.get(Country.class, 2);
		
		//System.out.println(country);
		System.out.println(country.getCname());
		
		session.close();
		
		//no Session
		//Set<Province> set=country.getProvinceSet();
		
		//System.out.println(set.size());
	}
	
	
	@Test
	public void test2(){
		Session session=HibernateUtil.getSession();
		
		
		Country country=(Country) session.get(Country.class, 2);
		System.out.println(country.getCname());
		
		String hql="from Province p where p.country_id = 2";
		
		
		session.close();
	}
	
}
