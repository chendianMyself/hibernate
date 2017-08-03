
package com.oracle.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


/*
 * 使用注解要求包中不能包含struts字样
 * 类名必须以Action结尾
 * */
//使用Namespace注解定义命名空间,该注解一般只能定义在类上
@Namespace("/student")
public class TestAction {

	private Integer age=0;
	
	
	//请求转发
	//如果没有为Result定义type属性,Result默认使用请求转发
	
	//Result注解的location地址,如果使用/开头,表示资源将会从项目的根目录下进行查找
	//如果不适用/开头,那么将自动从WEB-INF/content文件夹下查找
	//如果使用了命名空间,那么还将继续向前递进(WEB-INF/content/student)
	@Action(value="test2",results={
			@Result(name="success",location="/WEB-INF/content/success.jsp"),
			@Result(name="failed",location="/WEB-INF/content/failed.jsp")
			})
	public String myTest2(){
		System.out.println("12345");
		
		
		//null不能比大小
		if(age>50)return "success";
		
		return "failed";
	}
	
	
	
	//redirectAction因为明确重定向的目标为另一个action
	//所以通过location指定action地址时,可以省略  .action,直接使用actionName即可
	@Action(value="test3",results={
			@Result(name="redirect2Test2",type="redirectAction",location="test2")
			})
	public String myTest3(){
		System.out.println("54321");
		
		
		
	    return "redirect2Test2";
	}
	
	
	//通用的重定向,可以重定向到任何资源,包括jsp和action
	//特点通过设置type="redirect",location指定action的完整名称即可
	@Action(value="test4",results={
			@Result(name="redirect2Test2",type="redirect",location="test2.action")
			})
	public String myTest4(){
		System.out.println("54321");
		
		
		
		return "redirect2Test2";
	}
	
	
	
	@Action(value="test5",results={
			@Result(name="redirect2Test2",type="redirect",location="test2.action")
			})
	public String myTest5(){
		System.out.println("54321");
		
		List list=new ArrayList();
		
		return "redirect2Test2";
	}
	
	
	
	
	
	
	
	//如果直接为action注解赋予String类型值,表示赋予的是value的值,当前action不能再为其他属性赋值
	@Action("abc")
	public String abc(){
		System.out.println("this is abc method");
		return null;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
