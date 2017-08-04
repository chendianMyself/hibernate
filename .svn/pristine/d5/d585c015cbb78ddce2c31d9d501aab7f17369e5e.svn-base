package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void select(){
		Session session=HibernateUtil.getSession();
		
		Province province=(Province) session.get(Province.class, 1);
		
		System.out.println(province.getPname());

		Country country=province.getCountry();
		
		System.out.println(country.getCname());
		
		session.close();
		
	}
	@Test
	public void join(){
		Session session=HibernateUtil.getSession();
		
		Province province=(Province) session.get(Province.class, 1);
		
		System.out.println(province.getPname());
		
		Country country=province.getCountry();
		
		System.out.println(country.getCname());
		
		session.close();
		
	}

}
