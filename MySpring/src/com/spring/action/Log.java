package com.spring.action;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Log implements ApplicationContextAware{
	
	ApplicationContext actx = null;
	@Override
	public void setApplicationContext(ApplicationContext actx) throws BeansException {
		// TODO Auto-generated method stub
		this.actx = actx;
	}

	public int getLog(String log){
		LogEvent event = new LogEvent(log);
		this.actx.publishEvent(event);
		return 0;
	}
}
