package com.oracle.util;

import java.io.IOException;
import java.util.Properties;

public class ReadResource {

	
	public static String driver=null;
	public static String url=null;
	public static String username=null;
	public static String password=null;
	
	
	static{
		try {
			Properties p=new Properties();
			
			//读取配置文件
			p.load(ReadResource.class.getResourceAsStream("/jdbc.properties"));
			
			
			driver=p.getProperty("driver");
			url=p.getProperty("url");
			username=p.getProperty("username");
			password=p.getProperty("password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(username);
	}
	
}
