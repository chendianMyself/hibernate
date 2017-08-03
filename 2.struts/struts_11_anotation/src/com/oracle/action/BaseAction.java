package com.oracle.action;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
	@Result(name="noPurview",location="/noPurview.jsp")
})

@InterceptorRefs({
	@InterceptorRef("defaultStack"),
	@InterceptorRef("sessionInterceptor")
})
public abstract class BaseAction {

}
