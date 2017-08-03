package com.oracle.test;

import java.util.Date;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.oracle.entity.Student;

public class MyTest {
	
	private static SessionFactory sessionFactory;
	
	static{
		Configuration cfg=new Configuration();
		cfg.addResource("com/oracle/entity/Student.hbm.xml");
		//启用配置文件
		cfg=cfg.configure();
		
		//通过配置项生成SessionFactory
		sessionFactory=cfg.buildSessionFactory();
	}
	
	public static void main(String[] args) {
		long time1=System.currentTimeMillis();//获取当前系统时间毫秒值
		
		//使用系统默认设置加载默认的配置文件
		//要求配置文件存在于src根目录,并且文件名为hibernate.cfg.xml
		
		
		long time2=System.currentTimeMillis();
		
		
		Session session= sessionFactory.openSession();
		long time3=System.currentTimeMillis();
		
		
		Student student=new Student("张三", 18, new Date());
		
		
		Transaction tx=session.beginTransaction();
		
		session.save(student);
		
		tx.commit();
		long time4=System.currentTimeMillis();
		
		session.close();
		
		sessionFactory.close();
		System.out.println("获取sessionFactory时间");
		System.out.println(time2-time1);
		System.out.println("获取session时间");
		System.out.println(time3-time2);
		System.out.println("添加操作用时");
		System.out.println(time4-time3);
		
	}
}
