package com.oracle.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{

	//定义一个java.io.File类型成员变量并提供其setter方法,则文件上传定义完成
	private File abc;
	//以文件的字段名称,加上FIleName,并定义为String,提供setter,文件名能够自动获取
	private String abcFileName;
	
	public String simple(){
		
		System.out.println(abc.getAbsolutePath());
		//获取文件名的关键是为了获取文件的后缀
		System.out.println(abcFileName);
		
		
		File dest=new File("d:\\"+abcFileName);
		//将源文件复制到目标文件
		
		try {
			FileUtils.copyFile(abc, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public File getAbc() {
		return abc;
	}
	public void setAbc(File abc) {
		this.abc = abc;
	}
	public String getAbcFileName() {
		return abcFileName;
	}
	public void setAbcFileName(String abcFileName) {
		this.abcFileName = abcFileName;
	}
}
