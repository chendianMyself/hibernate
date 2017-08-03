package com.oracle.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.oracle.entity.Role;
import com.oracle.entity.User;
import com.oracle.util.HibernateUtil;

public class MyTest {
	
	@Test
	public void save(){
		Session session=HibernateUtil.getSession();
		
		session.beginTransaction();
		
		Role role1=new Role("董事长","dsz");
		Role role2=new Role("总经理","zjl");
		Set<Role> set=new HashSet<Role>();
		set.add(role1);
		set.add(role2);
		
		User user=new User("张三","zhangsan","123");
		
		
		user.setRoleSet(set);
		
		session.save(user);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Test
	public void get(){
		Session session=HibernateUtil.getSession();
		
		User user=(User) session.get(User.class, 2);
		
		System.out.println(user);
		
		
		session.close();
	}
	
}
