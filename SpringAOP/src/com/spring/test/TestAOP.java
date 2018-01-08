package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.intf.TimeNow;

public class TestAOP {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ApplicationContext actx = new ClassPathXmlApplicationContext("aop.xml");
		
		TimeNow tn1 = (TimeNow)actx.getBean("TimeNowImp1");
		TimeNow tn2 = (TimeNow)actx.getBean("TimeNowImp2");

		tn1.printBefore();
		System.out.println();
		
		tn2.printBefore();
	}
}
