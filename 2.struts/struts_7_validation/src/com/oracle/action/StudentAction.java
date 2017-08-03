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
	
	//对当前Action中的所有方法进行验证
	/*
	@Override
	public void validate() {
		System.out.println("abcdefg");
		
		//判断所有的表单数据
		System.out.println(student);
		
		//如果存在errorField,则action不会执行,立即进入input视图
		if(student!=null){
			if( student.getName()==null || student.getName().length()==0){
				//如果检测到存在fieldError,则自动进入input视图
				addFieldError("name", "姓名不能为空");
			}
			if(student.getAge()<0 || student.getAge()>150){
				addFieldError("age", "年龄不合法");
			}
			if(student.getMobile()==null ||"".equals(student.getMobile())){
				addFieldError("mobile", "手机号不能为空");
			}
			
			if(!student.getMobile().matches("^1[34578]\\d{9}$")){
				addFieldError("mobile", "手机号格式不正确");
				
			}
		}
		
	}
	*/
	
	
	//验证指定方法
	//使用validate+需要验证表单的action方法名称,并使用驼峰标识符
	
	//比如当前actiuon的add()需要验证,则定义验证方法名为validateAdd()
	public void validateAdd(){
		System.out.println("验证add方法");
		//如果存在errorField,则action不会执行,立即进入input视图
		if(student!=null){
			if( student.getName()==null || student.getName().length()==0){
				//如果检测到存在fieldError,则自动进入input视图
				addFieldError("name", "姓名不能为空");
			}
			if(student.getAge()<0 || student.getAge()>150){
				addFieldError("age", "年龄不合法");
			}
			if(student.getMobile()==null ||"".equals(student.getMobile())){
				addFieldError("mobile", "手机号不能为空");
			}
			
			if(!student.getMobile().matches("^1[34578]\\d{9}$")){
				addFieldError("mobile", "手机号格式不正确");
				
			}
		}
	}
	
	//验证指定方法
	public void validateUpdate(){
		//如果存在errorField,则action不会执行,立即进入input视图
		if(student!=null){
			if( student.getName()==null || student.getName().length()==0){
				//如果检测到存在fieldError,则自动进入input视图
				addFieldError("name", "姓名不能为空");
			}
			if(student.getAge()<0 || student.getAge()>150){
				addFieldError("age", "年龄不合法");
			}
			if(student.getMobile()==null ||"".equals(student.getMobile())){
				addFieldError("mobile", "手机号不能为空");
			}
			
			if(!student.getMobile().matches("^1[34578]\\d{9}$")){
				addFieldError("mobile", "手机号格式不正确");
				
			}
		}
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
