package com.oracle.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test01 {
	public static void main(String[] args) {
		//6个级别
		Logger logger=LogManager.getLogger(Test01.class);
		//log4j2使用默认的日志级别为error
		
		logger.fatal("致命错误");
		logger.error("一般错误");
		logger.warn("警告");
		logger.info("一般信息");
		logger.debug("调试模式");
		logger.trace("堆栈信息");
		
	}
}
