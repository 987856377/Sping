package com.spring.action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TimeBook {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
//	������ݵ���س���
	public void doAuding(String name){
		logger.log(Level.INFO, name+"��ʼ���...");
//		. . . 
		logger.log(Level.INFO, name+"��˽���...");
		
	}
}
