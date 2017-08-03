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

public class MyTest {
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
		
		//条件查询
		String hql="from Student where name='黑猫警长'";
		
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
	public void test3(){
		Session session=sessionFactory.openSession();
		
		//条件查询
		String hql="from Student where name = ?";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		//hibernate的占位符从0开始计,与JDBC不同,JDBC是从1开始计
		query.setString(0, "王五");
		
		
		
		//调用该query的list方法,可以直接返回以该对象组成的List集合
		List<Student> list = query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		session.close();
	}
	
	
	@Test
	public void test4(){
		Session session=sessionFactory.openSession();
		
		//模糊查询
		String hql="from Student where name like concat('%',?,'%')";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		//hibernate的占位符从0开始计,与JDBC不同,JDBC是从1开始计
		query.setString(0, "黑");
		
		
		
		//调用该query的list方法,可以直接返回以该对象组成的List集合
		List<Student> list = query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		
		session.close();
	}
	
	//多条件查询
	@Test
	public void test5(){
		Session session=sessionFactory.openSession();
		
		//模糊查询
		String hql="from Student where name like concat('%',?,'%') and age>=?";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		//hibernate的占位符从0开始计,与JDBC不同,JDBC是从1开始计
		query.setString(0, "黑");
		
		//query使用setInteger
		query.setInteger(1, 30);
		
		
		
		//调用该query的list方法,可以直接返回以该对象组成的List集合
		List<Student> list = query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		session.close();
	}

	//唯一查询
	@Test
	public void test6(){
		Session session=sessionFactory.openSession();
		
		//模糊查询
		String hql="from Student where id = ?";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		//hibernate的占位符从0开始计,与JDBC不同,JDBC是从1开始计
		query.setInteger(0, 1);
		
		
		
		//调用该query的list方法,可以直接返回以该对象组成的List集合
		List<Student> list = query.list();
		
		if(list.size()>0){
			Student stu=list.get(0);
			System.out.println(stu);
		}
		session.close();
	}
	//唯一查询
	@Test
	public void test7(){
		Session session=sessionFactory.openSession();
		
		//模糊查询
		String hql="from Student ";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		//hibernate的占位符从0开始计,与JDBC不同,JDBC是从1开始计
		//query.setInteger(0, 1);
		
		//当能够确定查询的结果不超过1条时,可以使用uniqueResult来获取唯一的返回值
		//该返回值为Object类型,可以查询自定义类型
		//如果查询的结果不唯一,则抛出异常
		Student student=(Student) query.uniqueResult();
		
		System.out.println(student);
		session.close();
	}
	
	//聚合函数查询
	@Test
	public void test8(){
		Session session=sessionFactory.openSession();
		
		String hql="select count(u) from Student u";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		
		//使用hibernate聚合函数count查询记录数时,返回的结果是Long类型
		Long count = (Long) query.uniqueResult();
		
		System.out.println(count);
		session.close();
	}
	
	@Test
	public void test9(){
		Session session=sessionFactory.openSession();
		
		//String hql="select count(*) from Student u";
		
		//使用count聚合函数查询时,推荐使用count(主键)
		String hql="select count(id) from Student u";
		
		//query类似于JDBC中的PreparedStatement
		Query query=session.createQuery(hql);
		
		//使用hibernate聚合函数count查询记录数时,返回的结果是Long类型
		Long count = (Long) query.uniqueResult();
		
		System.out.println(count);
		session.close();
	}
	
	@Test
	public void test10(){
		Session session=sessionFactory.openSession();
		
		String hql="from Student s group by s.name";
		
		Query query=session.createQuery(hql);
		
		List<Student> list=query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		
		session.close();
	}
	
	
	//选择查询指定的列的数据
	@Test
	public void test11(){
		Session session=sessionFactory.openSession();
		
		//需要为对象提供相应的构造方法
		String hql="select new Student(name,age) from Student ";
		
		Query query=session.createQuery(hql);
		
		List<Student> list=query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		session.close();
	}
	
	
	//N+1
	@Test
	public void test12(){
		Session session=sessionFactory.openSession();
		
		//需要为对象提供相应的构造方法
		String hql="from Student";
		
		Query query=session.createQuery(hql);
		
		List<Student> list1=query.list();
		
		for (Student student : list1) {
			System.out.println(student);
		}
		
		System.out.println("...............");
		
		List<Student> list2=query.list();
		for (Student student : list2) {
			System.out.println(student);
		}
		
		
		session.close();
	}
	
	
	@Test
	public void test12_1(){
		Session session=sessionFactory.openSession();
		
		//需要为对象提供相应的构造方法
		String hql="from Student";
		
		Query query=session.createQuery(hql);
		
		Iterator<Student> list1=query.iterate();
		
		while(list1.hasNext()){
			System.out.println(list1.next());
		}
		System.out.println("...............");
		
		Iterator<Student> list2=query.iterate();
		
		while(list2.hasNext()){
			System.out.println(list2.next());
		}
		
		session.close();
	}
	
	
	
	@Test
	public void test12_2(){
		Session session=sessionFactory.openSession();
		
		//需要为对象提供相应的构造方法
		String hql="from Student";
		
		Query query=session.createQuery(hql);
		
		List<Student> list1=query.list();
		
		for (Student student : list1) {
			System.out.println(student);
		}
		
		System.out.println("...............");
		
		Iterator<Student> list2=query.iterate();
		
		while(list2.hasNext()){
			System.out.println(list2.next());
		}
		
		
		session.close();
	}
	
	@Test
	public void test13(){
		Session session=sessionFactory.openSession();
		
		Student student1=(Student) session.get(Student.class, 1);
		System.out.println(student1);
		
		Student student2=(Student) session.get(Student.class, 1);
		System.out.println(student2);
		
		session.close();
	}
	
	
	//分页查询
	@Test
	public void test14(){
		Session session=sessionFactory.openSession();
		
		String hql="from Student ";
		
		Query query=session.createQuery(hql);
		
		//使用hibernate分页,设置第一个结果的起始位置,应该从0开始
		query.setFirstResult(0);
		query.setMaxResults(10);
		
		List<Student> list=query.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("==========================");
		System.out.println(list.size());
		session.close();
	}
	
	
	//命名查询
	@Test
	public void test15(){
		Session session=sessionFactory.openSession();
		
		Query query=session.getNamedQuery("abcdefg");
		//Query query=session.createQuery("from Student s where s.age >29 and s.age < 31");
		//Long count=(Long) query.uniqueResult();
		
		BigInteger bi=(BigInteger) query.uniqueResult();
		Integer integer=new Integer(bi.toString());
		System.out.println(integer);
		session.close();
	}
	
	//sql查询
	@Test
	public void test16(){
		Session session=sessionFactory.openSession();
		String sql="select * from t_student";
		
		Query query=session.createSQLQuery(sql);
		List list=query.list();
		
		for (Object object : list) {
			Object[] objs=(Object[])object;
			System.out.println(objs[1]);
		}
		session.close();
	}
	
	@Test
	public void test17(){
		Session session=sessionFactory.openSession();
		String sql="select * from t_student";
		
		//标准的sql查询,返回的结果是数组组成的list集合
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		//该数组可以通过addEntity设置为标准的javaBean
		//这样设置后,其效果等同于使用hql查询
		sqlQuery.addEntity(Student.class);
		
		List<Student> list=sqlQuery.list();
		
		for (Student student : list) {
			System.out.println(student);
		}
		session.close();
	}
	
	@Test
	public void test18(){
		Session session=sessionFactory.openSession();
		
		//使用 :别名可以为需要动态赋值的参数赋予别名
		//在赋值时可以使用别名来为其赋值
		//这样就不需要管当前这个参数的顺序问题
		//多用于多条件查询时拼写的动态sql或动态hql
		
		String hql="from Student s where s.age > :lage and s.age < :rage";
		Query query=session.createQuery(hql);
		
		query.setInteger("rage", 31);
		
		query.setInteger("lage", 28);
		
		List<Student> list=query.list();
		for (Student student : list) {
			System.out.println(student);
		}
		
		session.close();
	}
}
