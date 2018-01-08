package com.spring.action;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.spring.imp.TimeBookInterface;

public class TimeBookProxy {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private TimeBookInterface tbi = null;

	public void setTbi(TimeBookInterface tbi) {
		this.tbi = tbi;
	}
	
	public void doAuding(String name){
		logger.log(Level.INFO, name+"¿ªÊ¼ÉóºË...");
		logger.log(Level.INFO, name+"ÉóºË½áÊø...");
	}
	
}
