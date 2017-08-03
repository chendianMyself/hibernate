package com.oracle.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

	private static SessionFactory sf;
	
	static{
		Configuration cfg=new Configuration().configure();
		
		Properties props=cfg.getProperties();
		
		//如果使用默认的StandardServiceRegistryBuilder
		//会默认从hibernate.properties里加载dialect,hbm2ddl,show_sql等等设置
		
		//但是我们的设置,在沿用旧版本习惯时,通常会定义在hibernate.cfg.xml中
		//所以我们应当从hibernate.cfg.xml中取出这些属性设置,赋予StandardServiceRegistryBuilder
		ServiceRegistry sr=new StandardServiceRegistryBuilder()
				.applySettings(props)
				.build();
		
		sf=cfg.buildSessionFactory(sr);
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
	
	
}
