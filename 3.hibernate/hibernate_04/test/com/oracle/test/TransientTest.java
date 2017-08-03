package com.oracle.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import com.oracle.entity.Student;

public class TransientTest {
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
		
		
		Student student=new Student("黑猫警长", 24, new Date());
		//调用save方法,把临态的数据转换为持久态
		session.save(student);
		
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void transistent2(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student=new Student("黑猫警长", 30, new Date());
		//调用save方法,把临态的数据转换为持久态
		session.save(student);
		/*
		 * 临态的数据调用save方法保存为持久态
		 * 在保存之后,只要事务不关闭
		 * 那么之后对这个(临态)的数据进行修改
		 * 在提交事务时,hibernate会自动对比(快照对比)这个对象与之前保存的对象是否存在变化
		 * 如果存在变化,则再次调用update语句进行修改
		 * 
		 * */
		student.setName("蓝精灵");
		
		tx.commit();
		
		session.close();
	}
	@Test
	public void transistent3(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student=new Student("黑猫警长", 30, new Date());
		//调用save方法,把临态的数据转换为持久态
		session.save(student);
		
		student.setName("蓝精灵");
		
		//这行代码没有具体意义,因为事务提交时会自动对比值进行修改
		session.update(student);
		
		
		tx.commit();
		
		session.close();
	}
	@Test
	public void transistent4(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student=new Student("黑猫警长", 30, new Date());
		//调用save方法,把临态的数据转换为持久态
		session.save(student);
		
		
		student.setName("黑猫警长");
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void transistent5(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student=new Student("黑猫警长", 30, new Date());
		//因为保存的对象是同一个,在提交事务时,缓存中只有一个对象的快照,所以只保存一次数据
		session.save(student);
		
		session.save(student);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void transistent6(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student1=new Student("黑猫警长", 30, new Date());
		Student student2=new Student("黑猫警长", 30, new Date());
		
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		
		session.close();
	}
	
	
	@Test
	public void transistent7(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student1=new Student("黑猫警长", 30, new Date());
		
		session.save(student1);
		
		System.out.println(student1.getId());
		
		tx.commit();
		
		session.close();
	}
	
	
	@Test
	public void transistent8(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student1=new Student("黑猫警长", 30, new Date());
		
		int id= (int) session.save(student1);
		
		System.out.println(id);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void transistent9(){
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Student student1=new Student("黑猫警长", 30, new Date());
		Student student2=new Student("黑猫警长", 31, new Date());
		
		int sid1 = (int)session.save(student1);
		
		
		//设置成了离线数据,但是插入数据时并不会检测id
		
		//如果将session已经管理的数据的id拿出来再次交给session管理
		//如果是同一个对象,则session会进行快照对比检查是否需要修改
		//如果不是同一个对象,则抛出异常
		student2.setId(sid1);
		session.saveOrUpdate(student2);
		
		tx.commit();
		
		session.close();
	}
	
	
	@Test
	public void transistent10(){
		//页面修改id为16的用户信息,但是不允许用户修改姓名
		Student reqParam=new Student(16,"李四", 32, new Date());
		
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//把旧数据查出来
		Student old=(Student) session.get(Student.class, reqParam.getId());
		
		reqParam.setName(old.getName());
		
		//reqParam中的name属性,用的是数据库的旧数据,其他数据跟随页面提交的参数进行修改
		session.update(reqParam);
		
		tx.commit();
		
		session.close();
	}
	
	/*
	 * 正确做法:
	 * 如果对于页面提交的参数,部分需要修改,部分不需要修改
	 * 我们应当根据要修改的数据的id,从数据库中把旧数据查出来
	 * 给旧数据  需要修改值的部分字段 ,赋予新的值
	 * 调用session,修改旧数据
	 * 
	 * 错误做法:
	 * 如果从旧数据中取出不需要修改的数据赋予新数据
	 * 那么这种设计模式应当保存新数据,这是hibernate会抛出异常
	 * 
	 * 上述错误做法,可以调用session的merge方法,来进行修改,但是不推荐使用
	 * 
	 * */
	@Test
	public void transistent11(){
		//页面修改id为16的用户信息,但是不允许用户修改姓名
		Student reqParam=new Student(16,"李四", 32, new Date());
		
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//把旧数据查出来
		Student old=(Student) session.get(Student.class, reqParam.getId());
		
		old.setAge(reqParam.getAge());
		old.setBirthDay(reqParam.getBirthDay());
		
		//reqParam中的name属性,用的是数据库的旧数据,其他数据跟随页面提交的参数进行修改
		session.update(old);
		
		tx.commit();
		
		session.close();
	}
	@Test
	public void transistent12(){
		//页面修改id为16的用户信息,但是不允许用户修改姓名
		Student reqParam=new Student(16,"赵六", 37, new Date());
		
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		//把旧数据查出来
		Student old=(Student) session.get(Student.class, reqParam.getId());
		
		reqParam.setName(old.getName());
		
		session.merge(reqParam);
		
		tx.commit();
		
		session.close();
	}
	
	
	
	
}
