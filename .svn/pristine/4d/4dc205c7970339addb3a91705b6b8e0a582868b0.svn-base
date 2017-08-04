package com.oracle.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Country;
import com.oracle.entity.Province;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		
		Country country=(Country) session.get(Country.class,1);
		
		System.out.println(country.getCid());
		System.out.println(country.getCname());
		
		Set<Province> set=country.getProvinceSet();
		
		for (Province province : set) {
			System.out.println(province);
		}
		
		session.close();
	}
	
	@Test
	public void test2(){
		Session session=HibernateUtil.getSession();
		
		String hql="from Country ";
		
		List<Country> list=session.createQuery(hql).list();
		
		for (Country country : list) {
			System.out.println(country.getCname());
			
			Set<Province> set=country.getProvinceSet();
			
			for (Province province : set) {
				System.out.println(province);
			}
		}
		
		
		session.close();
	}
	
	
	@Test
	public void fetch(){
		Session session=HibernateUtil.getSession();
		
		//迫切左外连接
		//hql语句定义左外连接,不需要通过on条件为两个实体建立关联关系
		//因为hibernate可以通过配置文件或注解,了解两个实体的关联关系,并自动建立关联
		//左外连接的目标不需要是目标类型,直接从当前类的子属性查询即可
		//hql  = " from A a left outer join fetch B b on a.id = b.a_id"这种写法是错误的,因为在B中找不到a_id这种属性?字段?
		String hql="from Country c left outer join fetch c.provinceSet where c.cid = 1";
		
		Country country=(Country) session.createQuery(hql).uniqueResult();
		
		
		System.out.println(country.getCid());
		System.out.println(country.getCname());
		
		Set<Province> set=country.getProvinceSet();
		
		for (Province province : set) {
			System.out.println(province);
		}
		
		session.close();
	}
	@Test
	public void load(){
		Session session=HibernateUtil.getSession();
		
		Country country=(Country) session.get(Country.class,1);
		
		System.out.println(country.getCid());
		System.out.println(country.getCname());
		
		Set<Province> set=country.getProvinceSet();
		
		for (Province province : set) {
			System.out.println(province);
		}
		
		session.close();
	}
	
	
	
	//特别懒加载
	@Test
	public void extra(){
		Session session=HibernateUtil.getSession();
		
		Country country=(Country) session.get(Country.class,1);
		
		System.out.println(country.getCid());
		System.out.println(country.getCname());
		
		Set<Province> set=country.getProvinceSet();
		
		//特别懒加载,在能够使用聚合函数查询达到目标时,坚决不使用详情查询
		System.out.println(set.size());
		
		session.close();
	}
	
	
}
