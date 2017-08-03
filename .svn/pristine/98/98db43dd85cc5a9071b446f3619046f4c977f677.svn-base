package com.oracle.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.oracle.entity.Student;

public class PersistentTest {
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
	public void transistent1(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//临态:transient
		//新创建的对象,数据库不存在,且没有纳入hibernate的session管理
		Student student=new Student("王五", 24, new Date());
		
		//session.save(student);
		
		tx.commit();
		
		session.close();
	}
	@Test
	public void transistent2(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//临态:transient
		//临态的数据在经过save方法,通过session保存到数据库之后,就可以进入持久状态(persistent)
		Student student=new Student("王五", 24, new Date());
		
		session.save(student);
		
		tx.commit();
		
		session.close();
	}
	@Test
	public void transistent3(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//临态:transient
		//临态的数据在经过save方法,通过session保存到数据库之后,就可以进入持久状态(persistent)
		Student student=new Student("王五", 24, new Date());
		
		//session自动判断这个对象属于临态还是离线,如果是临态,则自动调用save方法
		session.saveOrUpdate(student);
		
		tx.commit();
		
		session.close();
	}
	
	
	
	
	
	
}
