package com.oracle.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.oracle.entity.Student;

public class MyTest {

	
	@Test
	public void update(){
		Configuration cfg=new Configuration();
		
		//启用配置文件
		cfg=cfg.configure();
		
		//通过配置项生成SessionFactory
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		Student student=new Student("王五", 24, new Date());
		student.setId(2);
		
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.update(student);
		
		tx.commit();
		
		session.close();
		
	}
	
	
	public void delete(){
		Configuration cfg=new Configuration();
		
		//启用配置文件
		cfg=cfg.configure();
		
		//通过配置项生成SessionFactory
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		
		
	}
	
	
	
}
