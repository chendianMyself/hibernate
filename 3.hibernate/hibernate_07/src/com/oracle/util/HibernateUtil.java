package com.oracle.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sf;
	
	static{
		Configuration cfg=new Configuration().configure();
		
		ServiceRegistry sr=new StandardServiceRegistryBuilder().build();
		
		sf=cfg.buildSessionFactory();
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
	
	
}
