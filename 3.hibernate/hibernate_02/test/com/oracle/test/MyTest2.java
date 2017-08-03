package com.oracle.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.oracle.entity.Student;

public class MyTest2 {

	private SessionFactory sessionFactory;
	
	
	//执行任意test方法之前,先执行before注解的方法
	@Before
	public void before(){
		Configuration cfg=new Configuration();
		
		//启用配置文件
		cfg=cfg.configure();
		
		//通过配置项生成SessionFactory
		sessionFactory=cfg.buildSessionFactory();
		
		
	}
	
	@Test
	public void update(){
		
		Student student=new Student("王五", 24, new Date());
		student.setId(2);
		
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.update(student);
		
		tx.commit();
		
		session.close();
		
	}
	
	
	@Test
	public void delete(){
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		//需要删除的数据,必须为其主键赋值
		Student student=new Student();
		student.setId(2);
		
		session.delete(student);
		
		tx.commit();
		
		session.close();
	}
	
	
	@Test
	public void find(){
		Session session=sessionFactory.openSession();
		
		//int>>Integer>>Serializable
		
		//通过get方法可以查找指定id,指定类型的数据
		Object result=session.get(Student.class, 1);
		
		session.close();
		
		System.out.println("------------");
		Student student=(Student)result;
		
		System.out.println(student);
		
	}
	
	@Test
	public void load(){
		Session session=sessionFactory.openSession();
		
		//load与get用法相同,但load属于懒加载
		//程序在接下来的代码中,如果没有调用查询对象的任何属性和方法
		//那么该查询不会真的执行
		//只有在调用该对象的任意属性和方法时,查询语句立即执行并返回结果
		Object result= session.load(Student.class, 1);
		
		//session.close();
		
		System.out.println("-----------------");
		Student student=(Student)result;
		
		System.out.println(student);
	}
	
	
}
