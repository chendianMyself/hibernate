package com.oracle.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class MultiFileUploadAction {

	//文件数组与文件名数组
	
	//索引自动普配
	private File[] imgs;
	private String[] imgsFileName;
	
	private String[] imgName;
	
	private List<String> fileList;
	
	public String multi(){
		
		//从Application里获取当前项目在tomcat下运行的根目录
		
		//因为使用tomcat时,无法引入项目以外路径的内容
		String realPath=ServletActionContext.getServletContext().getRealPath("/");
		System.out.println(realPath);
		
		//将文件上传路径设置为项目根目录下的upload文件夹
		File path=new File(realPath+"\\upload");
		
		if(!path.exists()){
			path.mkdirs();
		}
		
		//文件路径集合
		fileList=new ArrayList<String>();
		int i=0;
		for (File src : imgs) {
			File dest=new File(path.getPath()+"\\"+imgsFileName[i]);
			try {
				FileUtils.copyFile(src, dest);
				fileList.add("upload/"+dest.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		
		return "success";
	}

	public void setImgs(File[] imgs) {
		this.imgs = imgs;
	}
	public void setImgsFileName(String[] imgsFileName) {
		this.imgsFileName = imgsFileName;
	}

	
	public List<String> getFileList() {
		return fileList;
	}
	
}
