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
	public void get(){
		Session session=HibernateUtil.getSession();
		
		Role role=(Role) session.get(Role.class, 2);
		
		
		Set<User> userSet=role.getUserSet();
		for (User user : userSet) {
			
			System.out.println(user);
		}
		
		session.close();
	}
	
}
