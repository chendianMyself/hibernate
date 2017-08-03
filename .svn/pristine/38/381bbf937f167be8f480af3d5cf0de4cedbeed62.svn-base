package com.oracle.intercepter;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.oracle.entity.Student;


/*
 * 1.定义一个Interceptor类,继承AbstractInterceptor
 * 
 * 2.重写其intercept方法
 *	方法参数调用invoke表示执行action中的方法
 * 其返回值为action返回的result名称
 * 
 * 3.在struts.xml的package标签中,定义interceptors标签
 * 在标签内,注册自定义的interceptor
 * 
 * 4.再在interceptors标签内,定义一个interceptor-stack
 * 在该栈中引入struts默认的20个拦截器,再引入自定义拦截器
 * 
 * 5. 设置该package的默认拦截器:default-interceptor-ref
 * 
 * */
public class MySessionInterceptor extends AbstractInterceptor{

	public String intercept(ActionInvocation invocation) throws Exception {
	
		//拦截器已经执行
		System.out.println(".....................");
		
		//加入对登录用户的判断,如果判断成功,则执行方法
		
		
		/*
		//struts推荐使用如下模式获取session对象中的值
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		Object object = sessionMap.get("stu");
		*/
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student stu=(Student) session.getAttribute("stu");
		
		String result="noPurview";
		if(stu!=null)
		//对应action返回的结果
		result=invocation.invoke();
		
		//如果判断失败,返回错误页面
		
		
		return result;
	}

	
}
