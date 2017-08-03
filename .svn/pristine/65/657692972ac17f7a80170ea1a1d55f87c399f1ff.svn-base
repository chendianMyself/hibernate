package com.oracle.test;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

import sun.launcher.resources.launcher;

public class MyTest {
	
	@Test
	public void none(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Province province=new Province("山东");
		
		Country country=(Country) session.get(Country.class, 2);
		
		//设置关联关系
		province.setCountry(country);
		
		//现在是"多"这一方维护关系,所以"一"这一方保存时,不会保存"多"这一方数据
		//session.save(country);
		
		session.save(province);
		
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	@Test
	public void none2(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Province province=new Province("abcd");
		
		Country country=new Country("XX国");
		
		province.setCountry(country);
		//country属于瞬时态对象,在级联操作cascade为none的情况下
		//直接保存province是无法成功的
		//需要先保存country,再保存province
		session.save(country);
		
		session.save(province);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	@Test
	public void save_update(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Province province=new Province("defg");
		
		Country country=new Country("YY国");
		
		province.setCountry(country);
		
		//级联操作cascade设置为save-update时,hibernate会自动先保存country,再保存province
		session.save(province);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	@Test
	public void delete1(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Province province=new Province();
		province.setPid(17);
		
		//级联操作(cascade没有包含delete时),
		//删除province时只删除当前这一条数据,不会影响其关联的主数据country
		session.delete(province);
		
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	@Test
	public void delete2(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Province province=new Province();
		province.setPid(20);
		
		//cascade即便设置为delete,在删除province时也不会删除country
		//在多对一中,cascade不存在delete这样一个选项
		//因为在删除"多"这一方数据时,如果同时删除了"一"这一方数据
		//那么"一"这一方关联的其他数据将无法处理
		//所以干脆无法删除主数据
		session.delete(province);
		
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	//delete-orphan
	//因为多对一不涉及集合,所以无法调用集合的remove方法
	//不存在delete-orphan这样的设置

}
