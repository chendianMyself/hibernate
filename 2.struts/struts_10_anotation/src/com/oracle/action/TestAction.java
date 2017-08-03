package com.oracle.action;

import java.sql.SQLClientInfoException;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


/*
 * 使用注解要求包中不能包含struts字样
 * 类名必须以Action结尾
 * */
public class TestAction {

    private Integer age;
	
	
	@Action(value="test"/*,className="com.oracle.action.TestAction"*/)
	public String myTest(){
		System.out.println("12345");
		return null;
	}
	
	@Action(value="test2",results={@Result(name="success",location="success.jsp"),@Result(name="failed",location="failed.jsp")})
	public String myTest2(){
		System.out.println("12345");
		
		
		//null不能比大小
		if(age>50)return "success";
		
		return "failed";
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
