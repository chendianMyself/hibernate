package com.oracle.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.oracle.entity.Student;

public class TestSave {
	public static void main(String[] args) {
		
		
		Student student=new Student("赵六",11,new Date());
		
		save(student);
		
		//Teacher t=new Teacher();
		
		//save(t);
		
		
		
		
		
	}
	
	public static void save(Object obj){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hibernate", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		Class clazz=obj.getClass();
		System.out.println(clazz);
		//String sql="insert into t_student(name,age,birthDay) values(?,?,?)";
		//获取当前类的所有属性
		Field[] fs=clazz.getDeclaredFields();
		StringBuffer sql=new StringBuffer("insert into ");
		sql.append(" t_student");
		sql.append("(");
		for(int i=0;i<fs.length;i++){
			String fieldName=fs[i].getName();
			if("id".equals(fieldName))continue;
			System.out.println(fieldName);
			if("birthDay".equals(fieldName))
				fieldName="birth_day";
			sql.append(fieldName);
			sql.append(",");
		}
		if(fs.length>1){
			String temp=sql.substring(0, sql.length()-1);
			sql=new StringBuffer(temp);
		}
		
		sql.append(")");
		sql.append(" values");
		sql.append("(");
		for(int i=0;i<fs.length;i++){
			String fieldName=fs[i].getName();
			if("id".equals(fieldName))continue;
			sql.append("?");
			sql.append(",");
		}
		if(fs.length>1){
			String temp=sql.substring(0, sql.length()-1);
			sql=new StringBuffer(temp);
		}
		sql.append(")");
		
		System.out.println(sql);
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql.toString());
			for(int i=0;i<fs.length;i++){
				String fieldName=fs[i].getName();//获取字段名称
				Class type=fs[i].getType();//获取字段类型
				
				
				String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				Method getMethod=clazz.getDeclaredMethod(getMethodName);
				if("id".equals(fieldName))continue;
				
				if(type==int.class ||type == Integer.class){
					ps.setInt(i, (int)getMethod.invoke(obj));
				}else if(type==String.class){
					ps.setString(i, getMethod.invoke(obj).toString());
				}else if(type==Date.class){
					ps.setString(i, getMethod.invoke(obj).toString());
				}
			}
			ps.execute();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
