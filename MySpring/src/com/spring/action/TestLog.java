package com.spring.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLog {
	ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
	Log log = (Log)actx.getBean("log");
//	log.getLog("skjd");
}
