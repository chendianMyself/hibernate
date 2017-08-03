package com.oracle.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.dao.StudentDao;
import com.oracle.entity.Student;

public class StudentAction extends ActionSupport{

	private StudentDao sd=new StudentDao();
	
	private List<Student> list;
	private Student student;
	private Integer id;
	//private Integer[] ids;
	
	public String list(){
		list=sd.list();
		return "listPage";
	}
	
	public String addPage(){
		
		return "addPage";
	}
	
	public String add(){
		System.out.println("执行添加操作......");
		//掉dao方法,插入数据
		return "reListAction";
	}
	
	public String updatePage(){
		
		return "updatePage";
	}
	
	public String update(){
		
		return "reListAction";
	}
	
	public String delete(){
		sd.delete(id);
		
		return "reListAction";
	}
	
	
	
	
	
	
	

	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
