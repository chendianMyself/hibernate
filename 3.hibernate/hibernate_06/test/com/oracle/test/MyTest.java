package com.oracle.test;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import com.oracle.entity.Student;
import com.oracle.entity.Teacher;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class MyTest {
	private SessionFactory sessionFactory;
	@Before
	public void before(){
		Configuration cfg=new Configuration();
		
		//启用配置文件
		cfg=cfg.configure("abc.cfg.xml");
		
		
		
		
		//通过配置项生成SessionFactory
		sessionFactory=cfg.buildSessionFactory();
	}
	
	
	@Test
	public void test1(){
		Session session=sessionFactory.openSession();
		
		//hibernate query language
		//hql语句通过对象去查询
		String hql="select s from Student s";
		//以上hql语句可以简写为from Student 
		//如果没有定义查询列,则默认查询全部,甚至select关键字也可以不写
		
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		
		//调用该query的list方法,可以直接返回以该对象组成的List集合
		List<Student> list = query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		session.close();
	}
	
	
	@Test
	public void test2(){
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(new Teacher());
		
		//获取刚才开启的事务
		session.getTransaction().commit();
		
		
		
		session.close();
	}
}
