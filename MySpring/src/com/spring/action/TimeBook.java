package com.spring.action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TimeBook {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
//	审核数据的相关程序
	public void doAuding(String name){
		logger.log(Level.INFO, name+"开始审核...");
//		. . . 
		logger.log(Level.INFO, name+"审核结束...");
		
	}
}
