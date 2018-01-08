package com.spring.action;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class LogEvent extends ApplicationEvent{

	public LogEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
