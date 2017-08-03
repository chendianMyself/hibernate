package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.util.ReadResource;

public class BaseDao {

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	protected Connection getConn(){
		//连接jdbc获取conn
		try {
			Class.forName(ReadResource.driver);
			conn=DriverManager.getConnection(ReadResource.url, ReadResource.username, ReadResource.password);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载异常");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接地址或用户名,密码有误");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	protected void closeAll(){
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BaseDao bd=new BaseDao();
	}
}
