package com.oracle.action;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.entity.Users;

public class TestAction extends ActionSupport{
	
	private Integer id;
	private String name;
	private Integer currentPage=1;
	
	private Users users=new Users();

	public String info(){
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(users.getId());
		System.out.println(users.getName());
		
		
		if(id!=null && id==1 && "admin".equals(name)){
			return "reInfoAction";
		}
		
		return "infoPage";
	}
	
	public String add(){
		System.out.println("执行添加");
		
		System.out.println("刚才在第"+currentPage+"页");
		return "reListAction";
	}
	
	public String list(){
		System.out.println("重定向之后的页码:"+currentPage);
		System.out.println("列表数据");
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
