package com.oracle.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracle.entity.Student;

public class StudentDao extends BaseDao{

	
	
	public List<Student> list(){
		getConn();
		List<Student>  list=new ArrayList<Student>();
		String sql="select id,name,mobile,age,address from student";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Student student=new Student(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		
		return list;
	}
	
	public Student findById(int id){
		getConn();
		
		String sql="select id,name,mobile,age,address from student where id = ?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				return new Student(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return null;
	}
	
	public void add(){
		
		
	}
	public void update(){
		
	}
	public void delete(int id){
		getConn();
		
		String sql="delete from student where id = ?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
	}
}
