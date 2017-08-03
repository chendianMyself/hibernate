
package com.oracle.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


@Namespace("/student")

//多个全局结果必须使用Results包裹起来,内部的多个Result形成一个数组
@Results({
	@Result(name="redirect2list",type="redirct" ,location="list.action"),
	
	//推荐自定义路径
	@Result(name="listPage",location="/WEB-INF/page/student/list.jsp"),
	
	//不建议使用默认的content/namespace/资源的方式定位jsp资源
	@Result(name="addPage",location="add.jsp"),
	@Result(name="updatePage",location="/update.jsp")
})
public class StudentAction extends BaseAction{

	
	@Action("list")
	public String list(){
		
		
		return "listPage";
	}
	
	@Action("addPage")
	public String addPage(){
		
		return "addPage";
	}
	
	
	@Action(value="add")
	public String add(){
		System.out.println("执行添加");
		return "redirect2list";
	}
	
	@Action("delete")
	public String delete(){
		System.out.println("删除操作");
		return "redirect2list";
	}
	
	@Action("updatePage")
	public String updatePage(){
		
		return "updatePage";
	}
	
	@Action("update")
	public String update(){
		
		System.out.println("修改操作");
		return "redirect2list";
	}
	
}
