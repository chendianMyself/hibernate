package com.oracle.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Country country=(Country) session.get(Country.class, 2);
		
		Province menggu=(Province) session.get(Province.class, 11);
		
		Set<Province> provinceSet=country.getProvinceSet();
		
		provinceSet.remove(menggu);
		
		
		//session.delete(country);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
}
