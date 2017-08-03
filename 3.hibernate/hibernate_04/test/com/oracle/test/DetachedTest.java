package com.oracle.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.oracle.entity.Student;

public class DetachedTest {
	private SessionFactory sessionFactory;
	@Before
	public void before(){
		Configuration cfg=new Configuration();
		
		//启用配置文件
		cfg=cfg.configure();
		
		//通过配置项生成SessionFactory
		sessionFactory=cfg.buildSessionFactory();
	}
	
	
	@Test
	public void detached1(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//离线(游离态):detached
		//新创建的对象,主键有值并且在数据库存在该主键对应的数据
		//只是内有纳入session管理
		Student student=new Student("王五", 24, new Date());
		student.setId(1);
		//session.save(student);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void detached2(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//如果当前对象的id在数据库已经存在,那么在调用session相关方法前,这个对象始终处于离线状态
		Student student=new Student();
		student.setId(1);
		
		//通过get方法,从数据查询该对象
		student=(Student) session.get(Student.class, student.getId());
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void detached3(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//如果当前对象的id在数据库已经存在,那么在调用session相关方法前,这个对象始终处于离线状态
		Student student=new Student();
		student.setId(1);
		
		//通过get方法,从数据查询该对象
		student=(Student) session.load(Student.class, student.getId());
		
		
		
		tx.commit();
		
		session.close();
	}
	
	
	
	
	
	
}
